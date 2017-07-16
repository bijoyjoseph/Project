package com.finance.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.finance.Adapters.RequestListAdapter;
import com.finance.R;
import com.finance.Util.Const;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bijoy on 4/13/2016.
 */
public class AppoimentFragment extends Fragment implements View.OnClickListener {
    private RecyclerView requestList = null;
    private RelativeLayout rlDetailsContainer = null;
    private TextView tvDetails = null;
    private Firebase firebaseRef = null;
    private ArrayList<HashMap<String, String>> maps;
    private RequestListAdapter requestListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    private void initUi(View view) {
        requestList = (RecyclerView) view.findViewById(R.id.rvRequestList);
        rlDetailsContainer = (RelativeLayout) view.findViewById(R.id.rlDetailsContainer);
        tvDetails = (TextView) view.findViewById(R.id.tvDetails);
        requestListAdapter = new RequestListAdapter(this, getContext());
        requestList.setLayoutManager(new LinearLayoutManager(getContext()));
        requestList.setAdapter(requestListAdapter);
        rlDetailsContainer.setOnClickListener(this);

        firebaseRef = new Firebase(getResources().getString(R.string.cloud_url) + "/" + Const.FbConst.APPOINTMENT);
        Query query = firebaseRef.orderByChild(Const.FbConst.NAME);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HashMap<String, String> surveyData = (HashMap<String, String>) dataSnapshot.getValue();
                maps = new ArrayList(surveyData.values());
                requestListAdapter.setValue(maps);
                requestListAdapter.notifyDataSetChanged();
              /*  Iterable<DataSnapshot> dataSnapshots = dataSnapshot.getChildren();
                java.util.Iterator<DataSnapshot> dataSnapshotIterator = dataSnapshots.iterator();
                new Firebase(firebaseRef.getRef() + "/" + dataSnapshotIterator.next().getKey()).removeValue();*/
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        int position = 0;
        if (v.getTag() != null) {
            position = (int) v.getTag();
        }
        switch (v.getId()) {
            case R.id.rlDetailsContainer:
                setDetailScreen(null);
                break;
            case R.id.tvCalled:
                editData(maps.get(position), 1);
                break;/*
            case R.id.tvRejected:
                break;*/
            case R.id.tvHold:
                editData(maps.get(position), 2);
                break;
            default:

//       editData(maps.get(position));
                setDetailScreen("Name :" + maps.get(position).get(Const.FbConst.NAME) + "\n"
                        + "Number :" + maps.get(position).get(Const.FbConst.NUMBER) + "\n"
                        + "Product type :" + maps.get(position).get(Const.FbConst.POLICY_TYPE) + "\n"
                        + "Date :" + maps.get(position).get(Const.FbConst.DATE) + "\n"
                        + "Email :" + maps.get(position).get(Const.FbConst.EMAIL) + "\n"
                        + "Annual income :" + maps.get(position).get(Const.FbConst.ANNUAL_INCOME));
                break;
        }
    }

    private void editData(final HashMap<String, String> stringStringHashMap, final int action) {
        Query query = firebaseRef.orderByChild(Const.FbConst.NAME).equalTo(stringStringHashMap.get(Const.FbConst.NAME));
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getChildrenCount() > 0) {
                    Iterable<DataSnapshot> dataSnapshots = dataSnapshot.getChildren();
                    java.util.Iterator<DataSnapshot> dataSnapshotIterator = dataSnapshots.iterator();
                    new Firebase(firebaseRef.getRef() + "/" + dataSnapshotIterator.next().getKey()).removeValue();
                }

                Firebase firebaseRef = new Firebase(getResources().getString(R.string.cloud_url) + "/" + Const.FbConst.APPOINTMENT);
                Map<String, String> post = new HashMap<>();
                post.put(Const.FbConst.NAME, stringStringHashMap.get(Const.FbConst.NAME));
                post.put(Const.FbConst.NUMBER, stringStringHashMap.get(Const.FbConst.NUMBER));
                post.put(Const.FbConst.EMAIL, stringStringHashMap.get(Const.FbConst.EMAIL));
                post.put(Const.FbConst.CALLED, String.valueOf(action));
                post.put(Const.FbConst.DATE, stringStringHashMap.get(Const.FbConst.DATE));
                post.put(Const.FbConst.POLICY_TYPE, stringStringHashMap.get(Const.FbConst.POLICY_TYPE));
                firebaseRef.push().setValue(post);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }

    private void setDetailScreen(String details) {
        if (details != null) {
            rlDetailsContainer.setVisibility(View.VISIBLE);
            tvDetails.setText(details);
        } else {
            rlDetailsContainer.setVisibility(View.GONE);
        }
    }
}
   /* private void resetData(){
        firebaseRef = new Firebase(getResources().getString(R.string.cloud_url) + "/" + Const.FbConst.SURVEY);
        Query query = firebaseRef.orderByChild(Const.FbConst.NAME);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HashMap<String, String> surveyData = (HashMap<String, String>) dataSnapshot.getValue();
                maps = new ArrayList(surveyData.values());
                requestListAdapter.setValue(maps);
                requestListAdapter.notifyDataSetChanged();
              *//*  Iterable<DataSnapshot> dataSnapshots = dataSnapshot.getChildren();
                java.util.Iterator<DataSnapshot> dataSnapshotIterator = dataSnapshots.iterator();
                new Firebase(firebaseRef.getRef() + "/" + dataSnapshotIterator.next().getKey()).removeValue();*//*
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }*/

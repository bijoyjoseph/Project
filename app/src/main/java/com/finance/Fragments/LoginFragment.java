package com.finance.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.finance.MainActivity;
import com.finance.R;
import com.finance.Util.Const;
import com.finance.Util.PreferenceUtils;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Bijoy on 3/9/2016.
 */
public class LoginFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private EditText password = null;
    private EditText userName = null;
    private ProgressBar progressBar = null;
    private RadioGroup radioGroup = null;
    private String category = "employee";
    private TextView tvCustomer = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        initUi(view);
        return view;
    }

    /**
     * Initializing the view
     *
     * @param view - Fragment view
     */
    private void initUi(View view) {
        view.findViewById(R.id.button).setOnClickListener(this);
        password = (EditText) view.findViewById(R.id.etPassword);
        userName = (EditText) view.findViewById(R.id.etUserName);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        tvCustomer = (TextView) view.findViewById(R.id.tvCustomer);

        tvCustomer.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                PreferenceUtils.saveUserName(getContext(), userName.getText().toString());
                PreferenceUtils.saveUserType(getContext(), category);
                progressBar.setVisibility(View.VISIBLE);
                Firebase firebaseRef = new Firebase(getResources().getString(R.string.cloud_url) + "/" + category);
                Query query = firebaseRef.orderByChild(Const.FbConst.USERNAME);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        HashMap<String, String> logindata = (HashMap<String, String>) dataSnapshot.getValue();
                        ArrayList<HashMap<String, String>> maps = new ArrayList(logindata.values());
                        for (int i = 0; i < maps.size(); i++) {
                            if (maps.get(i).get(Const.FbConst.USERNAME).equals(userName.getText().toString()) && maps.get(i).get(Const.FbConst.USERNAME).equals(userName.getText().toString())) {
                                progressBar.setVisibility(View.GONE);
                                PreferenceUtils.setLoginIsDone(getContext(), true);
//                                ((MainActivity) getActivity()).addHomeScreenFragment();
                                ((MainActivity) getActivity()).addProductIllustrationFragment();
                                break;
                            } else if ((i + 1) == maps.size()) {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(getContext(), "Login failed", Toast.LENGTH_SHORT).show();
                            }

                        }

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });
//        ((MainActivity)getActivity()).addChildAdvantageFragment();
                break;
            case R.id.tvCustomer:
                PreferenceUtils.setLoginIsDone(getContext(), true);
                PreferenceUtils.saveUserType(getContext(), "customer");
//                ((MainActivity) getActivity()).addHomeScreenFragment();
                ((MainActivity) getActivity()).addSurveyFragment();
                break;

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.employeeButton:
                category = "employee";
                break;
            case R.id.agentButton:
                category = "agent";
                break;
        }
    }
}

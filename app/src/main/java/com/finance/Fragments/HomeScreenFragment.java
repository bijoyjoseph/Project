package com.finance.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finance.ChatActivity;
import com.finance.MainActivity;
import com.finance.MapsActivity;
import com.finance.PieChartActivity;
import com.finance.R;
import com.finance.Util.PreferenceUtils;

/**
 * Created by Bijoy on 3/23/2016.
 */
public class HomeScreenFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_screen,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    private void initUi(View view){
        view.findViewById(R.id.pi).setOnClickListener(this);
        view.findViewById(R.id.calc).setOnClickListener(this);
        view.findViewById(R.id.map).setOnClickListener(this);
        view.findViewById(R.id.chat).setOnClickListener(this);
        view.findViewById(R.id.graph).setOnClickListener(this);
        view.findViewById(R.id.logout).setOnClickListener(this);
        view.findViewById(R.id.survey).setOnClickListener(this);
        view.findViewById(R.id.requests).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pi:
                ((MainActivity)getActivity()).addProductIllustrationFragment();
                break;
            case R.id.survey:
                ((MainActivity)getActivity()).addSurveyFragment();
                break;
            case R.id.requests:
                ((MainActivity)getActivity()).addRequestFragment();
                break;
            case R.id.calc:
                ((MainActivity)getActivity()).addToolsAndCalcFragment();
                break;
            case R.id.map:
                startActivity(new Intent(getActivity(), MapsActivity.class));
                break;
            case R.id.chat:
                startActivity(new Intent(getActivity(), ChatActivity.class));
                break;
            case R.id.graph:
                startActivity(new Intent(getActivity(), PieChartActivity.class));
                break;
            case R.id.logout:
                PreferenceUtils.setLoginIsDone(getContext(),false);
                ((MainActivity)getActivity()).addLoginFragment();
        }
    }
}

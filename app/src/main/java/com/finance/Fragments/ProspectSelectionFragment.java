package com.finance.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finance.MainActivity;
import com.finance.R;

/**
 * Created by Bijoy on 5/17/2016.
 */
public class ProspectSelectionFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_prspects_selection,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    private void initUi(View view) {
        view.findViewById(R.id.tvSurveyDetails).setOnClickListener(this);
        view.findViewById(R.id.tvAppointments).setOnClickListener(this);
        view.findViewById(R.id.tvSubscriptions).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvSurveyDetails:
                ((MainActivity)getActivity()).addRequestFragment();
                break;
            case R.id.tvAppointments:
                ((MainActivity)getActivity()).addAppoimentFragment();
                break;
            case R.id.tvSubscriptions:
                ((MainActivity)getActivity()).addSubScriptionDetailFragment();
                break;
        }
    }
}

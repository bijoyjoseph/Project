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
 * Created by Bijoy on 3/23/2016.
 */
public class ToolsAndCalcFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tools_and_calc, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    private void initUi(View view) {
        view.findViewById(R.id.rlChildFuturePlan).setOnClickListener(this);
        view.findViewById(R.id.rlWealthCalculator).setOnClickListener(this);
        view.findViewById(R.id.rlRetirementCalculator).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rlChildFuturePlan:
                ((MainActivity)getActivity()).addChildFuturePlanFragment();
                break;
            case R.id.rlWealthCalculator:
                ((MainActivity)getActivity()).addWealthCalculatorFragment();
                break;
            case R.id.rlRetirementCalculator:
                ((MainActivity)getActivity()).addRetirementFragment();
                break;
        }
    }
}

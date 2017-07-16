package com.finance.Fragments.ProductIllustrationFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.finance.R;

/**
 * Created by Bijoy on 3/15/2016.
 */
public class TripleHealthPlanFragment extends Fragment implements TextView.OnEditorActionListener, RadioGroup.OnCheckedChangeListener {
    private EditText etSumAssured = null;
    private EditText etAnnualPremium = null;
    private boolean isMale = true;
    private EditText etAge = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_secure_income_plan, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    private void initUi(View view) {
        etAge = (EditText) view.findViewById(R.id.etAge);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rgGender);
        etSumAssured = (EditText) view.findViewById(R.id.etSumAssured);
        etAnnualPremium = (EditText) view.findViewById(R.id.etAnnualPremium);
        etAnnualPremium.setOnEditorActionListener(this);
        etSumAssured.setOnEditorActionListener(this);
        radioGroup.setOnCheckedChangeListener(this);
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        switch (v.getId()){
            case R.id.etSumAssured:
                checkData();
                break;
            case R.id.etAnnualPremium:
                checkData();
                break;
        }
        return false;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rdMale:
                isMale = true;
                checkData();
                break;
            case R.id.rdFemale:
                isMale = false;
                checkData();
                break;
        }
    }

    private void checkData(){
        if(etAge.getText().toString().isEmpty()||Integer.parseInt(etAge.getText().toString())<18&&Integer.parseInt(etAge.getText().toString())>65){
            etAge.setError("Age should be >17 & <66");
        }else {
            double annualPremium = (3.32*Integer.parseInt(etSumAssured.getText().toString()))/1000;
            etAnnualPremium.setText(String.valueOf(annualPremium));
        }
    }
}

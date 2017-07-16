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
 * Created by Bijoy on 5/11/2016.
 */
public class SuperSeriesFragment extends Fragment implements TextView.OnEditorActionListener, RadioGroup.OnCheckedChangeListener {
    private EditText etAnnualPremium = null;
    private TextView tvPaymentTerm = null;
    private TextView tvPolicyTerm = null;
    private TextView tvSumAssured = null;
    private TextView tvFifty = null;
    private TextView tvTwelve = null;
    private TextView tvFifteen = null;
    private TextView tvEighteen = null;
    private TextView tvTwentyOne = null;
    private TextView tvTwentyFour = null;
    private TextView tvTwentySeven = null;
    private TextView tvThirty = null;
    private TextView tvThirtyThree = null;
    private TextView tvThirtySix = null;
    private TextView tvHundred = null;
    private TextView tvThirtyGM = null;
    private TextView tvTotalMaturityBenefit = null;
    private EditText etAge = null;
    private boolean isMale = true;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_super_series,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intUi(view);
    }

    private void intUi(View view){
        etAnnualPremium = (EditText) view.findViewById(R.id.etAnnualPremium);
        etAge = (EditText) view.findViewById(R.id.etAge);
        tvPaymentTerm = (TextView) view.findViewById(R.id.tvPremiumTerm);
        tvPolicyTerm = (TextView) view.findViewById(R.id.tvPolicyTerm);
        tvSumAssured = (TextView) view.findViewById(R.id.tvSumAssured);

        tvFifty = (TextView)view.findViewById(R.id.tvFifty);
        tvTwelve = (TextView)view.findViewById(R.id.tvTwelve);
        tvFifteen = (TextView)view.findViewById(R.id.tvFifteen);
        tvEighteen = (TextView)view.findViewById(R.id.tvEighteen);
        tvTwentyOne = (TextView)view.findViewById(R.id.tvTwentyOne);
        tvTwentyFour = (TextView)view.findViewById(R.id.tvTwentyFour);
        tvTwentySeven = (TextView)view.findViewById(R.id.tvTwentySeven);
        tvThirty = (TextView)view.findViewById(R.id.tvThirty);
        tvThirtyThree = (TextView)view.findViewById(R.id.tvThirtyThree);
        tvThirtySix = (TextView)view.findViewById(R.id.tvThirtySix);
        tvHundred = (TextView)view.findViewById(R.id.tvHundred);
        tvThirtyGM = (TextView)view.findViewById(R.id.tvThirtyGM);
        tvTotalMaturityBenefit = (TextView)view.findViewById(R.id.tvTotalMaturityBenefit);

        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rgGender);
        radioGroup.setOnCheckedChangeListener(this);
        tvPaymentTerm.setText("20");
        tvPolicyTerm.setText("10");

        etAnnualPremium.setOnEditorActionListener(this);
        etAge.setOnEditorActionListener(this);

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        switch (v.getId()) {
            case R.id.etAnnualPremium:
                checkData();
                break;

            case R.id.etAge:
                checkData();
                break;
        }
        return false;
    }

    private void checkData() {
        int annualPremum = Integer.parseInt(etAnnualPremium.getText().toString()), age = 0, sumAssuerd = 0;
        if (!etAge.getText().toString().isEmpty()) {
            age = Integer.parseInt(etAge.getText().toString());
        }
        if(age>64&&age<-1){
            etAge.setError("age should <64 & >0");
        }else{
            if(etAnnualPremium.getText()!=null&&annualPremum>2000){
                sumAssuerd = (int) ((annualPremum * 1000)/240.82);
                tvSumAssured.setText(""+sumAssuerd);
                if(sumAssuerd>=50000&&sumAssuerd<=150000){
//band one
                }else if(sumAssuerd>=150000){
//band two
                }
            }
        }
        int valueFifty = (int) (sumAssuerd*0.5);
        int valueTwelve = (int) (sumAssuerd*0.12);
        int valueFifteen = (int) (sumAssuerd*0.15);
        int valueEighteen = (int) (sumAssuerd*0.18);
        int valueTwentyOne = (int) (sumAssuerd*0.21);
        int valueTwentyFour = (int) (sumAssuerd*0.24);
        int valueTwentySeven = (int) (sumAssuerd*0.27);
        int valueThirty = (int) (sumAssuerd*0.30);
        int valueThirtyThree = (int) (sumAssuerd*0.33);
        int valueThirtySix = (int) (sumAssuerd*0.36);
        int valueHundred = sumAssuerd;
        int valueThirtyGM = (int) (sumAssuerd*0.30);
        int valueTotalMaturityBenefit = valueFifty+ valueTwelve+valueFifteen+valueEighteen+valueTwentyOne+valueTwentyFour+
                valueTwentySeven+valueThirty+valueThirtyThree+valueThirtySix+valueHundred+valueThirtyGM;
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
}

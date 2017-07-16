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

import com.astuetz.PagerSlidingTabStrip;
import com.finance.R;
import com.finance.Util.Const;

/**
 * Created by Bijoy on 3/14/2016.
 */
public class EliteAdvantageFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, TextView.OnEditorActionListener {
    private int POLICY_TYPE = 1;
    private final int FIVE = 1;
    private final int SEVEN = 2;
    private final int TWELVE = 3;

    private TextView tvFive = null;
    private TextView tvSeven = null;
    private TextView tvTwelve = null;
    private TextView tvPolicyTerm = null;
    private TextView tvGuaranteedPayout = null;
    private TextView tvTotalGuaranteedPayout = null;
    private TextView tvSumAssured = null;
    private TextView tvTotalMaturity = null;
    private TextView tvAnnualPremium = null;
    private TextView tvSemiAnnualPremium = null;
    private TextView tvMonthlyPremium = null;
    private EditText etAnnualPremium = null;

    private EditText etAge = null;
    public boolean isMale = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_elite_advantage, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    private void initUi(View view) {
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        tvFive = (TextView) view.findViewById(R.id.tvFive);
        tvSeven = (TextView) view.findViewById(R.id.tvSeven);
        tvTwelve = (TextView) view.findViewById(R.id.tvTwelve);
        tvPolicyTerm = (TextView) view.findViewById(R.id.tvPolicyTerm);
        etAnnualPremium = (EditText) view.findViewById(R.id.etAnnualPremium);
        etAge = (EditText) view.findViewById(R.id.etAge);

        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rgGender);
        radioGroup.setOnCheckedChangeListener(this);

        tvGuaranteedPayout = (TextView) view.findViewById(R.id.tvGuaranteedPayout);
        tvTotalGuaranteedPayout = (TextView) view.findViewById(R.id.tvTotalGuaranteedPayout);
        tvSumAssured = (TextView) view.findViewById(R.id.tvSumAssured);
        tvTotalMaturity = (TextView) view.findViewById(R.id.tvTotalMaturity);
        tvAnnualPremium = (TextView) view.findViewById(R.id.tvAnnualPremium);
        tvSemiAnnualPremium = (TextView) view.findViewById(R.id.tvSemiAnnualPremium);
        tvMonthlyPremium = (TextView) view.findViewById(R.id.tvMonthlyPremium);

        tvFive.setOnClickListener(this);
        tvSeven.setOnClickListener(this);
        tvTwelve.setOnClickListener(this);

        etAnnualPremium.setOnEditorActionListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvFive:
                tvFive.setTextColor(getResources().getColor(R.color.gold));
                tvSeven.setTextColor(getResources().getColor(R.color.grey_text_color));
                tvTwelve.setTextColor(getResources().getColor(R.color.grey_text_color));
                tvPolicyTerm.setText("10");
                POLICY_TYPE = FIVE;
                checkData();
                break;
            case R.id.tvSeven:
                tvFive.setTextColor(getResources().getColor(R.color.grey_text_color));
                tvSeven.setTextColor(getResources().getColor(R.color.gold));
                tvTwelve.setTextColor(getResources().getColor(R.color.grey_text_color));
                tvPolicyTerm.setText("12");
                POLICY_TYPE = SEVEN;
                checkData();
                break;
            case R.id.tvTwelve:
                tvFive.setTextColor(getResources().getColor(R.color.grey_text_color));
                tvSeven.setTextColor(getResources().getColor(R.color.grey_text_color));
                tvTwelve.setTextColor(getResources().getColor(R.color.gold));
                tvPolicyTerm.setText("12");
                POLICY_TYPE = TWELVE;
                checkData();
                break;
        }
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

    private void checkData() {
        boolean isValidAge = false;
        int policyTerm;
        int age = 0;
        int annualPremium = 0;
        double sumAssured = 0;
        if (!etAge.getText().toString().isEmpty()) {
            age = Integer.parseInt(etAge.getText().toString());
        }

        annualPremium = Integer.parseInt(etAnnualPremium.getText().toString());
        double guarenteedPayout = 0;
        double guarenteedPercentage = 0;
        switch (POLICY_TYPE) {
            case FIVE:
                if (annualPremium >= 24000 && annualPremium < 50000) {
                    guarenteedPercentage = 0.085;
                    guarenteedPayout = 10;
                } else if (annualPremium >= 50000 && annualPremium < 100000) {
                    guarenteedPercentage = 0.09;
                    guarenteedPayout = 10;
                } else if (annualPremium >= 100000) {
                    guarenteedPercentage = 0.095;
                    guarenteedPayout = 10;
                }
                break;
            case SEVEN:
                if (annualPremium >= 18000 && annualPremium < 50000) {
                    guarenteedPercentage = 0.085;
                    guarenteedPayout = 8;
                } else if (annualPremium >= 50000 && annualPremium < 100000) {
                    guarenteedPercentage = 0.09;
                    guarenteedPayout = 8;
                } else if (annualPremium >= 100000) {
                    guarenteedPercentage = 0.095;
                    guarenteedPayout = 8;
                }
                break;
            case TWELVE:
                if (annualPremium >= 12000 && annualPremium < 50000) {
                    guarenteedPercentage = 0.085;
                    guarenteedPayout = 8;
                } else if (annualPremium >= 50000 && annualPremium < 100000) {
                    guarenteedPercentage = 0.09;
                    guarenteedPayout = 8;
                } else if (annualPremium >= 100000) {
                    guarenteedPercentage = 0.095;
                    guarenteedPayout = 8;
                }
                break;
        }

        if (etAnnualPremium.getText().toString().equals("12")) {
            if (age > 7 && age < 64) {
                isValidAge = true;
            }else{
                etAge.setError("age should <7 & >64");
                isValidAge = false;
            }
        } else {
            if (age > 4 && age < 64) {
                isValidAge = true;
            }else{
                etAge.setError("age should <4 & >64");
                isValidAge = false;
            }
        }

        if (isValidAge) {
            switch (POLICY_TYPE) {
                case FIVE:
                    if (isMale) {
                        sumAssured = ((annualPremium * 1000)/ Const.policyTerm5yearsMaleEliteAdvantage[age]);
                    } else {
                        sumAssured = ((annualPremium * 1000)/ Const.policyTerm5yearsFemaleEliteAdvantage[age]);
                    }
                    break;
                case SEVEN:
                    if (isMale) {
                        sumAssured =  ((annualPremium * 1000)/ Const.policyTerm7yearsMaleEliteAdvantage[age]);
                    } else {
                        sumAssured =  ((annualPremium * 1000)/ Const.policyTerm7yearsFemaleEliteAdvantage[age]);
                    }
                    break;
                case TWELVE:
                    if (isMale) {
                        sumAssured =  ((annualPremium * 1000)/ Const.policyTerm12yearsMaleEliteAdvantage[age]);
                    } else {
                        sumAssured =  ((annualPremium * 1000)/ Const.policyTerm12yearsFemaleEliteAdvantage[age]);
                    }
                    break;
            }

            tvSumAssured.setText(""+(int)sumAssured);
            int guarenteedPayoutPA = (int) (sumAssured*guarenteedPercentage);
            tvGuaranteedPayout.setText(""+guarenteedPayoutPA);
            int totalGuarenteedPayout = (int) (guarenteedPayout*guarenteedPayoutPA);
            tvTotalGuaranteedPayout.setText(""+totalGuarenteedPayout);
            int totalBenififts = (int) (sumAssured + totalGuarenteedPayout);
            tvTotalMaturity.setText(""+totalBenififts);
            tvAnnualPremium.setText(etAnnualPremium.getText().toString());
            int semiAnnualPremoium  = (int) ((Integer.parseInt(etAnnualPremium.getText().toString())*1.02)/2);
            tvSemiAnnualPremium.setText(""+semiAnnualPremoium);
            int semiMonthlyPremoium  = (int) ((Integer.parseInt(etAnnualPremium.getText().toString())*1.0404)/12);
            tvMonthlyPremium.setText(""+semiMonthlyPremoium);


        }

       /* if (!etAnnualPremium.getText().toString().isEmpty()) {
            annualPremium = Integer.parseInt(etAnnualPremium.getText().toString());
        }
        policyTerm = Integer.parseInt(tvPolicyTerm.getText().toString());
        if (policyTerm == 20) {
            if (age >= 8 && age <= 65) {
                if (annualPremium >= 30000) {
                    Utility.sendData(new PremiumData(age, annualPremium, policyTerm, isMale), tabsPagerAdapter.getFragment(pager.getCurrentItem()));
                } else {
                    etAnnualPremium.setError("Should be > 30k");
                }
            } else {
                etAge.setError("Between 8 and 65");
            }
        } else if (policyTerm == 25) {
            if (age >= 3 && age <= 60) {
                if (annualPremium >= 24000) {
                    Utility.sendData(new PremiumData(age, annualPremium, policyTerm, isMale), tabsPagerAdapter.getFragment(pager.getCurrentItem()));
                } else {
                    etAnnualPremium.setError("Should be > 24k");
                }
            } else {
                etAge.setError("Between 3 and 60");
            }
        } else if (policyTerm == 30) {
            if (age >= 0 && age <= 55) {
                if (annualPremium >= 15000) {
                    Utility.sendData(new PremiumData(age, annualPremium, policyTerm, isMale), tabsPagerAdapter.getFragment(pager.getCurrentItem()));
                } else {
                    etAnnualPremium.setError("Should be > 15k");
                }
            } else {
                etAge.setError("Between 0 and 55");
            }
        }*/
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        switch (v.getId()) {
            case R.id.etAge:
                checkData();
                break;

            case R.id.etAnnualPremium:
                checkData();
                break;
        }
        return false;
    }
}

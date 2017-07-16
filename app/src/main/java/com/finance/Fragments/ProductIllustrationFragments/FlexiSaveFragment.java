package com.finance.Fragments.ProductIllustrationFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.finance.Adapters.TabsPagerAdapter.FlexiPagerAdapter;
import com.finance.Data.PremiumData;
import com.finance.R;
import com.finance.Util.Utility;

/**
 * Created by Bijoy on 3/15/2016.
 */
public class FlexiSaveFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener, TextView.OnEditorActionListener, RadioGroup.OnCheckedChangeListener {
    private ViewPager pager = null;
    private FlexiPagerAdapter tabsPagerAdapter = null;
    private TextView tvFive = null;
    private TextView tvSeven = null;
    private TextView tvTwelve = null;
    private TextView tvPolicyTerm = null;
    private TextView tvFlexiBenefit = null;
    private EditText etAnnualPremium = null;
    private EditText etAge = null;
    public boolean isMale = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_flexi_save, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    private void initUi(View view) {
        pager = (ViewPager) view.findViewById(R.id.pager);
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        tabsPagerAdapter = new FlexiPagerAdapter(getActivity().getSupportFragmentManager());

        tvFive = (TextView) view.findViewById(R.id.tvPaymentFive);
        tvSeven = (TextView) view.findViewById(R.id.tvPaymentSeven);
        tvTwelve = (TextView) view.findViewById(R.id.tvPaymentTwelve);
        tvPolicyTerm = (TextView) view.findViewById(R.id.tvPolicyTerm);
        tvFlexiBenefit = (TextView) view.findViewById(R.id.tvFlexiBenifit);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rgGender);

        etAnnualPremium = (EditText) view.findViewById(R.id.etAnnualPremium);
        etAge = (EditText) view.findViewById(R.id.etAge);

        tvFive.setOnClickListener(this);
        tvSeven.setOnClickListener(this);
        tvTwelve.setOnClickListener(this);
        etAnnualPremium.setOnEditorActionListener(this);
        etAge.setOnEditorActionListener(this);
        radioGroup.setOnCheckedChangeListener(this);

        pager.setAdapter(tabsPagerAdapter);
        tabs.setShouldExpand(true);
        tabs.setAllCaps(false);
        tabs.setViewPager(pager);
        tabs.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        checkData();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvPaymentFive:
                tvFive.setTextColor(getActivity().getResources().getColor(R.color.blue));
                tvSeven.setTextColor(getActivity().getResources().getColor(R.color.grey_text_color));
                tvTwelve.setTextColor(getActivity().getResources().getColor(R.color.grey_text_color));
                tvPolicyTerm.setText("20");
                tvFlexiBenefit.setText("10-20");
                break;
            case R.id.tvPaymentSeven:
                tvFive.setTextColor(getActivity().getResources().getColor(R.color.grey_text_color));
                tvSeven.setTextColor(getActivity().getResources().getColor(R.color.blue));
                tvTwelve.setTextColor(getActivity().getResources().getColor(R.color.grey_text_color));
                tvPolicyTerm.setText("25");
                tvFlexiBenefit.setText("15-25");
                break;
            case R.id.tvPaymentTwelve:
                tvFive.setTextColor(getActivity().getResources().getColor(R.color.grey_text_color));
                tvSeven.setTextColor(getActivity().getResources().getColor(R.color.grey_text_color));
                tvTwelve.setTextColor(getActivity().getResources().getColor(R.color.blue));
                tvPolicyTerm.setText("30");
                tvFlexiBenefit.setText("20-30");
                break;
        }
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

    private void checkData() {
        int policyTerm, age = 0, annualPremium = 0;
        if (!etAge.getText().toString().isEmpty()) {
            age = Integer.parseInt(etAge.getText().toString());
        }
        if (!etAnnualPremium.getText().toString().isEmpty()) {
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
}

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
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.finance.Adapters.TabsPagerAdapter.AajeevanPagerAdapter;
import com.finance.R;

/**
 * Created by Bijoy on 3/14/2016.
 */
public class AajeevanSampathiFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener, TextView.OnEditorActionListener {
    private ViewPager pager = null;
    private AajeevanPagerAdapter tabsPagerAdapter = null;
    private TextView tvPremiumTen = null;
    private TextView tvPremiumFifteen = null;
    private TextView tvBenefitEF = null;
    private TextView tvBenefitHundred = null;
    private TextView tvPolicyItem = null;
    private EditText etAnnualPremium = null;
    private EditText etGuaranteedPayout = null;
    private EditText etAge = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_aajeevan_sampathi, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    private void initUi(View view) {
        pager = (ViewPager) view.findViewById(R.id.pager);
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        tabsPagerAdapter = new AajeevanPagerAdapter(getActivity().getSupportFragmentManager());

        tvPremiumTen = (TextView) view.findViewById(R.id.tvPremiumTen);
        tvPremiumFifteen = (TextView) view.findViewById(R.id.tvPremiumFifteen);
        tvBenefitEF = (TextView) view.findViewById(R.id.tvBenefitEF);
        tvBenefitHundred = (TextView) view.findViewById(R.id.tvBenefitHundred);
        tvPolicyItem = (TextView) view.findViewById(R.id.tvPolicyItem);
        etAnnualPremium = (EditText) view.findViewById(R.id.etAnnualPremium);
        etGuaranteedPayout = (EditText) view.findViewById(R.id.etGuaranteedPayout);
        etAge = (EditText) view.findViewById(R.id.etAge);

        tvPremiumTen.setOnClickListener(this);
        tvPremiumFifteen.setOnClickListener(this);
        tvBenefitEF.setOnClickListener(this);
        tvBenefitHundred.setOnClickListener(this);
        tvPolicyItem.setOnClickListener(this);

        etAnnualPremium.setOnEditorActionListener(this);
        etGuaranteedPayout.setOnEditorActionListener(this);

        etAge.setOnEditorActionListener(this);

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

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvPremiumTen:
                tvPremiumTen.setTextColor(getActivity().getResources().getColor(R.color.gold));
                tvPremiumFifteen.setTextColor(getActivity().getResources().getColor(R.color.grey_text_color));
                break;
            case R.id.tvPremiumFifteen:
                tvPremiumFifteen.setTextColor(getActivity().getResources().getColor(R.color.gold));
                tvPremiumTen.setTextColor(getActivity().getResources().getColor(R.color.grey_text_color));
                break;
            case R.id.tvBenefitEF:
                tvBenefitEF.setTextColor(getActivity().getResources().getColor(R.color.gold));
                tvBenefitHundred.setTextColor(getActivity().getResources().getColor(R.color.grey_text_color));
                tvPolicyItem.setText("85");
                break;
            case R.id.tvBenefitHundred:
                tvBenefitHundred.setTextColor(getActivity().getResources().getColor(R.color.gold));
                tvBenefitEF.setTextColor(getActivity().getResources().getColor(R.color.grey_text_color));
                tvPolicyItem.setText("100");
                break;
            case R.id.tvPolicyItem:
                break;
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        switch (v.getId()) {
            case R.id.etAnnualPremium:
                checkData();
                break;
            case R.id.etGuaranteedPayout:
                checkData();
                break;
            case R.id.etAge:
                checkData();
                break;
        }
        return false;
    }

    private void checkData() {
        int policyTerm, age = 0, guarenteedPayout = 0;
        if (!etAge.getText().toString().isEmpty()) {
            age = Integer.parseInt(etAge.getText().toString());
        }
        if (!etAnnualPremium.getText().toString().isEmpty()) {
            guarenteedPayout = Integer.parseInt(etAnnualPremium.getText().toString());
        }
        policyTerm = Integer.parseInt(etGuaranteedPayout.getText().toString());

        switch (tvPolicyItem.getText().toString()) {
            case "85":
                if (age > 50 && age < 1) {
                    etAge.setError("Should be >1 & <60");
                }
                break;
            case "100":
                if (age > 60 && age < 1) {
                    etAge.setError("Should be >1 & <60");
                }
                break;
        }
    }
}

package com.finance.Fragments.ProductIllustrationFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.finance.Adapters.TabsPagerAdapter.MonthlyIncomeAdapter;
import com.finance.R;

/**
 * Created by Bijoy on 3/15/2016.
 */
public class MonthlyIncomePlanFrgment extends Fragment implements ViewPager.OnPageChangeListener {
    private ViewPager pager = null;
    private MonthlyIncomeAdapter tabsPagerAdapter = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_monthly_income,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    private void initUi(View view){
        pager = (ViewPager) view.findViewById(R.id.pager);
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        tabsPagerAdapter = new MonthlyIncomeAdapter(getActivity().getSupportFragmentManager());

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
}

package com.finance.Fragments.ProductIllustrationFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.finance.Adapters.TabsPagerAdapter.SamridhiPagerAdapter;
import com.finance.R;
import com.finance.Util.Const;

/**
 * Created by Bijoy on 3/12/2016.
 */
public class SamridhiFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private TextView tvLimited = null;
    private TextView tvRegular = null;
    private TextView tvEndowment = null;
    private TextView tvMoneyBack = null;
    private SamridhiPagerAdapter tabsPagerAdapter = null;
    private ViewPager pager = null;
    private int payType = Const.PayTypeConst.LIMITED;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_samridhi, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    private void initUi(View view) {
        tvLimited = (TextView) view.findViewById(R.id.tvLimited);
        tvRegular = (TextView) view.findViewById(R.id.tvRegular);

        pager = (ViewPager) view.findViewById(R.id.pager);
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        tabsPagerAdapter = new SamridhiPagerAdapter(getActivity().getSupportFragmentManager());

        pager.setAdapter(tabsPagerAdapter);
        tabs.setShouldExpand(true);
        tabs.setAllCaps(false);
        tabs.setViewPager(pager);

        tvLimited.setOnClickListener(this);
        tvRegular.setOnClickListener(this);
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
            case R.id.tvLimited:
                payType = Const.PayTypeConst.LIMITED;
                tvLimited.setTextColor(getActivity().getResources().getColor(R.color.blue));
                tvRegular.setTextColor(getActivity().getResources().getColor(R.color.grey));
                break;
            case R.id.tvRegular:
                payType = Const.PayTypeConst.REGULAR;
                tvRegular.setTextColor(getActivity().getResources().getColor(R.color.blue));
                tvLimited.setTextColor(getActivity().getResources().getColor(R.color.grey));
                break;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}

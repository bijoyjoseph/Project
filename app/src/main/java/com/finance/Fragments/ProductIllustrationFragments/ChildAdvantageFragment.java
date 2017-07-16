package com.finance.Fragments.ProductIllustrationFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.finance.Adapters.TabsPagerAdapter.ChildAdvantagePagerAdapter;
import com.finance.R;
import com.finance.Util.Const;
import com.finance.Util.Utility;

/**
 * Created by Bijoy on 3/9/2016.
 */
public class ChildAdvantageFragment extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, ViewPager.OnPageChangeListener {
    private TextView tvLimited = null;
    private TextView tvRegular = null;
    private TextView tvEndowment = null;
    private TextView tvMoneyBack = null;
    private TextView tvSeekProgress = null;
    private ChildAdvantagePagerAdapter tabsPagerAdapter = null;
    private PagerSlidingTabStrip tabs = null;
    private ViewPager pager = null;
    private TextView tvPremiumPaymentTerm = null;
    private int payType = Const.PayTypeConst.LIMITED;

    private SeekBar seekBar = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_child_advantage, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    /**
     * Initializing the view
     *
     * @param view - Fragment view
     */
    private void initUi(View view) {
        tvLimited = (TextView) view.findViewById(R.id.tvLimited);
        tvRegular = (TextView) view.findViewById(R.id.tvRegular);
        tvEndowment = (TextView) view.findViewById(R.id.tvEndowment);
        tvMoneyBack = (TextView) view.findViewById(R.id.tvMoneyBack);
        tvPremiumPaymentTerm = (TextView) view.findViewById(R.id.tvPremiumPaymentTerm);
        tvSeekProgress = (TextView) view.findViewById(R.id.tvSeekProgress);
        seekBar = (SeekBar) view.findViewById(R.id.seekBar);

        pager = (ViewPager) view.findViewById(R.id.pager);
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        tabsPagerAdapter = new ChildAdvantagePagerAdapter(getActivity().getSupportFragmentManager());

        pager.setAdapter(tabsPagerAdapter);
        tabs.setShouldExpand(true);
        tabs.setAllCaps(false);
        tabs.setViewPager(pager);

        tvLimited.setOnClickListener(this);
        tvRegular.setOnClickListener(this);
        tvEndowment.setOnClickListener(this);
        tvMoneyBack.setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(this);
        tabs.setOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvLimited:
                int term = 6 + (seekBar.getProgress() / 10);
                tvPremiumPaymentTerm.setText(String.valueOf(term));
                payType = Const.PayTypeConst.LIMITED;
                tvLimited.setTextColor(getActivity().getResources().getColor(R.color.blue));
                tvRegular.setTextColor(getActivity().getResources().getColor(R.color.grey));
                break;
            case R.id.tvRegular:
                int regularTerm = 11 + (seekBar.getProgress() / 10);
                tvPremiumPaymentTerm.setText(String.valueOf(regularTerm));
                payType = Const.PayTypeConst.REGULAR;
                tvRegular.setTextColor(getActivity().getResources().getColor(R.color.blue));
                tvLimited.setTextColor(getActivity().getResources().getColor(R.color.grey));
                break;
            case R.id.tvEndowment:
                tvEndowment.setTextColor(getActivity().getResources().getColor(R.color.blue));
                tvMoneyBack.setTextColor(getActivity().getResources().getColor(R.color.grey));
                Utility.changeMode(Const.PolicyConst.ENDOWMENT, tabsPagerAdapter.getFragment(pager.getCurrentItem()));
                break;
            case R.id.tvMoneyBack:
                tvMoneyBack.setTextColor(getActivity().getResources().getColor(R.color.blue));
                tvEndowment.setTextColor(getActivity().getResources().getColor(R.color.grey));
                Utility.changeMode(Const.PolicyConst.MONEY_BACK, tabsPagerAdapter.getFragment(pager.getCurrentItem()));
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int seek = (progress / 10) + 11;
        tvSeekProgress.setText(String.valueOf(seek));
        if (payType == Const.PayTypeConst.REGULAR) {
            tvPremiumPaymentTerm.setText(String.valueOf(seek));
        } else {
            tvPremiumPaymentTerm.setText(String.valueOf(seek - 5));
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tvEndowment.setTextColor(getActivity().getResources().getColor(R.color.blue));
        tvMoneyBack.setTextColor(getActivity().getResources().getColor(R.color.grey));
        Utility.changeMode(Const.PolicyConst.ENDOWMENT, tabsPagerAdapter.getFragment(position));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onStop() {
        Log.e("tag", "Onstop child advantage fragment");
        super.onStop();
    }
}

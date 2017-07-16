package com.finance.Adapters.TabsPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.finance.Fragments.ProductIllustrationFragments.EightFragments.ChildAdvantageEightFragment;
import com.finance.Fragments.ProductIllustrationFragments.FourFragments.ChildAdvantageFourFragment;

public class ChildAdvantagePagerAdapter extends FragmentPagerAdapter {
    private ChildAdvantageEightFragment eightPercentageFragment = null;
    private ChildAdvantageFourFragment fourPercentageFragment = null;

    private final String[] title = {"8% RATE", "4% RATE"};


    public ChildAdvantagePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                Log.e("TAG", "0");
                if (eightPercentageFragment == null) {
                    eightPercentageFragment = new ChildAdvantageEightFragment();
                }
                return eightPercentageFragment;
            case 1:
                Log.e("TAG", "1");
                if (fourPercentageFragment == null) {
                    fourPercentageFragment = new ChildAdvantageFourFragment();
                }
                return fourPercentageFragment;
        }
        return null;
    }

    public Fragment getFragment(int index) {
        switch (index) {
            case 0:
                return eightPercentageFragment;
            case 1:
                return fourPercentageFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}

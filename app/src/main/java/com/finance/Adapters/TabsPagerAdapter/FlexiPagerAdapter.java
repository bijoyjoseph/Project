package com.finance.Adapters.TabsPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.finance.Fragments.ProductIllustrationFragments.EightFragments.FlexiSaveEightFragment;
import com.finance.Fragments.ProductIllustrationFragments.FourFragments.FlexiSaveFourFragment;


public class FlexiPagerAdapter extends FragmentPagerAdapter {
    private FlexiSaveEightFragment eightPercentageFragment = null;
    private FlexiSaveFourFragment fourPercentageFragment = null;

    private final String[] title = {"8% RATE", "4% RATE"};


    public FlexiPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                if (eightPercentageFragment == null) {
                    eightPercentageFragment = new FlexiSaveEightFragment();
                }
                return eightPercentageFragment;
            case 1:
                if (fourPercentageFragment == null) {
                    fourPercentageFragment = new FlexiSaveFourFragment();
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

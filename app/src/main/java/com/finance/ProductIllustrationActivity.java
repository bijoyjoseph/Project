package com.finance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.finance.Fragments.ProductIllustrationFragments.AajeevanSampathiFragment;
import com.finance.Fragments.ProductIllustrationFragments.ChildAdvantageFragment;
import com.finance.Fragments.ProductIllustrationFragments.EliteAdvantageFragment;
import com.finance.Fragments.ProductIllustrationFragments.FlexiSaveFragment;
import com.finance.Fragments.ProductIllustrationFragments.MonthlyIncomePlanFrgment;
import com.finance.Fragments.ProductIllustrationFragments.SamridhiFragment;
import com.finance.Fragments.ProductIllustrationFragments.SecureSavingsPlanFragment;
import com.finance.Fragments.ProductIllustrationFragments.SuperSeriesFragment;
import com.finance.Fragments.ProductIllustrationFragments.TripleHealthPlanFragment;
import com.finance.Util.Const;

public class ProductIllustrationActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_illustration);

        if (savedInstanceState != null) {
            popAllFragments();
        } else {
            initializeScreen(getIntent().getStringExtra(Const.IntentConst.LIST_POSITION));
            /*calling first screen to show*/
        }
    }

    /**
     * Method to initialize the screen
     */
    private void initializeScreen(String s) {
        switch (s) {
            case "0":
                addChildAdvantageFragment();
                break;
            case "1":
                addSamridhiFragment();
                break;
            case "2":
                addEliteAdvantageFragment();
                break;
            case "3":
                addAajeevanSampathiFragment();
                break;
            case "4":
                addSecureIncomePlanFragment();
                break;
         /*   case "5":
                addSecureSavingsPlanFragment();
                break;*/
            case "5":
                addFlexiSave();
                break;
            case "6":
                addMonthlyIncomePlanFragment();
            case "7":
                addSuperSeriesFragment();
                break;
        }
    }

    /**
     * add fragments in the specific frame layouts
     */
    private void addFragments(Fragment fragment, boolean addToBackStack, boolean isAdd, int animationType, String tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        setAnimationToFragment(animationType, fragmentTransaction);

        if (isAdd) {
            fragmentTransaction.add(R.id.fragmentContainer, fragment, tag); /*adds fragments on top of another fragment*/
        } else {
            fragmentTransaction.replace(R.id.fragmentContainer, fragment, tag); /*replaces the current fragment after
            that it adds new fragment*/
        }
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(tag); /*save the fragment in a stack*/
        }

        fragmentTransaction.commit();
    }

    /**
     * setting fragment animation
     */
    private void setAnimationToFragment(int animationType, FragmentTransaction fragmentTransaction) {
        switch (animationType) {
            case Const.AnimConst.RIGHT_TO_LEFT_ANIM: {
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                        R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            }
            case Const.AnimConst.LEFT_TO_RIGHT_ANIM: {
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right,
                        R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            }
            case Const.AnimConst.FADE_OUT_ANIM: {
                fragmentTransaction.setCustomAnimations(R.anim.fast_fade_in, R.anim.fast_fade_out);
                break;
            }
            case Const.AnimConst.NO_ANIM: {
                break;
            }
        }
    }

    /**
     * removes all fragments from the stack
     */
    private void popAllFragments() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        for (int i = 0; i < count; i++) {
            getSupportFragmentManager().popBackStackImmediate();
        }
    }

    public void addChildAdvantageFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(ChildAdvantageFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new ChildAdvantageFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.NO_ANIM, ChildAdvantageFragment.class.getSimpleName());
    }

    public void addSamridhiFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(SamridhiFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new SamridhiFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.NO_ANIM, SamridhiFragment.class.getSimpleName());
    }

    public void addEliteAdvantageFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(EliteAdvantageFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new EliteAdvantageFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.NO_ANIM, EliteAdvantageFragment.class.getSimpleName());
    }

    public void addAajeevanSampathiFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(AajeevanSampathiFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new AajeevanSampathiFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.NO_ANIM, AajeevanSampathiFragment.class.getSimpleName());
    }

    public void addSecureIncomePlanFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(TripleHealthPlanFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new TripleHealthPlanFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.NO_ANIM, TripleHealthPlanFragment.class.getSimpleName());
    }

    public void addSecureSavingsPlanFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(SecureSavingsPlanFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new SecureSavingsPlanFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.NO_ANIM, SecureSavingsPlanFragment.class.getSimpleName());
    }

    public void addFlexiSave() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(FlexiSaveFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new FlexiSaveFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.NO_ANIM, FlexiSaveFragment.class.getSimpleName());
    }

    public void addMonthlyIncomePlanFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(MonthlyIncomePlanFrgment.class.getSimpleName());
        if (fragment == null) {
            fragment = new MonthlyIncomePlanFrgment();
        }
        addFragments(fragment, false, false, Const.AnimConst.NO_ANIM, MonthlyIncomePlanFrgment.class.getSimpleName());
    }

    public void addSuperSeriesFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(SuperSeriesFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new SuperSeriesFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.NO_ANIM, SuperSeriesFragment.class.getSimpleName());
    }

}

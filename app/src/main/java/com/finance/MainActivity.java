package com.finance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.finance.Adapters.NavDrawerListAdapter;
import com.finance.Fragments.AppoimentFragment;
import com.finance.Fragments.ContactFragment;
import com.finance.Fragments.FixAppoinmentFragment;
import com.finance.Fragments.HomeScreenFragment;
import com.finance.Fragments.LoginFragment;
import com.finance.Fragments.ProductDetailsFragment;
import com.finance.Fragments.ProductIllustrationFragment;
import com.finance.Fragments.ProspectSelectionFragment;
import com.finance.Fragments.RenewalFragment;
import com.finance.Fragments.RequestFragment;
import com.finance.Fragments.SplashScreenFragment;
import com.finance.Fragments.SubScriptionDetailFragment;
import com.finance.Fragments.SubScriptionfragment;
import com.finance.Fragments.SurveyFragment;
import com.finance.Fragments.ToolsAndCalc.ChildFuturePlanFragment;
import com.finance.Fragments.ToolsAndCalc.RetirementCalculatorFragment;
import com.finance.Fragments.ToolsAndCalc.WealthCalculatorFragment;
import com.finance.Fragments.ToolsAndCalcFragment;
import com.finance.Util.Const;
import com.finance.Util.PreferenceUtils;
import com.firebase.client.Firebase;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private DrawerLayout drawerLayout = null;
    private ListView drawerList = null;
    private NavDrawerListAdapter drawerListAdapter = null;
    private String userType = null;
    private TextView tvMenu = null;
    private View headerView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        /*Firebase firebaseRef = new Firebase(getResources().getString(R.string.cloud_url)+"/employee");

        Map<String, String> post = new HashMap<>();
        post.put(Const.FbConst.USERNAME, "bijoy");
        post.put(Const.FbConst.PASSWORD, "123456");
        firebaseRef.push().setValue(post);*/

        initUi();

        if (savedInstanceState != null) {
            popAllFragments();
        } else {
            initializeScreen();
            /*calling first screen to show*/
        }
    }

    private void initUi() {
        headerView = findViewById(R.id.inHeader);
        tvMenu = (TextView) findViewById(R.id.tvMenu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerList = (ListView) findViewById(R.id.lvNavigationBarListView);
//        menuButton = (ImageButton) findViewById(R.id.ibMenu);
        tvMenu.setOnClickListener(this);
        setUpNavigationDrawer();
    }

    private void setEnableDrawer(boolean isEnable) {
        if (isEnable) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            headerView.setVisibility(View.VISIBLE);
        } else {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            headerView.setVisibility(View.GONE);
        }
    }

    private void setUpNavigationDrawer() {
        userType = PreferenceUtils.getUserType(this);
        switch (userType) {
            case "employee":
                drawerListAdapter = new NavDrawerListAdapter(getApplicationContext(), getResources().getStringArray(R.array.navigation_items_employee), this);
                drawerListAdapter.setHighlightPosition(0);
                drawerList.setAdapter(drawerListAdapter);
                break;
            case "agent":
                drawerListAdapter = new NavDrawerListAdapter(getApplicationContext(), getResources().getStringArray(R.array.navigation_items_agent), this);
                drawerListAdapter.setHighlightPosition(0);
                drawerList.setAdapter(drawerListAdapter);
                break;
            case "customer":
                drawerListAdapter = new NavDrawerListAdapter(getApplicationContext(), getResources().getStringArray(R.array.navigation_items_customer), this);
                drawerListAdapter.setHighlightPosition(0);
                drawerList.setAdapter(drawerListAdapter);
                break;
        }
    }

    /**
     * Method to initialize the screen
     */
    private void initializeScreen() {
        if (PreferenceUtils.isLoginIsDone(getApplicationContext())) {
//            addHomeScreenFragment();
            if (PreferenceUtils.getUserType(this).equals("customer")) {
                addProductDetailsFragment();
            } else {
                addProductIllustrationFragment();
            }
        } else {
            setEnableDrawer(false);
            addSplashScreenFragment();
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

    private void addSplashScreenFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(SplashScreenFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new SplashScreenFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.NO_ANIM, SplashScreenFragment.class.getSimpleName());
    }

    public void addLoginFragment() {
        setEnableDrawer(false);
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(LoginFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new LoginFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.FADE_OUT_ANIM, LoginFragment.class.getSimpleName());
    }

    public void addHomeScreenFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(HomeScreenFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new HomeScreenFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, HomeScreenFragment.class.getSimpleName());
    }

  /*  public void addChildAdvantageFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(ChildAdvantageFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new ChildAdvantageFragment();
        }
        addFragments(fragment, true, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, ChildAdvantageFragment.class.getSimpleName());
    }*/

    public void addProductIllustrationFragment() {
        setUpNavigationDrawer();
        setEnableDrawer(true);
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(ProductIllustrationFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new ProductIllustrationFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, ProductIllustrationFragment.class.getSimpleName());
    }

    public void addSurveyFragment() {
        setUpNavigationDrawer();
        setEnableDrawer(true);
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(SurveyFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new SurveyFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, SurveyFragment.class.getSimpleName());
    }

    public void addFixAppoimentFragment() {
        setUpNavigationDrawer();
        setEnableDrawer(true);
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(FixAppoinmentFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new FixAppoinmentFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, FixAppoinmentFragment.class.getSimpleName());
    }

    public void addProductDetailsFragment() {
        setEnableDrawer(true);
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(ProductDetailsFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new ProductDetailsFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, ProductDetailsFragment.class.getSimpleName());
    }

    public void addRequestFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(RequestFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new RequestFragment();
        }
        addFragments(fragment, true, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, RequestFragment.class.getSimpleName());
    }

    public void addAppoimentFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(AppoimentFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new AppoimentFragment();
        }
        addFragments(fragment, true, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, AppoimentFragment.class.getSimpleName());
    }

    public void addSubScriptionDetailFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(SubScriptionDetailFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new SubScriptionDetailFragment();
        }
        addFragments(fragment, true, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, SubScriptionDetailFragment.class.getSimpleName());
    }

    public void addRenewalFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(RenewalFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new RenewalFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, RenewalFragment.class.getSimpleName());
    }

    public void addSubscriptionFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(SubScriptionfragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new SubScriptionfragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, SubScriptionfragment.class.getSimpleName());
    }

    public void addContactFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(ContactFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new ContactFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, ContactFragment.class.getSimpleName());
    }

    public void addToolsAndCalcFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(ToolsAndCalcFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new ToolsAndCalcFragment();
        }
        addFragments(fragment, true, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, ToolsAndCalcFragment.class.getSimpleName());
    }

    public void addChildFuturePlanFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(ChildFuturePlanFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new ChildFuturePlanFragment();
        }
        addFragments(fragment, true, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, ChildFuturePlanFragment.class.getSimpleName());
    }

    public void addWealthCalculatorFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(WealthCalculatorFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new WealthCalculatorFragment();
        }
        addFragments(fragment, true, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, WealthCalculatorFragment.class.getSimpleName());
    }

    public void addRetirementFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(RetirementCalculatorFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new RetirementCalculatorFragment();
        }
        addFragments(fragment, true, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, RetirementCalculatorFragment.class.getSimpleName());
    }

    public void addProspectsSelectionFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(ProspectSelectionFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new ProspectSelectionFragment();
        }
        addFragments(fragment, false, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, ProspectSelectionFragment.class.getSimpleName());
    }

    @Override
    public void onClick(View v) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            drawerLayout.openDrawer(GravityCompat.START);
        }
        if (v.getTag() != null) {
            switch (v.getTag().toString()) {
                case "Product Calculator":
                    addProductIllustrationFragment();
                    break;
                case "Chat":
                    startActivity(new Intent(this, ChatActivity.class));
                    break;
                case "Contact Us":
                    if (userType.equals("customer")) {
                        addContactFragment();
                    } else {
                        startActivity(new Intent(this, MapsActivity.class));
                    }
                    break;
                case "Customer Prospects":
//                    addRequestFragment();
                    addProspectsSelectionFragment();
                    break;
                case "Subscriptions":
                    addSubscriptionFragment();
                    break;
                case "Logout":
                case "Check In":
                    PreferenceUtils.setLoginIsDone(this, false);
                    addLoginFragment();
                    break;
                case "Product Details":
                    addProductDetailsFragment();
                    break;
                case "Trending Analysis":
                    startActivity(new Intent(this, PieChartActivity.class));
                    break;
                case "Renewal":
                    addRenewalFragment();
                    break;
                case "Survey":
                    addSurveyFragment();
                    break;
                case "Fix Appointment":
                    addFixAppoimentFragment();
                    break;
            }
        }
    }
   /* public void addSamridhiFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(SamridhiFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new SamridhiFragment();
        }
        addFragments(fragment, true, false, Const.AnimConst.RIGHT_TO_LEFT_ANIM, SamridhiFragment.class.getSimpleName());
    }*/
}

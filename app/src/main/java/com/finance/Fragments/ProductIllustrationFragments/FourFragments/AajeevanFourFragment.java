package com.finance.Fragments.ProductIllustrationFragments.FourFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finance.R;

/**
 * Created by Bijoy on 3/10/2016.
 */
public class AajeevanFourFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_aajeevan_four, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

   /* public void changeMode(int mode) {
        switch (mode) {
            case Const.PolicyConst.MONEY_BACK:
                endowmentView.setVisibility(View.GONE);
                moneyBackView.setVisibility(View.VISIBLE);
                break;
            case Const.PolicyConst.ENDOWMENT:
                endowmentView.setVisibility(View.VISIBLE);
                moneyBackView.setVisibility(View.GONE);
                break;
        }
    }*/

    @Override
    public void onStop() {
        super.onStop();
    }
}

package com.finance.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.finance.MainActivity;
import com.finance.R;

/**
 * Created by Bijoy on 3/9/2016.
 */
public class SplashScreenFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_screen, container, false);
        initUi(view);
        return view;
    }

    /**
     * Initializing the view
     *
     * @param view - Fragment view
     */
    private void initUi(View view) {
        /*used for 1s delay*/
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ((MainActivity) getActivity()).addLoginFragment();
            }
        }, 1000);
    }
}

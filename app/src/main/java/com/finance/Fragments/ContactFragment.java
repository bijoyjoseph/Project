package com.finance.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finance.R;
import com.finance.WebActivity;

/**
 * Created by Bijoy on 5/13/2016.
 */
public class ContactFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.ibFb).setOnClickListener(this);
        view.findViewById(R.id.ibTwitter).setOnClickListener(this);
        view.findViewById(R.id.ibLinkedin).setOnClickListener(this);
        view.findViewById(R.id.ibYouTube).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getActivity(), WebActivity.class);
        switch (v.getId()){

            case R.id.ibFb:
                intent.putExtra("URL",getResources().getString(R.string.fb_link));
                startActivity(intent);
                break;
            case R.id.ibTwitter:
                intent.putExtra("URL",getResources().getString(R.string.tw_link));
                startActivity(intent);
                break;
            case R.id.ibLinkedin:
                intent.putExtra("URL",getResources().getString(R.string.ln_link));
                startActivity(intent);
                break;
            case R.id.ibYouTube:
                intent.putExtra("URL",getResources().getString(R.string.yu_link));
                startActivity(intent);
                break;
        }
    }
}

package com.finance.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.finance.MainActivity;
import com.finance.R;
import com.finance.Util.Const;
import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bijoy on 4/12/2016.
 */
public class FixAppoinmentFragment extends Fragment implements View.OnClickListener {
    private EditText name = null;
    private EditText number = null;
    private EditText email = null;
    private EditText annualIncome = null;
    private EditText date = null;
    private Spinner spinner = null;
    private Button button = null;
    private String[] productIllustrationTypes = {"Samridhi", "Elite advantage", "Aajeevan sampatti+",
            "Triple health insurance", "Flexi save", "Monthly income plan","Super series"};
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fix_appoiment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    /* private void setButtonVisiblity(boolean isVisible) {
         if (isVisible) {
             btNotNow.setVisibility(View.VISIBLE);
         } else {
             btNotNow.setVisibility(View.GONE);
         }
     }
 */
    private void initUi(View view) {
        name = (EditText) view.findViewById(R.id.name);
        number = (EditText) view.findViewById(R.id.number);
        email = (EditText) view.findViewById(R.id.email);
        annualIncome = (EditText) view.findViewById(R.id.annual_income);
        button = (Button) view.findViewById(R.id.button);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        date = (EditText) view.findViewById(R.id.date);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getContext(), R.layout.dialog_item, productIllustrationTypes);
        spinner.setAdapter(adapter);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if (name.getText().toString().isEmpty()) {
                    name.setError("Cannot be empty");
                } else if (number.getText().toString().isEmpty()) {
                    number.setError("Cannot be empty");

                } else if (email.getText().toString().isEmpty()) {
                    email.setError("Cannot be empty");
                } else if (!email.getText().toString().matches(emailPattern)) {
                    email.setError("Invalid email");
                }else if (annualIncome.getText().toString().isEmpty()) {
                    annualIncome.setError("Cannot be empty");
                }else if (date.getText().toString().isEmpty()) {
                    date.setError("Cannot be empty");
                } else {

                    Firebase firebaseRef = new Firebase(getResources().getString(R.string.cloud_url) + "/" + Const.FbConst.APPOINTMENT);

                    Map<String, String> post = new HashMap<>();
                    post.put(Const.FbConst.NAME, name.getText().toString());
                    post.put(Const.FbConst.NUMBER, number.getText().toString());
                    post.put(Const.FbConst.EMAIL, email.getText().toString());
                    post.put(Const.FbConst.ANNUAL_INCOME, annualIncome.getText().toString());
                    post.put(Const.FbConst.DATE, date.getText().toString());
                    post.put(Const.FbConst.POLICY_TYPE, spinner.getSelectedItem().toString());
                    post.put(Const.FbConst.CALLED, "0");
                    firebaseRef.push().setValue(post);
//            getFragmentManager().popBackStackImmediate();
                    ((MainActivity) getActivity()).addProductDetailsFragment();
                }
                break;
        }
    }
}

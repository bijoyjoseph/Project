package com.finance.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.finance.MainActivity;
import com.finance.R;
import com.finance.Util.Const;
import com.firebase.client.Firebase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bijoy on 4/12/2016.
 */
public class SubScriptionfragment extends Fragment implements View.OnClickListener, TextView.OnEditorActionListener {
    private EditText name = null;
    private EditText number = null;
    private EditText address = null;
    private EditText email = null;
    private EditText age = null;
    private AutoCompleteTextView gender = null;
    private EditText occupation = null;
    private EditText nomineeName = null;
    private EditText nomineeAge = null;
    private EditText annualIncome = null;
    private EditText amountPaid = null;
    private Spinner spinner = null;
    private Spinner statusSpinner = null;
    private Button button = null;
    private TextView tvPlocyNumber = null;
    private String[] productIllustrationTypes = {"Samridhi", "Elite advantage", "Aajeevan sampatti+",
            "Triple health insurance", "Flexi save", "Monthly income plan", "Super series"};
    private String[] policyFrequency = {"Annual", "Semi annual", "Monthly"};
    private String[] genderList = {"Male", "Female", "Other"};
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subscription, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    private void initUi(View view) {
        name = (EditText) view.findViewById(R.id.name);
        number = (EditText) view.findViewById(R.id.number);
        address = (EditText) view.findViewById(R.id.address);
        email = (EditText) view.findViewById(R.id.email);
        gender = (AutoCompleteTextView) view.findViewById(R.id.gender);
        age = (EditText) view.findViewById(R.id.age);
        occupation = (EditText) view.findViewById(R.id.occupation);
        annualIncome = (EditText) view.findViewById(R.id.annual_income);
        nomineeAge = (EditText) view.findViewById(R.id.nomineeAge);
        nomineeName = (EditText) view.findViewById(R.id.nomineeName);
        amountPaid = (EditText) view.findViewById(R.id.amountPaid);
        button = (Button) view.findViewById(R.id.button);
        tvPlocyNumber = (TextView) view.findViewById(R.id.tv_policy_number);
        button.setOnClickListener(this);

        spinner = (Spinner) view.findViewById(R.id.spinner);
        statusSpinner = (Spinner) view.findViewById(R.id.statusSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getContext(), R.layout.dialog_item, productIllustrationTypes);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (getContext(), R.layout.dialog_item, policyFrequency);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>
                (getContext(), android.R.layout.select_dialog_item, genderList);
        gender.setAdapter(adapter3);
        spinner.setAdapter(adapter);
        statusSpinner.setAdapter(adapter1);

        tvPlocyNumber.setText("501-" + getCurrentTimeStamp());
        name.setOnEditorActionListener(this);
    }

 /*   @Override
    public void onClick(View v) {
        Firebase firebaseRef = new Firebase(getResources().getString(R.string.cloud_url) + "/" + Const.FbConst.SUBSCRIPTION);

        Map<String, String> post = new HashMap<>();
        post.put(Const.FbConst.NAME, name.getText().toString());
        post.put(Const.FbConst.NUMBER, number.getText().toString());
        post.put(Const.FbConst.ADDRESS, address.getText().toString());
        post.put(Const.FbConst.EMAIL, email.getText().toString());
        post.put(Const.FbConst.GENDER, gender.getText().toString());
        post.put(Const.FbConst.OCCUPATION, occupation.getText().toString());
        post.put(Const.FbConst.ANNUAL_INCOME, annualIncome.getText().toString());
        firebaseRef.push().setValue(post);

        getFragmentManager().popBackStackImmediate();
    }*/

    private String getCurrentTimeStamp() {
        Long tsLong = System.currentTimeMillis() / 1000;
        return tsLong.toString().substring(3, 10);
    }

    private String getCurrentDate() {
        String dateStr = "04/05/2010";

        SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
        Date dateObj = null;
        try {
            dateObj = curFormater.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat postFormater = new SimpleDateFormat("MMMM dd, yyyy");

        return postFormater.format(dateObj);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if (name.getText().toString().isEmpty()) {
                    name.setError("Cannot be empty");
                } else if (number.getText().toString().isEmpty()) {
                    number.setError("Cannot be empty");
                } else if (address.getText().toString().isEmpty()) {
                    address.setError("Cannot be empty");
                } else if (occupation.getText().toString().isEmpty()) {
                    occupation.setError("Cannot be empty");
                } else if (annualIncome.getText().toString().isEmpty()) {
                    annualIncome.setError("Cannot be empty");
                } else if (email.getText().toString().isEmpty()) {
                    email.setError("Cannot be empty");
                } else if (!email.getText().toString().matches(emailPattern)) {
                    email.setError("Invalid email");
                } else if (annualIncome.getText().toString().isEmpty()) {
                    annualIncome.setError("Cannot be empty");
                } else if (age.getText().toString().isEmpty()) {
                    age.setError("Cannot be empty");
                } else if (amountPaid.getText().toString().isEmpty()) {
                    amountPaid.setError("Cannot be empty");
                } else {

                    Firebase firebaseRef = new Firebase(getResources().getString(R.string.cloud_url) + "/" + Const.FbConst.SUBSCRIPTION);

                    Map<String, String> post = new HashMap<>();
                    post.put(Const.FbConst.NAME, name.getText().toString());
                    post.put(Const.FbConst.AGE, age.getText().toString());
                    post.put(Const.FbConst.NUMBER, number.getText().toString());
                    post.put(Const.FbConst.ADDRESS, address.getText().toString());
                    post.put(Const.FbConst.OCCUPATION, occupation.getText().toString());
                    post.put(Const.FbConst.EMAIL, email.getText().toString());
                    post.put(Const.FbConst.ANNUAL_INCOME, annualIncome.getText().toString());
                    post.put(Const.FbConst.DATE, getCurrentDate());
                    post.put(Const.FbConst.GENDER, gender.getText().toString());
                    post.put(Const.FbConst.POLICY_TYPE, spinner.getSelectedItem().toString());
                    post.put(Const.FbConst.POLICY_FREQUENCY, statusSpinner.getSelectedItem().toString());
                    post.put(Const.FbConst.POLICY_NUMBER, tvPlocyNumber.getText().toString());
                    post.put(Const.FbConst.AMOUNT_PAID, amountPaid.getText().toString());
                    post.put(Const.FbConst.NOMINEE_NAME, nomineeName.getText().toString());
                    post.put(Const.FbConst.NOMINEE_AGE, nomineeAge.getText().toString());
                    firebaseRef.push().setValue(post);
//            getFragmentManager().popBackStackImmediate();
                    ((MainActivity) getActivity()).addProductDetailsFragment();
                }
                break;
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }
}

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
import android.widget.CheckBox;
import android.widget.EditText;

import com.finance.MainActivity;
import com.finance.R;
import com.finance.Util.Const;
import com.finance.Util.PreferenceUtils;
import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bijoy on 4/12/2016.
 */
public class SurveyFragment extends Fragment implements View.OnClickListener {
    private EditText name = null;
    private EditText number = null;
    private EditText address = null;
    private EditText email = null;
    private AutoCompleteTextView gender = null;
    private EditText occupation = null;
    private EditText annualIncome = null;
    private Button button = null;
    private Button btNotNow = null;
    private CheckBox cbAppoinment = null;
    private String[] genderList = {"Male", "Female", "Other"};
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_survey, container, false);
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
        address = (EditText) view.findViewById(R.id.address);
        email = (EditText) view.findViewById(R.id.email);
        gender = (AutoCompleteTextView) view.findViewById(R.id.gender);
        occupation = (EditText) view.findViewById(R.id.occupation);
        annualIncome = (EditText) view.findViewById(R.id.annual_income);
        button = (Button) view.findViewById(R.id.button);
        btNotNow = (Button) view.findViewById(R.id.btNotNow);
        cbAppoinment = (CheckBox) view.findViewById(R.id.cbAppoinment);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getContext(), android.R.layout.select_dialog_item, genderList);
        gender.setAdapter(adapter);
        button.setOnClickListener(this);
        btNotNow.setOnClickListener(this);
        if (PreferenceUtils.isNotNowDone(getContext())) {
            btNotNow.setVisibility(View.GONE);
        } else {
            btNotNow.setVisibility(View.VISIBLE);
        }
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
                } else if (email.getText().toString().isEmpty()) {
                    email.setError("Cannot be empty");
                } else if (!email.getText().toString().matches(emailPattern)) {
                    email.setError("Invalid email");
                } else if (gender.getText().toString().isEmpty()) {
                    gender.setError("Cannot be empty");
                } else if (occupation.getText().toString().isEmpty()) {
                    occupation.setError("Cannot be empty");
                } else if (annualIncome.getText().toString().isEmpty()) {
                    annualIncome.setError("Cannot be empty");
                } else {
                    if (!cbAppoinment.isChecked()) {
                        Firebase firebaseRef = new Firebase(getResources().getString(R.string.cloud_url) + "/" + Const.FbConst.SURVEY);

                        Map<String, String> post = new HashMap<>();
                        post.put(Const.FbConst.NAME, name.getText().toString());
                        post.put(Const.FbConst.NUMBER, number.getText().toString());
                        post.put(Const.FbConst.ADDRESS, address.getText().toString());
                        post.put(Const.FbConst.EMAIL, email.getText().toString());
                        post.put(Const.FbConst.GENDER, gender.getText().toString());
                        post.put(Const.FbConst.OCCUPATION, occupation.getText().toString());
                        post.put(Const.FbConst.ANNUAL_INCOME, annualIncome.getText().toString());
                        post.put(Const.FbConst.CALLED, "0");
                        firebaseRef.push().setValue(post);
//            getFragmentManager().popBackStackImmediate();
                        ((MainActivity) getActivity()).addProductDetailsFragment();
                    } else {
                        Firebase firebaseRef = new Firebase(getResources().getString(R.string.cloud_url) + "/" + Const.FbConst.APPOINTMENT);

                        Map<String, String> post = new HashMap<>();
                        post.put(Const.FbConst.NAME, name.getText().toString());
                        post.put(Const.FbConst.NUMBER, number.getText().toString());
                        post.put(Const.FbConst.ADDRESS, address.getText().toString());
                        post.put(Const.FbConst.EMAIL, email.getText().toString());
                        post.put(Const.FbConst.GENDER, gender.getText().toString());
                        post.put(Const.FbConst.OCCUPATION, occupation.getText().toString());
                        post.put(Const.FbConst.ANNUAL_INCOME, annualIncome.getText().toString());
                        post.put(Const.FbConst.CALLED, "0");
                        firebaseRef.push().setValue(post);
//            getFragmentManager().popBackStackImmediate();
                        ((MainActivity) getActivity()).addProductDetailsFragment();
                    }
                }
                break;
            case R.id.btNotNow:
                PreferenceUtils.setLoginIsDone(getContext(), true);
                ((MainActivity) getActivity()).addProductDetailsFragment();
                break;
        }
    }
}

package com.finance.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.finance.R;
import com.finance.Util.Const;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Bijoy on 4/12/2016.
 */
public class RenewalFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private EditText policyNumber = null;
    private TextView tvDetails = null;
    private TextView tvRenewableAmount = null;
    private Button button = null;
    private Spinner spinner = null;
    private Spinner statusSpinner = null;
    private int paidAmount = 0;

    private String[] policyStatus = {"OnTime", "Grace period", "Laps"};
    private String[] paymentFrequency = {"Annual", "Semi annual", "Monthly"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_renewal, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    private void initUi(View view) {
        policyNumber = (EditText) view.findViewById(R.id.policyNumber);
        button = (Button) view.findViewById(R.id.button);
        tvDetails = (TextView) view.findViewById(R.id.tvDetails);
        tvRenewableAmount = (TextView) view.findViewById(R.id.tvRenewableAmount);
        button.setOnClickListener(this);


        spinner = (Spinner) view.findViewById(R.id.spinner);
        statusSpinner = (Spinner) view.findViewById(R.id.statusSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getContext(), R.layout.dialog_item, policyStatus);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (getContext(), R.layout.dialog_item, paymentFrequency);
        spinner.setAdapter(adapter);
        statusSpinner.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(this);
        statusSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        editData();
       /* Firebase firebaseRef = new Firebase(getResources().getString(R.string.cloud_url) + "/" + Const.FbConst.RENEWAL);

        Map<String, String> post = new HashMap<>();
        post.put(Const.FbConst.NAME, name.getText().toString());
        post.put(Const.FbConst.NUMBER, number.getText().toString());
        post.put(Const.FbConst.ADDRESS, address.getText().toString());
        post.put(Const.FbConst.EMAIL, email.getText().toString());
        post.put(Const.FbConst.GENDER, gender.getText().toString());
        post.put(Const.FbConst.OCCUPATION, occupation.getText().toString());
        post.put(Const.FbConst.ANNUAL_INCOME, annualIncome.getText().toString());
        firebaseRef.push().setValue(post);

        getFragmentManager().popBackStackImmediate();*/
    }

    private void editData() {
        Firebase firebaseRef = new Firebase(getResources().getString(R.string.cloud_url) + "/" + Const.FbConst.SUBSCRIPTION);
        Query query = firebaseRef.orderByChild(Const.FbConst.POLICY_NUMBER).equalTo(policyNumber.getText().toString());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getChildrenCount() > 0) {
                    HashMap<String, String> surveyData = (HashMap<String, String>) dataSnapshot.getValue();
                    ArrayList<HashMap<String, String>> maps = new ArrayList(surveyData.values());
                    paidAmount = Integer.parseInt(maps.get(0).get(Const.FbConst.AMOUNT_PAID));
                    tvDetails.setText(maps.get(0).get(Const.FbConst.NAME) + "\n" + maps.get(0).get(Const.FbConst.POLICY_TYPE));
                    calculateAmountRenewal();
                }

               /* Firebase firebaseRef = new Firebase(getResources().getString(R.string.cloud_url) + "/" + Const.FbConst.APPOINTMENT);

                Map<String, String> post = new HashMap<>();
                post.put(Const.FbConst.NAME, stringStringHashMap.get(Const.FbConst.NAME));
                post.put(Const.FbConst.NUMBER, stringStringHashMap.get(Const.FbConst.NUMBER));
                post.put(Const.FbConst.EMAIL, stringStringHashMap.get(Const.FbConst.EMAIL));
                post.put(Const.FbConst.CALLED, String.valueOf(action));
                post.put(Const.FbConst.DATE, stringStringHashMap.get(Const.FbConst.DATE));
                post.put(Const.FbConst.POLICY_TYPE, stringStringHashMap.get(Const.FbConst.POLICY_TYPE));
                firebaseRef.push().setValue(post);*/
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        calculateAmountRenewal();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void calculateAmountRenewal(){
        if(paidAmount!=0){
            int paimentFrquencyPerc = 0;
            int amountToPay = 0;
            switch (statusSpinner.getSelectedItem().toString()){
                case "Annual":
                    paimentFrquencyPerc = paidAmount;
                    break;
                case "Semi annual":
                    paimentFrquencyPerc = (int) ((paidAmount*1.02)/2);
                    break;
                case "Monthly":
                    paimentFrquencyPerc = (int) ((paidAmount*1.0404)/12);
                    break;
            }
             switch (spinner.getSelectedItem().toString()){
                case "OnTime":
                    amountToPay = paimentFrquencyPerc;
                    break;
                case "Grace period":
                    amountToPay = (int) (paimentFrquencyPerc*0.02);
                    break;
                case "Laps":
                    amountToPay = (int) (paimentFrquencyPerc*0.06);
                    break;
            }
            tvRenewableAmount.setText(""+amountToPay);
        }
    }

}

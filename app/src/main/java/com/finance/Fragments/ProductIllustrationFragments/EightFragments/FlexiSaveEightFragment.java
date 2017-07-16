package com.finance.Fragments.ProductIllustrationFragments.EightFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.finance.Data.PremiumData;
import com.finance.R;
import com.finance.Util.Const;

/**
 * Created by Bijoy on 3/10/2016.
 */
public class FlexiSaveEightFragment extends Fragment {
    private TextView tvBonusAtMaturity = null;
    private TextView tvSumAssured = null;
    private TextView tvTotalBenefit = null;
    private TextView tvTotalPremium = null;
    private TextView tvAnnualPremium = null;
    private TextView tvSemiAnnualPremium = null;
    private TextView tvMonthlyPremium = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_secure_income_eight, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    private void initUi(View view) {
        tvBonusAtMaturity = (TextView) view.findViewById(R.id.tvBonusAtMaturity);
        tvSumAssured = (TextView) view.findViewById(R.id.tvSumAssured);
        tvTotalBenefit = (TextView) view.findViewById(R.id.tvTotalBenefit);
        tvTotalPremium = (TextView) view.findViewById(R.id.tvTotalPremium);
        tvAnnualPremium = (TextView) view.findViewById(R.id.tvAnnualPremium);
        tvSemiAnnualPremium = (TextView) view.findViewById(R.id.tvSemiAnnualPremium);
        tvMonthlyPremium = (TextView) view.findViewById(R.id.tvMonthlyPremium);
    }

    public void setData(PremiumData data) {
        Log.e(" ", "setData() called with " + "data = [" + data + "]" + "8 fragment");
        int totalBonus;
        tvAnnualPremium.setText(String.valueOf(data.getAnnualPremium()));
        tvSemiAnnualPremium.setText(String.valueOf(data.getAnnualPremium() * 0.52));
        tvMonthlyPremium.setText(String.valueOf(data.getAnnualPremium() * 0.09));

       /* int sumAssured = (int) Math.round(((data.getAnnualPremium() * 1000) / 67.63));
        tvSumAssured.setText(String.valueOf(sumAssured));*/
        int sumAssured = 0;
        switch (data.getPolicyTerm()) {
            case 20:
                if (data.isMale() || data.getAge() < 9) {
                    sumAssured = (int) Math.round(((data.getAnnualPremium() * 1000) / Const.policyTerm5YearsFlexiSave[data.getAge()]));
                } else {
                    sumAssured = (int) Math.round(((data.getAnnualPremium() * 1000) / Const.policyTerm5YearsFlexiSave[data.getAge() - 3]));
                }
                tvSumAssured.setText(String.valueOf(sumAssured));
                tvTotalPremium.setText(String.valueOf(data.getAnnualPremium() * 5));
                totalBonus = (int) Math.round(((sumAssured * 0.015 * data.getPolicyTerm()) + (sumAssured * 0.47849)));
                tvBonusAtMaturity.setText(String.valueOf(totalBonus));
                break;
            case 25:
                if (data.isMale() || data.getAge() < 10) {
                    sumAssured = (int) Math.round(((data.getAnnualPremium() * 1000) / Const.policyTerm7YearsFlexiSave[data.getAge()]));
                } else {
                    sumAssured = (int) Math.round(((data.getAnnualPremium() * 1000) / Const.policyTerm7YearsFlexiSave[data.getAge() - 3]));
                }
                tvSumAssured.setText(String.valueOf(sumAssured));
                tvTotalPremium.setText(String.valueOf(data.getAnnualPremium() * 7));
                totalBonus = (int) Math.round(((sumAssured * 0.025 * data.getPolicyTerm()) + (sumAssured * 0.7562)));
                tvBonusAtMaturity.setText(String.valueOf(totalBonus));
                break;
            case 30:
                if (data.isMale() || data.getAge() < 10) {
                    sumAssured = (int) Math.round(((data.getAnnualPremium() * 1000) / Const.policyTerm12YearsFlexiSave[data.getAge()]));
                } else {
                    sumAssured = (int) Math.round(((data.getAnnualPremium() * 1000) / Const.policyTerm12YearsFlexiSave[data.getAge() - 3]));
                }
                tvSumAssured.setText(String.valueOf(sumAssured));
                tvTotalPremium.setText(String.valueOf(data.getAnnualPremium() * 12));
                totalBonus = (int) Math.round(((sumAssured * 0.03 * data.getPolicyTerm()) + (sumAssured * 1.089)));
                tvBonusAtMaturity.setText(String.valueOf(totalBonus));
                break;
            default:
                totalBonus = 0;
                break;
        }

        tvTotalBenefit.setText(String.valueOf(sumAssured + totalBonus));
    }

}

package com.finance.Fragments.ProductIllustrationFragments.FourFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
public class FlexiSaveFourFragment extends Fragment {
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
        return inflater.inflate(R.layout.fragment_secure_income_four, container, false);
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
        int totalBonus;
        tvAnnualPremium.setText(String.valueOf(data.getAnnualPremium()));
        tvSemiAnnualPremium.setText(String.valueOf(data.getAnnualPremium() * 0.52));
        tvMonthlyPremium.setText(String.valueOf(data.getAnnualPremium() * 0.09));

        int sumAssured = 0;
//        tvSumAssured.setText(String.valueOf(sumAssured));

        switch (data.getPolicyTerm()) {
            case 20:
                if (data.isMale() || data.getAge() < 9) {
                    sumAssured = (int) Math.round(((data.getAnnualPremium() * 1000) / Const.policyTerm5YearsFlexiSave[data.getAge()]));
                } else {
                    sumAssured = (int) Math.round(((data.getAnnualPremium() * 1000) / Const.policyTerm5YearsFlexiSave[data.getAge() - 3]));
                }
                tvSumAssured.setText(String.valueOf(sumAssured));
                tvTotalPremium.setText(String.valueOf(data.getAnnualPremium() * 5));
                totalBonus = (int) Math.round((sumAssured * 0.0075 * data.getPolicyTerm()) + (sumAssured * 0.23925));
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
                totalBonus = (int) Math.round((sumAssured * 0.0125 * data.getPolicyTerm()) + (sumAssured * 0.3781));
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
                totalBonus = (int) Math.round((sumAssured * 0.0125 * data.getPolicyTerm()) + (sumAssured * 0.4537));
                tvBonusAtMaturity.setText(String.valueOf(totalBonus));
                break;
            default:
                totalBonus = 0;
                break;
        }

        tvTotalBenefit.setText(String.valueOf(sumAssured + totalBonus));
    }

}

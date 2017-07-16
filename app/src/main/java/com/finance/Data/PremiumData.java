package com.finance.Data;

/**
 * Created by Bijoy on 3/21/2016.
 */
public class PremiumData {
    private int age;
    private int annualPremium;
    private int policyTerm;
    private boolean isMale;

    public PremiumData(int age, int annualPremium, int policyTerm,boolean isMale) {
        this.age = age;
        this.annualPremium = annualPremium;
        this.policyTerm = policyTerm;
        this.isMale = isMale;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAnnualPremium() {
        return annualPremium;
    }

    public void setAnnualPremium(int annualPremium) {
        this.annualPremium = annualPremium;
    }

    public int getPolicyTerm() {
        return policyTerm;
    }

    public void setPolicyTerm(int policyTerm) {
        this.policyTerm = policyTerm;
    }
}

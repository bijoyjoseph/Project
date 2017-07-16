package com.finance.Util;

/**
 * Created by Bijoy on 3/9/2016.
 */
public class Const {
    public class AnimConst {
        public static final int NO_ANIM = 0;
        public static final int RIGHT_TO_LEFT_ANIM = 1;
        public static final int LEFT_TO_RIGHT_ANIM = 2;
        public static final int FADE_OUT_ANIM = 3;
        public static final int SLIDE_IN_UP = 4;
    }

    public class PolicyConst {
        public static final int MONEY_BACK = 0;
        public static final int ENDOWMENT = 1;
    }

    public class PayTypeConst {
        public static final int LIMITED = 0;
        public static final int REGULAR = 1;
    }

    public class IntentConst {
        public static final String LIST_POSITION = "LIST_POSITION";
    }

    public class FbConst {
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";

        public static final String NAME = "name";
        public static final String AGE = "age";
        public static final String DATE = "date";
        public static final String POLICY_TYPE = "policy_type";
        public static final String POLICY_FREQUENCY = "policy_frequency";
        public static final String NUMBER = "number";
        public static final String ADDRESS = "address";
        public static final String EMAIL = "email";
        public static final String GENDER = "gender";
        public static final String AMOUNT_PAID = "amount_paid";
        public static final String OCCUPATION = "occupation";
        public static final String ANNUAL_INCOME = "annual income";
        public static final String SURVEY = "survey";
        public static final String RENEWAL = "renewal";
        public static final String SUBSCRIPTION = "subscription";
        public static final String APPOINTMENT = "appointment";
        public static final String CALLED = "called";
        public static final String POLICY_NUMBER = "policy_number";
        public static final String NOMINEE_NAME = "nominee_name";
        public static final String NOMINEE_AGE = "nominee_age";
    }

    public class PrefConst {
        public static final String IS_LOGGED_IN = "is_logged_in";
        public static final String NOT_NOW = "not_now";
        public static final String USERNAME = "username";
        public static final String AGENT_TYPE = "agent_type";
    }

    public static final double[] policyTerm5yearsMaleEliteAdvantage = {207.81,207.9,207.99,208.08,208.17,208.26,208.35,208.44,208.53,208.62,208.78,208.93,209.08,209.23,209.38,209.53,209.68,209.84,210.08,210.32,210.57,210.81,211.05,211.3,211.54,211.79,212.03,212.28,213.21,214.14,215.07,216.01,216.95,217.9,218.85,219.81,220.77,221.73,222.71,223.68,224.66,225.65,226.64,227.8,230.14,231.32,232.51,233.7,234.9,236.11,237.33,238.55,239.78,241.01,242.26,243.51,244.76};
    public static final double[] policyTerm5yearsFemaleEliteAdvantage = {207.81,  207.81, 207.81, 207.81, 207.9, 207.99, 208.08, 208.17, 208.26, 208.35, 208.44, 208.53, 208.62, 208.78, 208.93, 209.08, 209.23, 209.38, 209.53, 209.68, 209.84,210.08, 210.32, 210.57, 210.81,211.05,211.3,211.54,211.79,212.03,212.28,213.21,214.14,215.07,216.01,216.95,217.9,218.85,219.81,220.77,221.73,222.71,223.68,224.66,225.65,226.64,227.8,228.97,230.4,231.32,232.51,233.7,234.9,236.11,237.33,238.55,239.78,241.01};
    public static final double[] policyTerm7yearsMaleEliteAdvantage = {124.05, 124.05, 124.11, 124.16, 124.21, 124.27, 124.32, 124.38, 124.43, 124.48, 124.54, 124.59, 124.67, 124.76, 124.85, 124.94, 125.03, 125.12, 125.21, 125.3, 125.44, 125.59, 125.73, 125.87, 126.02, 126.16, 126.31, 126.45, 126.6, 126.75, 127.29, 127.85, 128.39, 128.94, 129.5, 130.06, 130.63, 131.19, 131.75, 132.32, 132.9, 133.47, 134.05, 134.62, 135.21, 135.89, 136.58, 137.28, 137.96, 138.67,139.37, 140.08, 140.79, 141.5, 142.22, 142.94, 143.67, 144.4, 145.13, 145.87};
    public static final double[] policyTerm7yearsFemaleEliteAdvantage = {124.05, 124.05, 124.05, 124.05, 124.05, 124.11, 124.16, 124.21, 124.27, 124.32, 124.38, 124.43, 124.48, 124.54, 124.59, 124.67, 124.76, 124.85, 124.94, 125.03, 125.12, 125.21, 125.3, 125.44, 125.59, 125.73, 125.87, 126.02, 126.16, 126.31, 126.45, 126.6, 126.75, 127.29, 127.85, 128.39, 128.94, 129.5, 130.06, 130.63, 131.19, 131.75, 132.32, 132.9, 133.43, 134.05, 134.62, 135.21, 135.89,136.58, 137.28, 137.96, 138.67, 139.37, 140.08, 140.79, 141.5, 142.22, 142.94,143.67};
    public static final double[] policyTerm12yearsMaleEliteAdvantage = {79.87, 79.87, 79.9, 79.93, 79.95, 79.98, 80.01, 80.04, 80.07, 80.1, 80.13, 80.16, 80.21, 80.26, 80.31, 80.36, 80.41, 80.46, 80.5, 80.55, 80.63, 80.71, 80.79, 80.87, 80.95, 81.03, 81.11, 81.19, 81.27, 81.35, 81.65, 81.95, 82.25, 82.55, 82.86, 83.16, 83.47, 83.78, 84.09, 84.4, 84.71, 85.02, 85.33, 85.65, 85.96, 86.34, 86.71, 87.08,87.46, 87.83, 88.21, 88.59, 88.98, 89.75, 90.13, 90.52, 90.91, 91.31, 91.7};
    public static final double[] policyTerm12yearsFemaleEliteAdvantage = {79.87, 79.87, 79.87, 79.87, 79.87,79.9,79.93,79.95,79.98,80.01,80.04,80.07,80.1,80.13,80.16,80.21,80.26,80.31,80.36,80.41,80.46,80.5,80.55,80.63,80.71,80.79,80.87,80.95,81.03,81.11,81.19,81.35,81.65,81.95,82.25,82.55,82.86,83.16,83.47,83.78,84.09,84.4,84.71,85.02,85.33,85.65,85.96,86.34,86.71,87.08,87.46,87.83,87.21,88.59,88.98,89.36,89.75,90.13,90.52};


    public static final double[] policyTerm15YearsMonthlyIncome = {0, 0, 0, 121.08, 121.08, 121.08, 121.08, 121.08, 121.08, 121.08, 121.08, 121.17, 121.22, 121.31, 121.39, 121.48, 121.54, 121.64, 121.73, 121.82, 121.90, 122.02, 122.15, 122.26, 122.38, 122.51, 122.63, 122.78, 122.92, 123.06, 123.23, 123.37, 123.51, 123.66, 123.84, 124.01, 124.17, 124.36, 124.53, 124.72, 124.89, 125.09, 125.27, 125.46, 125.65, 125.84, 126.02, 126.24, 126.45, 126.65, 126.89, 127.1, 127.32, 127.53, 127.76, 128.08, 128.4, 128.87, 130.2, 131.93, 132.22, 133.53, 134.24, 135.97, 136.77, 138.64};
    public static final double[] policyTerm20YearsMonthlyIncome = {88.4, 88.4, 88.4, 88.4, 88.4, 88.4, 88.4, 88.4, 88.4, 88.4, 88.4, 88.45, 88.53, 88.59, 88.65, 88.72, 88.78, 88.85, 88.91, 89, 89.07, 89.14, 89.22, 89.3, 89.38, 89.45, 89.54, 89.64, 89.72, 89.81, 89.9, 89.98, 90.9, 90.2, 90.32, 90.43, 90.55, 90.69, 90.83, 90.97, 91.14, 91.28, 91.42, 91.60, 91.77, 91.94, 91.94, 92.13, 92.30, 92.57, 93.28, 94, 94.47, 95.41, 96.27, 97.02, 97.84, 98.67, 99.56, 100.29, 101.17, 101.88, 0, 0, 0, 0, 0};
    public static final double[] policyTerm30YearsMonthlyIncome = {58.37, 58.37, 58.37, 58.37, 58.37, 58.37, 58.37, 58.37, 58.37, 58.37, 58.37, 58.41, 58.45, 58.49, 58.53, 58.57, 58.62, 58.68, 58.70, 58.75, 58.8, 58.85, 58.91, 58.96, 59.02, 59.06, 59.12, 59.18, 59.23, 59.29, 59.37, 59.46, 59.54, 59.63, 59.74, 59.84, 59.94, 60.03, 60.16, 60.26, 60.38, 60.52, 60.66, 60.83, 61.06, 61.30, 61.61, 61.91, 62.38, 62.85, 63.54, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final double[] policyTerm5YearsFlexiSave = {0, 0, 0, 0, 0, 0, 0, 0, 170, 170.24, 174.48, 170.73, 170.97, 171.21, 171.45, 171.69, 171.94, 172.18, 172.42, 172.66, 172.9, 173.15, 173.39, 173.63, 173.87, 174.11, 174.35, 174.6, 174.84, 175.08, 175.32, 175.56, 175.81, 176.05, 176.29, 176.53, 176.77, 177.02, 177.26, 177.5, 177.74, 177.98, 178.23, 178, 47, 178.71, 178.95, 179.19, 179.44, 179.68, 179.92, 180.16, 180.4, 180.65, 180.89, 181.13, 181.37, 181.61, 181.85, 182.1, 182.34, 182.58, 182.82, 183.06, 183.31, 183.55, 183.79};
    public static final double[] policyTerm7YearsFlexiSave = {0, 0, 0, 113.73, 113.73, 113.73, 113.73, 113.73, 113.73, 113.73, 114.19, 114.69, 115.18, 115.68, 116.17, 116.67, 117.17, 117.67, 118.17, 118.67, 119.17, 119.66, 120.15, 120.63, 121.1, 121.56, 122.01, 122.46, 122.89, 123.32, 123.74, 124.15, 124.55, 124.94, 125.33, 125.7, 126.08, 126.47, 126.88, 127.3, 127.74, 128.2, 128.67, 129.17, 129.68, 130.2, 130.74, 131.28, 131.82, 132.38, 132.93, 133.5, 134.07, 134.65, 136.25, 138.48, 141.08, 144.36, 147.12, 149.25, 152.67};
    public static final double[] policyTerm12YearsFlexiSave = {62.33, 62.33, 62.33, 62.33, 62.33, 62.33, 62.33, 62.33, 62.33, 62.33, 62.68, 63.01, 63.34, 63.67, 64.01, 64.34, 64.67, 65.01, 65.35, 65.68, 66.02, 66.35, 66.68, 67, 67.32, 67.63, 67.94, 68.24, 68.54, 68.83, 69.11, 69.39, 69.66, 69.93, 70.19, 70.45, 70.7, 70.97, 71.24, 71.53, 71.84, 72.15, 72.47, 72.81, 73.16, 73.52, 73.88, 74.25, 74.63, 75.01, 75.39, 75.78, 76.17, 76.57, 76.97, 77.38};
}

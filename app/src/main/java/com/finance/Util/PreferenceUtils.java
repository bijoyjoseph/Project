package com.finance.Util;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Bijoy on 4-08-2015.
 */
public class PreferenceUtils {

    private static final String TAG = PreferenceUtils.class.getSimpleName();
    private static final String KEY_DEBUG_PREFS = TAG + "debugSharedPrefs";

    public static void setLoginIsDone(Context context, Boolean isLogin) {
        SharedPreferences prefs = getDebugPrefs(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(Const.PrefConst.IS_LOGGED_IN, isLogin);
        editor.apply();
    }

    public static Boolean isLoginIsDone(Context context) {
        SharedPreferences prefs = getDebugPrefs(context);
        return prefs.getBoolean(Const.PrefConst.IS_LOGGED_IN, false);
    }

    public static void setNotNowDone(Context context, Boolean isLogin) {
        SharedPreferences prefs = getDebugPrefs(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(Const.PrefConst.NOT_NOW, isLogin);
        editor.apply();
    }

    public static Boolean isNotNowDone(Context context) {
        SharedPreferences prefs = getDebugPrefs(context);
        return prefs.getBoolean(Const.PrefConst.NOT_NOW, false);
    }

    public static void saveUserName(Context context, String username) {
        SharedPreferences prefs = getDebugPrefs(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(Const.PrefConst.USERNAME, username);
        editor.apply();
    }

    public static String getUserName(Context context) {
        SharedPreferences prefs = getDebugPrefs(context);
        return prefs.getString(Const.PrefConst.USERNAME, " ");
    }

    public static void saveUserType(Context context, String username) {
        SharedPreferences prefs = getDebugPrefs(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(Const.PrefConst.AGENT_TYPE, username);
        editor.apply();
    }

    public static String getUserType(Context context) {
        SharedPreferences prefs = getDebugPrefs(context);
        return prefs.getString(Const.PrefConst.AGENT_TYPE, " ");
    }

    private static SharedPreferences getDebugPrefs(Context context) {
        return context.getSharedPreferences(KEY_DEBUG_PREFS, Context.MODE_PRIVATE);
    }
}

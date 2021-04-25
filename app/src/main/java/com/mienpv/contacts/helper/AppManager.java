package com.mienpv.contacts.helper;

import android.content.Context;
public class AppManager {
    private static AppManager appManager;
    private static Context mContext;
    private static AppPreference appPreference;

    public static int NOT_TRIED = 100;
    public static int FAILED = 200;
    public static int SUCCESS = 300;

    public static AppManager getInstance(Context context) {

        if (appManager == null) {
            mContext = context;
            appPreference = AppPreference.getAppPreferences(mContext);
            appManager = new AppManager();
        }
        return appManager;
    }

    public static Context getContext() {
        return mContext;
    }

    public static void setHasContactPermission(int status) {
        appPreference.putInt("contactPermission", status);
    }

    public static int isHasContactPermission() {
        return appPreference.getInt("contactPermission", NOT_TRIED);
    }
}

package com.mienpv.contacts.helper;



public class Constants {

    //Activity state keys
    public static final int CONTACTS_VIEW_STATE_RESULTS = 0;
    public static final int CONTACTS_VIEW_STATE_NO_RESULTS = 1;
    public static final int CONTACTS_VIEW_STATE_ERROR = 2;

    //Bundle keys
    public static final String CONTACTS_LIST_STATE_KEY = "CONTACTS_LIST_STATE_KEY";
    public static final String CONTACTS_VIEW_STATE_KEY = "CONTACTS_VIEW_STATE_KEY";


    //Database constants
    public static final String DB_NAME = "favourites_db";
    public static final int DB_VERSION = 1;
    public static final String DB_AUTHORITY = "content://com.mienpv.contacts/";

    //API link
    public static final String CONTACTS_API_BASE_LINK = "http://api.androidhive.info/";

    //Duration of splash screen
    public static final int SPLASH_DISPLAY_LENGTH = 1000;
    public static final int MY_PERMISSIONS_REQUEST_CALL = 1986;

    //BroadcastReceiver intent filter action
    public static final String BROADCAST_UPDATE_MESSAGE = "com.mienpv.contacts.data_updated";
}
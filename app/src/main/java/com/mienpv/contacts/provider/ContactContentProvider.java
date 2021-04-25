package com.mienpv.contacts.provider;

import com.tjeannin.provigen.ProviGenOpenHelper;
import com.tjeannin.provigen.ProviGenProvider;


import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.mienpv.contacts.helper.Constants;



public class ContactContentProvider extends ProviGenProvider {

    private static final Class[] contracts = new Class[]{ContactContract.class};

    @Override
    public SQLiteOpenHelper openHelper(Context context) {
        return new ProviGenOpenHelper(getContext(), Constants.DB_NAME, null, Constants.DB_VERSION,
                contracts);
    }

    @Override
    public Class[] contractClasses() {
        return contracts;
    }
}
package com.mienpv.contacts.loader;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.mienpv.contacts.helper.Constants;
import com.mienpv.contacts.object.Contact;
import com.mienpv.contacts.provider.ContactContract;

public class ContactRemover extends AsyncTask<Void, Void, Void> {

    private final Context mContext;

    private final Contact mContact;

    public ContactRemover(Context context, Contact contact) {
        mContext = context;
        mContact = contact;
    }

    @Override
    protected final Void doInBackground(Void... voids) {
        if (mContext != null) {
            //Get ContentResolver
            Uri contentUri = ContactContract.CONTENT_URI;
            ContentResolver contentResolver = mContext.getContentResolver();
            //First delete old data
            contentResolver.delete(contentUri,
                    ContactContract.CONTACT_ID + " = ? ",
                    new String[]{mContact.getId()});
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Send broadcast message to fragment
        LocalBroadcastManager.getInstance(mContext)
                .sendBroadcast(new Intent(Constants.BROADCAST_UPDATE_MESSAGE));
    }
}

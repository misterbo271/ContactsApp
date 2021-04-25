package com.mienpv.contacts.loader;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;

import com.mienpv.contacts.object.Contact;
import com.mienpv.contacts.object.PhoneNumber;
import com.mienpv.contacts.provider.ContactContract;


public class ContactLoader extends AsyncTaskLoader<ArrayList<Contact>> {

    private ArrayList<Contact> mFavouriteList = null;

    public ContactLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (mFavouriteList == null) {
            forceLoad();
        } else {
            deliverResult(mFavouriteList);
        }
    }

    @Override
    public ArrayList<Contact> loadInBackground() {
        mFavouriteList = new ArrayList<>();
        Uri uri = ContactContract.CONTENT_URI;
        Cursor cursor = getContext().getContentResolver().
                query(uri, null, null, null, "");
        if (null == cursor) {
            return null;
        } else if (cursor.getCount() < 1) {
            cursor.close();
            return new ArrayList<>();
        } else {
            int id = cursor.getColumnIndex(ContactContract.CONTACT_ID);
            int name = cursor.getColumnIndex(ContactContract.NAME);
            int mobile = cursor.getColumnIndex(ContactContract.MOBILE);
            int home = cursor.getColumnIndex(ContactContract.HOME);
            int email = cursor.getColumnIndex(ContactContract.EMAIL);
            int gender = cursor.getColumnIndex(ContactContract.GENDER);
            while (cursor.moveToNext()) {
                Contact contact = new Contact();
                PhoneNumber phoneNumber = new PhoneNumber();
                contact.setId(cursor.getString(id));
                contact.setName(cursor.getString(name));
                phoneNumber.setMobile(cursor.getString(mobile));
                phoneNumber.setHome(cursor.getString(home));
                contact.setPhone(phoneNumber);
                contact.setEmail(cursor.getString(email));
                contact.setGender(cursor.getString(gender));
                mFavouriteList.add(contact);
            }
        }
        cursor.close();
        return mFavouriteList;
    }

    @Override
    public void deliverResult(ArrayList<Contact> data) {
        super.deliverResult(data);
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }
}

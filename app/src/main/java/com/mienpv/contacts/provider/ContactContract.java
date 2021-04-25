package com.mienpv.contacts.provider;

import com.tjeannin.provigen.annotation.Column;
import com.tjeannin.provigen.annotation.ContentUri;

import android.net.Uri;

import com.mienpv.contacts.helper.Constants;



public interface ContactContract {

    @Column(Column.Type.TEXT)
    String CONTACT_ID = "id";

    @Column(Column.Type.TEXT)
    String NAME = "name";

    @Column(Column.Type.TEXT)
    String MOBILE = "mobile";

    @Column(Column.Type.TEXT)
    String HOME = "home";


    @Column(Column.Type.TEXT)
    String EMAIL = "email";


    @Column(Column.Type.TEXT)
    String GENDER = "gender";

    @ContentUri
    Uri CONTENT_URI = Uri.parse(Constants.DB_AUTHORITY + "favourites");
}

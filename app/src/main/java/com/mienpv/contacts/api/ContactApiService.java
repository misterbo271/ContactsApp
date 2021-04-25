package com.mienpv.contacts.api;

import com.mienpv.contacts.helper.Constants;
import com.mienpv.contacts.object.ContactList;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ContactApiService {

    @GET("contacts/")
    Call<ContactList> getContactList();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.CONTACTS_API_BASE_LINK)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

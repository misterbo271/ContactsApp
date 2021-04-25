package com.mienpv.contacts.object;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;
import android.os.Parcelable;

public class PhoneNumber implements Parcelable {

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("home")
    private String home;


    public PhoneNumber() {
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public int describeContents() {
        return 0;

    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(this.mobile);
        dest.writeString(this.home);
    }

    private PhoneNumber(Parcel in) {
        this.mobile = in.readString();
        this.home = in.readString();
    }

    public static final Creator<PhoneNumber> CREATOR = new Creator<PhoneNumber>() {
        @Override
        public PhoneNumber createFromParcel(Parcel source) {
            return new PhoneNumber(source);
        }

        @Override
        public PhoneNumber[] newArray(int size) {
            return new PhoneNumber[size];
        }
    };
}


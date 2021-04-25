package com.mienpv.contacts.helper;
import com.mienpv.contacts.R;
public class Utilities {
    public static int setAvatar(String avatar) {
        return avatar.equals("male") ? R.drawable.ic_face_male : R.drawable.ic_face_female;
    }
}

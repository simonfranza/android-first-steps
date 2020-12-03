package com.dov.firstapp.utils;

import android.widget.EditText;

public class Validators {
    public static boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }
}

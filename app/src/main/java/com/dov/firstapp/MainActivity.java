package com.dov.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText userNameEdit;
    AppCompatButton   loginBT;

    public static final String LOGIN_KEY = "LOGIN_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewItems();
    }

    private void setViewItems() {
        userNameEdit = findViewById(R.id.username_ET);
        loginBT = findViewById(R.id.login_BT);
        loginBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HelloActivity.class);
                intent.putExtra(LOGIN_KEY, userNameEdit.getText().toString());
                startActivity(intent);
            }
        });
    }


}
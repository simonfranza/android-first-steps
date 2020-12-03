package com.dov.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    Button signupBtn, signinLinkBtn;
    AppCompatEditText username, name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupBtn = (Button)findViewById(R.id.signup_btn_submit);
        signinLinkBtn = (Button)findViewById(R.id.signup_btn_link_signin);
        username = (AppCompatEditText) findViewById(R.id.signup_txtInput_username);
        password = (AppCompatEditText) findViewById(R.id.signup_txtInput_password);
        name = (AppCompatEditText) findViewById(R.id.signup_txtInput_name);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (authenticate(username.getText().toString(), password.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Welcome !", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        signinLinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean authenticate(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }
}
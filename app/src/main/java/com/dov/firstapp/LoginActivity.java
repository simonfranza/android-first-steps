package com.dov.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button signinBtn, signupLinkBtn;
    AppCompatEditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signinBtn = (Button)findViewById(R.id.signin_btn_submit);
        signupLinkBtn = (Button)findViewById(R.id.signin_btn_link_signup);
        username = (AppCompatEditText) findViewById(R.id.signin_txtInput_username);
        password = (AppCompatEditText) findViewById(R.id.signin_txtInput_password);

        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (authenticate(username, password)) {
                    Toast.makeText(getApplicationContext(), "Welcome back !", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signupLinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean authenticate(EditText username, EditText password) {
        return username.getText().toString().equals("admin") && password.getText().toString().equals("admin");
    }
}
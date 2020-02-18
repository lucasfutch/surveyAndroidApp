package com.example.lucasfutch.surveyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.app.Activity;

import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lucasfutch on 2/17/20.
 */

public class LoginActivity extends AppCompatActivity{

    Button loginButton, cancelButton;
    EditText username, password;

    TextView text;
    int maxAttempts = 5;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button)findViewById(R.id.loginButton);
        cancelButton = (Button)findViewById(R.id.cancelButton);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        text = (TextView)findViewById(R.id.content);
        text.setVisibility(View.GONE);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials!", Toast.LENGTH_SHORT).show();

                    text.setVisibility(View.VISIBLE);
                    maxAttempts--;
                    text.setText(Integer.toString(maxAttempts) + " attempts left.");
                    if (maxAttempts == 0) {
                        loginButton.setEnabled(false);
                    }
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}

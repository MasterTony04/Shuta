package com.is238.master.shuta;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);



    }


    public void loginButton(View view) {

        Intent landingPageIntent = new Intent(LoginActivity.this,StudentLandingPage.class);
        startActivity(landingPageIntent);
    }

    public void resetPassword(View view) {
        Intent resetPasswordIntent = new Intent(LoginActivity.this,PasswordReset.class);
        startActivity(resetPasswordIntent);
    }
}

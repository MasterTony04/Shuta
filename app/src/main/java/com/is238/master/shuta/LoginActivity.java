package com.is238.master.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
        EditText reg_no_text, passwordTxt;
        Button loginBtn;
        CheckBox rememberMeChkBx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        init();
    }


    public void loginButton(View view) {

        Intent landingPageIntent;

        String username = reg_no_text.getText().toString();
        String password = passwordTxt.getText().toString();

        if(username.equals("2016-04-01686") && password.equals("tonynikiazi")){
            landingPageIntent  = new Intent(LoginActivity.this,StudentLandingPage.class);
        }
        else if (username.equals("123456789") && password.equals("teacher")){
            landingPageIntent = new Intent(LoginActivity.this,StaffLandingActivity.class);
        }
        else {
            landingPageIntent = new Intent(LoginActivity.this,LandingPageActivity.class);
        }


        startActivity(landingPageIntent);
    }

    private void init(){
        reg_no_text = findViewById(R.id.regNo);
        passwordTxt = findViewById(R.id.password);
        loginBtn =  findViewById(R.id.loginButton);
        rememberMeChkBx = findViewById(R.id.remberMecheckBox);
    }

    public void resetPassword(View view) {
        Intent resetPasswordIntent = new Intent(LoginActivity.this,PasswordReset.class);
        startActivity(resetPasswordIntent);
    }
}

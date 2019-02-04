package com.is238.master.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

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

        if(username.equals("2") && password.equals("y")){
            landingPageIntent  = new Intent(LoginActivity.this,StudentLandingPage.class);
            startActivity(landingPageIntent);
        }
        else if (username.equals("1") && password.equals("t")){
            landingPageIntent = new Intent(LoginActivity.this,StaffLandingActivity.class);
            startActivity(landingPageIntent);

        }
        else if(username.equals("admin") && password.equals("administrator")) {
            landingPageIntent = new Intent(LoginActivity.this,AdminActivity.class);
            startActivity(landingPageIntent);
        }
        else {
            Toast.makeText(this, "Invalid login", Toast.LENGTH_SHORT).show();

        }



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

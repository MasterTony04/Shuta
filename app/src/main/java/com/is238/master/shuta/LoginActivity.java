package com.is238.master.shuta;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

// sudo chmod a+rwx /dev/kvm

import com.is238.master.shuta.Database.Contract;
import com.is238.master.shuta.Database.DatabaseClasses;
import com.is238.master.shuta.Database.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginActivity extends AppCompatActivity {
    EditText reg_no_text, passwordTxt;
    Button loginBtn;
    CheckBox rememberMeChkBx;


    //DatabaseClasses
    private DatabaseHelper databaseHelper = null;

    private final String LOG_TAG = getClass().getSimpleName();

    public LoginActivity() throws SQLException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        init();
        initDb();
    }


    public void loginButton(View view) {

        Intent landingPageIntent;

        String username = reg_no_text.getText().toString();
        String password = passwordTxt.getText().toString();

        String usernamedb = " ", passworddb = "";

        Log.e("atdgfdgdfsgd", username);

        Cursor c = getContentResolver().query(Contract.AdminContract.CONTENT_URI, null, null, null, null);
        Log.e("fzghsdgfdfdg", "atleast nmepita hapa");
        while (c.moveToNext()) {
            Log.e("Db", c.getString(1));

            if (username.equals(c.getString(1))) {
                if (password.equals(c.getString(0))) {
                    landingPageIntent = new Intent(LoginActivity.this, AdminActivity.class);
                    startActivity(landingPageIntent);
                } else {
                    Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                }
            } else {
                //try Teacher Login
                Toast.makeText(this, "You are not registered as an Admin", Toast.LENGTH_SHORT).show();
            }
        }
        c.close();

    }


    private void init() {
        reg_no_text = findViewById(R.id.regNo);
        passwordTxt = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginButton);
        rememberMeChkBx = findViewById(R.id.remberMecheckBox);
        Log.e("jkgyuugbvuu", "creating an activity");
        databaseHelper = getHelper();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (databaseHelper != null) {
            databaseHelper = null;
        }
    }

    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }

    public void resetPassword(View view) {
        Intent resetPasswordIntent = new Intent(LoginActivity.this, PasswordReset.class);
        startActivity(resetPasswordIntent);
    }


    private boolean initDb() {
        //opening or creating a database
        DatabaseClasses databaseClasses = new DatabaseClasses();
        try {
            Dao<DatabaseClasses.Admin, String> adminStringDao = getHelper().getDao(DatabaseClasses.Admin.class);
            adminStringDao.createIfNotExists(databaseClasses.adminCall("Admin", "Admin."));
        } catch (SQLException e) {
            Log.v("", "Admin already exists");
        }

        for(int i=0;i<6;i++){
            ContentValues values = new ContentValues();
            values.clear();
            values.put(Contract.ClassContract.CLASS_ID, i+1);
            values.put(Contract.ClassContract.CLASS_NAME, "Form " + i+1);
            values.put(Contract.ClassContract.TEACHER_ID, 1);
//            getContentResolver().insert(Contract.ClassContract.CONTENT_URI, values);

            try{
                Dao<DatabaseClasses.Class, Integer> classDao = getHelper().getDao(DatabaseClasses.Class.class);
                classDao.createIfNotExists(databaseClasses.classCall(i+1, "Form "+ i+1, 1));
            }
            catch (Exception e){
                Log.e("DbHandler", "Error writing to database");
                e.printStackTrace();
            }



            for (int j=0;j<3;j++){
                ContentValues streamValues = new ContentValues();
                values.clear();
                values.put(Contract.StreamContract.CLASS_ID, i+1);
                values.put(Contract.StreamContract.STREAM_ID, j+1); //should have created an array!
                if(j==0)
                    values.put(Contract.StreamContract.LETTER, "A");
                if(j==1)
                    values.put(Contract.StreamContract.LETTER, "B");
                if(j==2)
                    values.put(Contract.StreamContract.LETTER, "C");
//                getContentResolver().insert(Contract.StreamContract.contentUri, streamValues);
            }

        }
        Log.e("DbHandler", "Data successfully written to the db");

        return true;
    }
}
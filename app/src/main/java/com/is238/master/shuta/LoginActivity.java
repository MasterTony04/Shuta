package com.is238.master.shuta;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

// sudo chmod a+rwx /dev/kvm

import com.is238.master.shuta.Database.Contract;
import com.is238.master.shuta.Database.DatabaseClasses;
import com.is238.master.shuta.Database.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText reg_no_text, passwordTxt;
    Button loginBtn;
    CheckBox rememberMeChkBx;
    Spinner type;
    String user_type;
    int student_id;
    Bundle bundle = new Bundle();


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


        if(user_type.equals("Admin")){
            Cursor c = getContentResolver().query(Contract.AdminContract.CONTENT_URI, null, null, null, null);
            Log.e("fzghsdgfdfdg", "atleast nmepita hapa");
            while (c.moveToNext()) {
                Log.e("Db", c.getString(1));

                if (username.equals(c.getString(1))) {
                    if (password.equals(c.getString(0))) {
                        landingPageIntent = new Intent(LoginActivity.this, AdminActivity.class);
                        bundle.putString("username", username);
                        landingPageIntent.putExtras(bundle);
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
        if(user_type.equals("Teacher")){

            Cursor c = getContentResolver().query(Contract.TeacherContract.contentUri, null, null, null, null);
            while (c.moveToNext()) {

                if (username.equals(c.getString(6))) {
                    if (password.equals(c.getString(1))) {
                        landingPageIntent = new Intent(LoginActivity.this, StaffLandingActivity.class);
                        bundle.putString("username", username);
                        landingPageIntent.putExtras(bundle);
                        startActivity(landingPageIntent);
                    } else {
                        Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //try Teacher Login
                    Toast.makeText(this, "You are not registered as a Teacher", Toast.LENGTH_SHORT).show();
                }
            }
            c.close();
        }
        if(user_type.equals("Student")){
            Cursor c = getContentResolver().query(Contract.StudentContract.contentUri, null, null, null, null);
            while (c.moveToNext()) {

                if (username.equals(c.getString(8))) {
                    if (password.equals(c.getString(1))) {
                        landingPageIntent = new Intent(LoginActivity.this, StudentLandingPage.class);
                        bundle.putString("student_name", username);

                        landingPageIntent.putExtras(bundle);

                        startActivity(landingPageIntent);
                    } else {
                        Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //try Teacher Login
                    Toast.makeText(this, "You are not registered as a Student", Toast.LENGTH_SHORT).show();
                }
            }
            c.close();
        }

    }


    private void init() {
        reg_no_text = findViewById(R.id.regNo);
        passwordTxt = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginButton);
        rememberMeChkBx = findViewById(R.id.remberMecheckBox);
        type = findViewById(R.id.lg_spinner);
        type.setOnItemSelectedListener(this);

        ArrayList<String> login_types = new ArrayList<>();
        login_types.add("Admin");
        login_types.add("Teacher");
        login_types.add("Student");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, login_types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(adapter);

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
            Dao<DatabaseClasses.Stream, Integer> streams = getHelper().getDao(DatabaseClasses.Stream.class);
            streams.delete(databaseClasses.streamCall());
            for (int i = 0; i < 4; i++) {
                streams.createIfNotExists(databaseClasses.streamCall((i + 1), setStreamLetter(i)));
            }


        } catch (SQLException e) {
            Log.v("", "Admin already exists");
            e.printStackTrace();
        }

        return true;
    }

    private char setStreamLetter(int i) {
        if(i==0)
            return 'A';
        if(i==1)
            return 'B';
        if(i==2)
            return 'C';
        if(i==3)
            return 'D';
        else
            return 'E';
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        user_type = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
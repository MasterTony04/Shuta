package com.is238.master.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.is238.master.shuta.Database.DatabaseClasses;
import com.is238.master.shuta.Database.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

public class activity_teacher_registration extends AppCompatActivity {
    private EditText name, id, phone;
    private RadioGroup gender;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_registration);
        init();
    }

    private void init(){
        name = findViewById(R.id.teacherName);
        id = findViewById(R.id.teacherId);
        phone = findViewById(R.id.teacherPhone);
        gender = findViewById(R.id.tr_gender);
    }


    public void onRegister(View view){
        String first_name, last_name;
        try{
            String[] names =   name.getText().toString().split(" ");
             first_name =names[0];
             last_name = names[1];
        }catch (ArrayIndexOutOfBoundsException e){
            last_name = "Teacher";
            first_name = name.getText().toString();
        }

        String regNo = id.getText().toString();
        String phone_number = phone.getText().toString();

        int genderCheckedRadioButtonId  = gender.getCheckedRadioButtonId();
        char sex;

        if(genderCheckedRadioButtonId == 0)
            sex = 'M';
        else{
            sex = 'F';
        }

        DatabaseClasses databaseClasses = new DatabaseClasses();

       try{
           Dao<DatabaseClasses.Teacher, Integer> teacherDao = getHelper().getDao(DatabaseClasses.Teacher.class);
           teacherDao.createIfNotExists(databaseClasses.teacherCall(first_name,last_name,"ShutaTeacher", phone_number,regNo,sex));

           Toast.makeText(getApplicationContext(), "Teacher Created Successfully", Toast.LENGTH_LONG).show();
           Intent teacherListIntent = new Intent(this, StaffItemActivity.class);
           startActivity(teacherListIntent);
       }
       catch (SQLException e){
           e.printStackTrace();
       }
    }

    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }
}

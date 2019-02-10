package com.is238.master.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.is238.master.shuta.Database.DatabaseClasses;
import com.is238.master.shuta.Database.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectLandingPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
private static Button subjectButton;
private EditText sub_name;
private Spinner sub_teacher;
int sub_teacher_int;
DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_landing_page);
        init();

    }


    public void onSubjectAdd(View view){
       String sub_name_str = sub_name.getText().toString();
       DatabaseClasses databaseClasses = new DatabaseClasses();

       try {
           Dao<DatabaseClasses.Subject, Integer> subjectIntegerDao = getHelper().getDao(DatabaseClasses.Subject.class);
           subjectIntegerDao.createIfNotExists(databaseClasses.subjectCall(sub_name_str, sub_teacher_int));

           Toast.makeText(this, "Subject added successfully", Toast.LENGTH_LONG).show();

           Intent sub_list_intent = new Intent(SubjectLandingPage.this, SubjectListActivity.class);
           startActivity(sub_list_intent);
       }
       catch (SQLException e){
           e.printStackTrace();
       }
    }
    public void onCancel(View view){
        finish();
    }

    protected void init(){
        sub_name = findViewById(R.id.subject_name);
        sub_teacher = findViewById(R.id.sub_tr_spinner);

        List<String> teachersName = new ArrayList<>();

       try{
           Dao<DatabaseClasses.Teacher, Integer> teacherDao = getHelper().getDao(DatabaseClasses.Teacher.class);
           List<DatabaseClasses.Teacher> teacherList = teacherDao.queryForAll();
           DatabaseClasses.Teacher teacherStream [] = teacherList.toArray(new DatabaseClasses.Teacher[0]);
           for(DatabaseClasses.Teacher teacher: teacherStream){
               teachersName.add(teacher.getFirst_name() + " " + teacher.getLast_name());
           }

           ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, teachersName);
           adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
           sub_teacher.setAdapter(adapter2);
       }
       catch (SQLException e){
           e.printStackTrace();
       }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       sub_teacher_int =  parent.getSelectedItemPosition();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }

}


package com.is238.master.shuta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.is238.master.shuta.Database.Contract;
import com.is238.master.shuta.Database.DatabaseClasses;
import com.is238.master.shuta.Database.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentView extends AppCompatActivity {

    ListView allstudents;
    DatabaseHelper databaseHelper;
    List<String> studentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);
        init();
    }

    protected void init(){
        allstudents = findViewById(R.id.list_students);

        try{
            Dao<DatabaseClasses.Student, Integer> classIntegerDao = getHelper().getDao(DatabaseClasses.Student.class);
            List<DatabaseClasses.Student> studentListObj = classIntegerDao.queryForAll();
            for(DatabaseClasses.Student classIns: studentListObj){
                studentList.add(classIns.getFirst_name() + " " + classIns.getLast_name());
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        ArrayAdapter<String> subjectArrayAdapter = new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,
                studentList
        );
        allstudents.setAdapter(subjectArrayAdapter);
    }
    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }



}

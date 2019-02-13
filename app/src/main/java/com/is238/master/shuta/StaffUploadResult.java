package com.is238.master.shuta;

import android.content.Intent;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.is238.master.shuta.Database.Contract;
import com.is238.master.shuta.Database.DatabaseClasses;
import com.is238.master.shuta.Database.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffUploadResult extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner studentSpinner, subjectSpinner;
    int selStudent, selSubject;
    EditText marks;
    DatabaseHelper databaseHelper;
    List<String> studentStrList, subjectStrList;
    Bundle data = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_upload_result);
        init();
    }

    private void init() {
        studentSpinner = findViewById(R.id.studentSpinner);
        subjectSpinner = findViewById(R.id.subjectSpinner);
        studentStrList = new ArrayList<>();
        subjectStrList = new ArrayList<>();

        marks = findViewById(R.id.marks);
        listStudents();
        listSubjects();

        studentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selStudent = adapterView.getSelectedItemPosition();
                Log.e("Position", Integer.toString(selStudent));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        subjectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selSubject = adapterView.getSelectedItemPosition();
                Log.e("Subject", Integer.toString(selSubject));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void onAdd(View view){
        int studentMarks  = 0;
        try{
             studentMarks = Math.toIntExact(Long.parseLong(marks.getText().toString()));
        }
        catch (Exception e){
            Toast.makeText(this, "Invalid Marks", Toast.LENGTH_SHORT).show();
        }

        try{
            Dao<DatabaseClasses.Results, Integer> results = getHelper().getDao(DatabaseClasses.Results.class);
            results.createOrUpdate(new DatabaseClasses.Results(getRegNo(),selSubject +1,studentMarks));
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        Intent staffLandingIntent = new Intent(StaffUploadResult.this, StaffLandingActivity.class);
        Toast.makeText(this, "Results Uploaded Successfully", Toast.LENGTH_SHORT).show();
        data.putString("username",getIntent().getExtras().getString("username"));
        data.putInt("id", getIntent().getExtras().getInt("id"));
        staffLandingIntent.putExtras(data);
        startActivity(staffLandingIntent);

    }

    private String getRegNo() {
        try {
            Dao<DatabaseClasses.Student, Integer> student = getHelper().getDao(DatabaseClasses.Student.class);
            PreparedQuery<DatabaseClasses.Student> preparedQuery = student.queryBuilder()
                    .where()
                    .eq(Contract.StudentContract._ID, selStudent+1)
                    .prepare();
            List<DatabaseClasses.Student> selStudentObj = student.queryForAll();

            return selStudentObj.get(0).getRegNo();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public void onCancel(View view){
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    protected void listStudents(){
        List<DatabaseClasses.Student> studentList;
        try{
            Dao<DatabaseClasses.Student, Integer> students = getHelper().getDao(DatabaseClasses.Student.class);
            studentList =  students.queryForAll();
            for(DatabaseClasses.Student student: studentList){
                String studentName = student.getFirst_name() + " " + student.getLast_name();
                studentStrList.add(studentName);
                Log.e("Student", studentName);
            }
            for(String name: studentStrList)
                Log.e("List", name);

            ArrayAdapter<String> studentAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item,
                    studentStrList);

            studentSpinner.setAdapter(studentAdapter);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    protected void listSubjects(){
        List<DatabaseClasses.Subject> subjectList;
        try{
            Dao<DatabaseClasses.Subject, Integer> subjects = getHelper().getDao(DatabaseClasses.Subject.class);
            subjectList =  subjects.queryForAll();
            for(DatabaseClasses.Subject subject: subjectList){
                subjectStrList.add(subject.getName());
            }

            ArrayAdapter<String> subjectAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item,
                    subjectStrList);

            subjectSpinner.setAdapter(subjectAdapter);
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

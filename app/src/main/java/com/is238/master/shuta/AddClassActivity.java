package com.is238.master.shuta;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.is238.master.shuta.Database.Contract;
import com.is238.master.shuta.Database.DatabaseClasses;
import com.is238.master.shuta.Database.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddClassActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static EditText classnam;
    private static Button add;
    private DatabaseHelper databaseHelper;
    private int teacher;
    private char stream;
    private Spinner streamSpinner, teacherSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        initView();
    }

    private void initView(){
         streamSpinner = findViewById(R.id.spinnerclass);
         teacherSpinner =findViewById(R.id.spinnerTeacher);


        streamSpinner.setOnItemSelectedListener(this);

        //Load the streams in the item array
        List<String> items = new ArrayList<>();
        List<String> teachersName = new ArrayList<>();

        if (getContentResolver().getType(Contract.StreamContract.contentUri) != null){
            items.add("A");
            items.add("B");
            items.add("C");
            items.add("D");

            try {
                Cursor teacherCursor = getContentResolver().query(Contract.TeacherContract.contentUri, null, null, null, null);

                while (teacherCursor.moveToNext()) {
                    teachersName.add(teacherCursor.getString(1) + " " + teacherCursor.getString(2));
                }
                teacherCursor.close();
            }
            catch (Exception e){
                items.add("No registered Streams");
                teachersName.add("No registered Teacher");
                e.printStackTrace();
            }
        }
        else {
            try{
                items.add("A");
                items.add("B");
                items.add("C");
                items.add("D");

                Dao<DatabaseClasses.Teacher, Integer> teacherDao = getHelper().getDao(DatabaseClasses.Teacher.class);
                List<DatabaseClasses.Teacher> teacherList = teacherDao.queryForAll();
                DatabaseClasses.Teacher teacherStream [] = teacherList.toArray(new DatabaseClasses.Teacher[0]);
                for(DatabaseClasses.Teacher teacher: teacherStream){
                    teachersName.add(teacher.getFirst_name() + " " + teacher.getLast_name());
                }


            }
            catch (SQLException e){
                e.printStackTrace();
                items.add("No registered Streams");
                teachersName.add("No registered Teacher");
            }

        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        streamSpinner.setAdapter(adapter);
        add=findViewById(R.id.btnadd);
        classnam=findViewById(R.id.txtclass);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, teachersName);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teacherSpinner.setAdapter(adapter2);

        teacherSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                teacher = adapterView.getSelectedItemPosition();
                Log.e("Spinner", Integer.toString(teacher));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        streamSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               stream = adapterView.getSelectedItem().toString().toCharArray()[0];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }



    public void onClassAdd(View view) {
        String className;

        className = classnam.getText().toString();
        teacher = teacherSpinner.getSelectedItemPosition();
        Log.e("Teacher_id", Integer.toString(teacher));

        ContentValues classValues = new ContentValues();
        DatabaseClasses databaseClasses = new DatabaseClasses();
        classValues.clear();

        classValues.put(Contract.ClassContract.TEACHER_ID, teacher);
        classValues.put(Contract.ClassContract.CLASS_NAME, className);
        classValues.put(Contract.ClassContract.STREAM_ID, Character.toString(stream));
        if (getContentResolver().getType(Contract.ClassContract.CONTENT_URI) != null) {
            getContentResolver().insert(Contract.ClassContract.CONTENT_URI, classValues);
            Toast.makeText(getApplicationContext(), "Class Added successfully", Toast.LENGTH_LONG).show();
            Intent classListIntent= new Intent(this, ClassLandingPage.class);
            startActivity(classListIntent);
        }

        else {
            try{
                Dao<DatabaseClasses.Class, Integer> classDao = getHelper().getDao(DatabaseClasses.Class.class);
                classDao.createIfNotExists(databaseClasses.classCall(className,teacher,stream));
                Toast.makeText(getApplicationContext(), "Class Added successfully", Toast.LENGTH_LONG).show();
                Intent classListIntent= new Intent(this, ClassLandingPage.class);
                startActivity(classListIntent);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

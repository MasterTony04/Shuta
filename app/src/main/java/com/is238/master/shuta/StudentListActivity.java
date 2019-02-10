package com.is238.master.shuta;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.is238.master.shuta.Database.Contract;

public class StudentListActivity extends AppCompatActivity {
    ListView student_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        init();
    }

    public void onStudentAdd(View view){
        Intent studentAddIntent = new Intent(StudentListActivity.this, activity_student_registration.class);
        startActivity(studentAddIntent);
    }

    public void init(){
        student_list = findViewById(R.id.list_student);
        displayStudents();
    }

    private void displayStudents() {

            Cursor cursor = getContentResolver().query(Contract.StudentContract.contentUri,null,null,null,null);
            String [] columns = {
                    Contract.StudentContract.FIRST_NAME
            };
            int [] list_items = {R.id.class_name};

            SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
                    getApplicationContext(),
                    R.layout.class_list_row,
                    cursor,
                    columns,
                    list_items
            );
            student_list.setAdapter(cursorAdapter);
        }
    }


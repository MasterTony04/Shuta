package com.is238.master.shuta;

import android.database.Cursor;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.is238.master.shuta.Database.Contract;

public class SubjectListActivity extends AppCompatActivity {
    ListView subjectList;



   private FloatingActionButton subjAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);
        init();

        subjAdd=findViewById(R.id.addSubject);

        subjAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newSubject = new Intent(SubjectListActivity.this,SubjectLandingPage.class);
                startActivity(newSubject);
            }
        });
    }


    protected void init(){

    subjectList = findViewById(R.id.list_subject);
    displayClasses();

    }

    private void displayClasses() {
        Cursor cursor = getContentResolver().query(Contract.SubjectContract.contentUri,null,null,null,null);
        String [] columns = {
                Contract.SubjectContract.NAME
        };
        int [] list_items = {R.id.class_name};

        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
                getApplicationContext(),
                R.layout.class_list_row,
                cursor,
                columns,
                list_items
        );
        subjectList.setAdapter(cursorAdapter);
    }
}

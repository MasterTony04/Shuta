package com.is238.master.shuta;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.is238.master.shuta.Database.Contract;

public class SubjectListActivity extends AppCompatActivity {
    ListView subjectList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);
        init();
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

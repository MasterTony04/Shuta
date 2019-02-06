package com.is238.master.shuta;

import android.content.Intent;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.is238.master.shuta.Database.Contract;

public class ClassLandingPage extends AppCompatActivity {
    ListView list_view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_landing_page);

        init();
        displayClasses();

    }

    private void displayClasses() {
        Cursor cursor = getContentResolver().query(Contract.ClassContract.contentUri,null,null,null,null);

        String [] columns = {
                Contract.ClassContract.CLASS_NAME,
                Contract.ClassContract.TEACHER_ID
        };
        int [] list_items = {R.id.class_name,R.id.class_teacher};

        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
          getApplicationContext(),
          R.id.list_row, cursor, columns,list_items
        );
        list_view.setAdapter(cursorAdapter);
    }

    private void init(){
        list_view = findViewById(R.id.list_class);
    }


    public void classform(View view) {

        Intent addclassIntent= new Intent(this,AddClassActivity.class);
        startActivity(addclassIntent);
    }
}

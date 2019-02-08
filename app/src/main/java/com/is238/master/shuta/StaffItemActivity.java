package com.is238.master.shuta;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.is238.master.shuta.Database.Contract;

public class StaffItemActivity extends AppCompatActivity {
    ListView staff_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_item);
        init();

    }

    public void staffForm(View view) {

        Intent staffIntent = new Intent(this,activity_teacher_registration.class);
        startActivity(staffIntent);
    }

    private void init(){
        staff_list = findViewById(R.id.list_staff);
        displayStaff();
    }

    private void displayStaff(){
        Cursor cursor = getContentResolver().query(Contract.TeacherContract.contentUri,null,null,null,null);
        String [] columns = {
                Contract.TeacherContract.FIRST_NAME
        };
        int [] list_items = {R.id.class_name};

        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
                getApplicationContext(),
                R.layout.class_list_row,
                cursor,
                columns,
                list_items
        );
        staff_list.setAdapter(cursorAdapter);
    }
}

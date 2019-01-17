package com.is238.master.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StaffItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_item);
    }

    public void staffForm(View view) {

        Intent staffIntent = new Intent(this,activity_student_registration.class);
        startActivity(staffIntent);
    }
}

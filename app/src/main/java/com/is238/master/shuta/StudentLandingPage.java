package com.is238.master.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.is238.master.shuta.Database.DatabaseClasses;

public class StudentLandingPage extends AppCompatActivity {
    String studentName;
    private TextView student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_landing_page);
    }

    public void viewStudentResults(View view) {
        Intent resultsIntent = new Intent(StudentLandingPage.this, StudentResultsActivity.class);
        String username = getIntent().getExtras().getString("student_name");
        Bundle bundle = new Bundle();
        bundle.putString("username", username);

        resultsIntent.putExtras(bundle);

        startActivity(resultsIntent);
    }

    public void sub_teachers(View view) {
        Intent resultsIntent = new Intent(StudentLandingPage.this, StudentResultsActivity.class);
        startActivity(resultsIntent);
    }
}

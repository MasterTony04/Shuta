package com.is238.master.shuta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StudentLandingPage extends AppCompatActivity {

    protected int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutCheck();

    }

    public void viewStudentResults(View view) {

        counter=1;
        layoutCheck();
    }


    public void layoutCheck(){

        if(counter==0)
            setContentView(R.layout.activity_student_landing_page);
        else if(counter==1)
            setContentView(R.layout.resultstudent);
        else
            setContentView(R.layout.sub_teachers);
    }

    public void sub_teachers(View view) {

        counter=2;
        layoutCheck();
    }
    //mastertony is dangerous
}

package com.is238.master.shuta;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SubjectListActivity extends AppCompatActivity {

   private FloatingActionButton subjAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);

        subjAdd=findViewById(R.id.addSubject);

        subjAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newSubject = new Intent(SubjectListActivity.this,SubjectLandingPage.class);
                startActivity(newSubject);
            }
        });
    }

}

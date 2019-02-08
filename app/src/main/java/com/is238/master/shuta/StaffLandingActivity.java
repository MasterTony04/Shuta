package com.is238.master.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StaffLandingActivity extends AppCompatActivity {

    private Button subView,classView,uploadResults,studentView;
            TextView username;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_landing);
        init();


        savedInstanceState=getIntent().getExtras();


        username.setText(userName=savedInstanceState.getString("USERNAME"));

        subView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewsub = new Intent(StaffLandingActivity.this,SubjectViewActivity.class);
                startActivity(viewsub);
            }
        });

        classView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewclass = new Intent(StaffLandingActivity.this,ClassViewTeacher.class);
                startActivity(viewclass);
            }
        });

        uploadResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultUpload = new Intent(StaffLandingActivity.this,StaffUploadResult.class);
                startActivity(resultUpload);
            }
        });

        studentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewstudent = new Intent(StaffLandingActivity.this,StudentView.class);
                startActivity(viewstudent);
            }
        });


    }


    public void init(){

        subView=findViewById(R.id.subjectsButton);
        classView=findViewById(R.id.classesbtn);
        uploadResults=findViewById(R.id.uploadtbtn);
        studentView=findViewById(R.id.viewbtn);
        username=findViewById(R.id.textView2);

    }


}

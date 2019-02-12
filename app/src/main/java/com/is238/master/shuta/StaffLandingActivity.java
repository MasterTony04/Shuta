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

    Bundle teacherData = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_landing);
        init();
        final Bundle data =getIntent().getExtras();
        userName = data.getString("username");


        username.setText(userName);

        subView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewsub = new Intent(StaffLandingActivity.this,SubjectViewActivity.class);
                teacherData.putString("username",userName);
                teacherData.putInt("id", data.getInt("id"));
                viewsub.putExtras(teacherData);
                startActivity(viewsub);
            }
        });

        classView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewclass = new Intent(StaffLandingActivity.this,ClassViewTeacher.class);
                teacherData.putString("username",userName);
                teacherData.putInt("id", data.getInt("id"));
                viewclass.putExtras(teacherData);
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

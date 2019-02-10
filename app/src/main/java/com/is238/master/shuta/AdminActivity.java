package com.is238.master.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    Button classBtn,subjectbtn,studentsbtn,staffbtn;
    String userName,userType;
    TextView userView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

       initizations();


       savedInstanceState=getIntent().getExtras();


       userView.setText(userName=savedInstanceState.getString("USERNAME"));

       classBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent classIntent = new Intent(AdminActivity.this,ClassLandingPage.class);
               startActivity(classIntent);
           }
       });

       staffbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent staffIntent = new Intent(AdminActivity.this,StaffItemActivity.class);
               startActivity(staffIntent);
           }
       });
       subjectbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent subjectIntent = new Intent(AdminActivity.this,SubjectListActivity.class);
               startActivity(subjectIntent);
           }
       });
       studentsbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               //nothing is implemented here
               Intent studentIntent = new Intent(AdminActivity.this, activity_student_registration.class);
               startActivity(studentIntent);
           }
       });


    }


    private void initizations(){

         classBtn=(Button) findViewById(R.id.classesbtn);
         subjectbtn=(Button)findViewById(R.id.subject);
         studentsbtn=(Button)findViewById(R.id.studentbtn);
         staffbtn=(Button)findViewById(R.id.staffbtn);
         userView=findViewById(R.id.nameTextView);

    }



}

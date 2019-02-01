package com.is238.master.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    Button classBtn,subjectbtn,studentsbtn,staffbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

       initizations();

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
               //Intent subjectIntent = new Intent(AdminActivity.this,SubjectLandingPage.class);
              // startActivity(subjectIntent);
           }
       });


    }


    private void initizations(){

         classBtn=(Button) findViewById(R.id.classesbtn);
         subjectbtn=(Button)findViewById(R.id.subject);
         studentsbtn=(Button)findViewById(R.id.studentbtn);
         staffbtn=(Button)findViewById(R.id.staffbtn);

    }

}

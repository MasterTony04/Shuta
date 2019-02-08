package com.is238.master.shuta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class SubjectListActivity extends AppCompatActivity {
    ListView subjectList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);
    }

    protected void init(){

    subjectList.findViewById(R.id.list_subject);



    }
}

package com.is238.master.shuta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ClassLandingPage extends AppCompatActivity {
 private static ListView classlist;

    // Array of strings...
    String formclass[] = {"Form 1A", "Form 2B", "FORM 3A", "FORM 4A"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_landing_page);

        classlist = (ListView)findViewById(R.id.list_class);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_class_landing_page, R.id.textView, formclass);
        classlist.setAdapter(arrayAdapter);
    }
}

package com.is238.master.shuta;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class activity_student_form extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_student_form);
    }
}

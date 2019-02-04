package com.is238.master.shuta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioButton;

public class activity_student_registration extends AppCompatActivity {

    private EditText student_Name, student_RegNo, student_Dob, student_Home, student_Parent, student_Class;
    private String sName, sRegNo, sDob, sHome, sParent, sClass, sSex;
    private RadioGroup rGS;
    private RadioButton femaleOption, maleOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
    }


    protected void getStudentData(View view){
            student_Name = findViewById(R.id.studentName);
            student_RegNo = findViewById(R.id.studentRegNo);
            student_Home = findViewById(R.id.studentHome);
            student_Parent = findViewById(R.id.studentParent);
            student_Class = findViewById(R.id.studentClass);
            student_Dob = findViewById(R.id.studentDOB);

            rGS = findViewById(R.id.radioGroup2);
            femaleOption = findViewById(R.id.femaleRadioButton);
            maleOption = findViewById(R.id.maleRadioButton);

            int i = rGS.getCheckedRadioButtonId();
            RadioButton rSex = rGS.findViewById(i);

            if(
                    (student_Name.getText().toString().trim().isEmpty()) ||
                    (student_RegNo.getText().toString().trim().isEmpty()) ||
                    (student_Home.getText().toString().trim().isEmpty()) ||
                    (student_Parent.getText().toString().trim().isEmpty()) ||
                    (student_Class.getText().toString().trim().isEmpty()) ||
                    (student_Dob.getText().toString().trim().isEmpty()) ||
                            (rSex.getText().toString().trim().isEmpty())
                    ){
                Toast.makeText(this, "make sure all field are filled", Toast.LENGTH_SHORT).show();
        }else{
                sName = student_Name.getText().toString().trim();
                sRegNo = student_RegNo.getText().toString().trim();
                sDob = student_Dob.getText().toString().trim();
                sHome = student_Home.getText().toString().trim();
                sParent = student_Parent.getText().toString().trim();
                sClass =  student_Class.getText().toString().trim();
                sSex = rSex.getText().toString().trim();
                Toast.makeText(this,
                        "OK: " + sName + " "
                                + sSex + " "
                                + sRegNo + " "
                                + sDob + " "
                                + sHome + " "
                                + sParent + " "
                                + sClass + " ",
                        Toast.LENGTH_SHORT
                ).show();
            }
    }





}

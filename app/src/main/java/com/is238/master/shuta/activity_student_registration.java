package com.is238.master.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.RadioButton;

import com.is238.master.shuta.Database.DatabaseClasses;
import com.is238.master.shuta.Database.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class activity_student_registration extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText student_Name, student_RegNo, student_Home, student_Parent,student_Dob;
    private Spinner student_Class;
    private String sName, sRegNo, sDob, sHome, sParent, sClass, sSex;
    private RadioGroup rGS;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        init();
    }

    private void init(){
        student_Class = findViewById(R.id.st_class);
        student_Class.setOnItemSelectedListener(this);
        List<String> classNames = new ArrayList<>();

        try {
            Dao<DatabaseClasses.Class, Integer> streamDao = getHelper().getDao(DatabaseClasses.Class.class);
            List<DatabaseClasses.Class> streamList = streamDao.queryForAll();
            DatabaseClasses.Class classes[] = streamList.toArray(new DatabaseClasses.Class[0]);
            for (DatabaseClasses.Class clas : classes) {
                String letter = clas.getClass_name();
                Log.e("Class", clas.getClass_name());
                classNames.add(letter);
            }
        }
        catch (SQLException e){
            classNames.add("No Registered Classes");
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        student_Class.setAdapter(adapter);
    }


    protected void getStudentData(View view){
        student_Name = findViewById(R.id.studentName);
        student_RegNo = findViewById(R.id.studentRegNo);
        student_Home = findViewById(R.id.st_residence);
        student_Parent = findViewById(R.id.studentParent);
        student_Dob =findViewById(R.id.st_dob);

        rGS = findViewById(R.id.st_gender);

        int i = rGS.getCheckedRadioButtonId();
        RadioButton rSex = rGS.findViewById(i);

        if(
                (student_Name.getText().toString().trim().isEmpty()) ||
                        (student_RegNo.getText().toString().trim().isEmpty()) ||
                        (student_Home.getText().toString().trim().isEmpty()) ||
                        (student_Parent.getText().toString().trim().isEmpty())||
                        (student_Dob.getText().toString().trim().isEmpty()) ||
                        (rSex.getText().toString().trim().isEmpty())
        ){
            Toast.makeText(this, "make sure all field are filled", Toast.LENGTH_SHORT).show();
        }else{
            String first_name,last_name;

            sName = student_Name.getText().toString().trim();
            sRegNo = student_RegNo.getText().toString().trim();
            sDob = student_Dob.getText().toString().trim();
            sHome = student_Home.getText().toString().trim();
            sParent = student_Parent.getText().toString().trim();
            sSex = rSex.getText().toString().trim();
            int selGender = rGS.getCheckedRadioButtonId();

            char sex='M';

            if(selGender == 1)
                sex ='F';

            try{
                first_name = sName.split(" ")[0];
                last_name = sName.split(" ")[1];

            }
            catch (ArrayIndexOutOfBoundsException e){
                first_name = sName;
                last_name = "Student";
            }

            int class_id = student_Class.getSelectedItemPosition();


            DatabaseClasses databaseClasses = new DatabaseClasses();

            try{
                Dao<DatabaseClasses.Student, Integer> studentIntegerDao = getHelper().getDao(DatabaseClasses.Student.class);
                studentIntegerDao.createIfNotExists(databaseClasses.studentCall(first_name,last_name,"StudentShuta", class_id,sex,sParent,sHome,sRegNo));
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            Toast.makeText(this, "Student registered Successfully", Toast.LENGTH_LONG).show();
           finish();
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }

    public void cancel(View view){
        finish();
    }
}

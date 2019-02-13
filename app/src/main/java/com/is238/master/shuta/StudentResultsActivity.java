package com.is238.master.shuta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.is238.master.shuta.Database.Contract;
import com.is238.master.shuta.Database.DatabaseClasses;
import com.is238.master.shuta.Database.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;

import java.sql.SQLException;
import java.util.List;

public class StudentResultsActivity extends AppCompatActivity {
    TableLayout result_table;
    TextView bio, math, geo, civics, hist,chem, eng, kiswahili, phy;
    TextView totalMarks,avarage, position;
    DatabaseHelper databaseHelper;
    List<DatabaseClasses.Results> resultsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_results);
        init();
    }

    private void init(){
     result_table = findViewById(R.id.result_table);
     bio = findViewById(R.id.bio);
     math = findViewById(R.id.math);
     geo = findViewById(R.id.geo);
     civics = findViewById(R.id.civics);
     hist = findViewById(R.id.hist);
     chem = findViewById(R.id.chem);
     eng = findViewById(R.id.eng);
     kiswahili = findViewById(R.id.kiswahili);
     phy = findViewById(R.id.phy);

     totalMarks = findViewById(R.id.totalMarks);
     avarage = findViewById(R.id.avarage);
     position = findViewById(R.id.position);

     getStudentResults();

    }

    private void getStudentResults() {
        String username = getIntent().getExtras().getString("student_name");
        DatabaseClasses databaseClasses = new DatabaseClasses();
        DatabaseClasses.Results resultsObj = databaseClasses.resultsCall();

        try{
            Dao<DatabaseClasses.Results, Integer> resultsIntegerDao = getHelper().getDao(DatabaseClasses.Results.class);
            PreparedQuery<DatabaseClasses.Results> resultsPreparedQuery = resultsIntegerDao.queryBuilder()
                    .where()
                    .eq(Contract.ResultsContract.REG_NO, username)
                    .prepare();

             resultsList = resultsIntegerDao.queryForAll();
//            resultsIntegerDao.query(resultsPreparedQuery);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        if(resultsList != null){
            for(DatabaseClasses.Results result: resultsList){

                if(result.getSubject_id() == 0){
                    //Mathematics
                    String marks = Integer.toString(result.getMarks()) + "%";
                    math.setText(marks);
                }
                if(result.getSubject_id() == 1){
                    //Physics
                    String marks = Integer.toString(result.getMarks()) + "%";
                    phy.setText(marks);
                }
                if(result.getSubject_id() == 2){
                    //Chemistry
                    String marks = Integer.toString(result.getMarks()) + "%";
                    chem.setText(marks);
                }
                if(result.getSubject_id() == 3){
                    //Biology
                    String marks = Integer.toString(result.getMarks()) + "%";
                    bio.setText(marks);
                }
                if(result.getSubject_id() == 4){
                    //Geography
                    String marks = Integer.toString(result.getMarks()) + "%";
                    geo.setText(marks);
                }
                if(result.getSubject_id() == 5){
                    //History
                    String marks = Integer.toString(result.getMarks()) + "%";
                    hist.setText(marks);
                }
                if(result.getSubject_id() == 6){
                    //Civics
                    String marks = Integer.toString(result.getMarks()) + "%";
                    civics.setText(marks);
                }
                if(result.getSubject_id() == 7){
                    //Kiswahili
                    String marks = Integer.toString(result.getMarks()) + "%";
                    kiswahili.setText(marks);
                }
                if(result.getSubject_id() == 8){
                    //English
                    String marks = Integer.toString(result.getMarks()) + "%";
                    eng.setText(marks);
                }

            }

        }
        else {
            Toast.makeText(this, "Results Not yet Published", Toast.LENGTH_SHORT).show();
        }

    }

    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }
}

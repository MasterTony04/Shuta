package com.is238.master.shuta;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.is238.master.shuta.Database.Contract;
import com.is238.master.shuta.Database.DatabaseClasses;
import com.is238.master.shuta.Database.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectViewActivity extends AppCompatActivity {
    ListView tr_sub_list;
    String username, regno;
    DatabaseHelper databaseHelper;
    int teacher_id;
    Bundle data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_view);
        savedInstanceState = getIntent().getExtras();
        regno = savedInstanceState.getString("regno");
        init();
    }

    private void init(){
        tr_sub_list = findViewById(R.id.tr_sub_list);
        displayMySubs();
    }

    private void displayMySubs(){
        List<String> subjectNames = new ArrayList<String>();
        //get teacher id
        getTeacherId();

        try{

            Dao<DatabaseClasses.Subject, Integer> subjectDao = getHelper().getDao(DatabaseClasses.Subject.class);

            PreparedQuery<DatabaseClasses.Subject> preparedQuery = subjectDao.queryBuilder()
                    .where()
                    .eq(Contract.SubjectContract.TEACHER_ID, teacher_id)
                    .prepare();
            List<DatabaseClasses.Subject> subjectList = subjectDao.query(preparedQuery);
            for(DatabaseClasses.Subject subject: subjectList){
                subjectNames.add(subject.getName());
                Log.e("Subject", subject.getName());
                Log.e("Teacher_id", Integer.toString(subject.getTeacher_id()));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        ArrayAdapter<String> subjectArrayAdapter = new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,
                subjectNames
        );
        tr_sub_list.setAdapter(subjectArrayAdapter);
    }
    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }

    private void getTeacherId(){
        data = getIntent().getExtras();
        teacher_id = data.getInt("id");
    }

}

package com.is238.master.shuta;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.is238.master.shuta.Database.Contract;
import com.is238.master.shuta.Database.DatabaseClasses;
import com.is238.master.shuta.Database.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;

import java.sql.SQLException;
import java.util.List;

public class SubjectViewActivity extends AppCompatActivity {
    ListView tr_sub_list;
    String username;
    DatabaseHelper databaseHelper;
    int teacher_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_view);
        username = savedInstanceState.getString("username");
        init();
    }

    private void init(){
        tr_sub_list = findViewById(R.id.tr_sub_list);
        displayMySubs();
    }

    private void displayMySubs(){

        //get teacher id
        getTeacherId();

        String [] selectionArgs = {username};
        String selection = Contract.SubjectContract.TEACHER_ID + " = ?";

        Cursor c  = getContentResolver().query(Contract.SubjectContract.contentUri,
                null, selection,selectionArgs
                , null);

        String [] columns = {
                Contract.SubjectContract.NAME
        };
        int [] list_items = {R.id.class_name};

        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
                getApplicationContext(),
                R.layout.class_list_row,
                c,
                columns,
                list_items
        );
        tr_sub_list.setAdapter(cursorAdapter);
    }
    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }

    private void getTeacherId(){
        try{
            DatabaseClasses databaseClasses = new DatabaseClasses();
            DatabaseClasses.Teacher teacher = databaseClasses.teacherCall();

            Dao<DatabaseClasses.Teacher, Integer> teacherIntegerDao = getHelper().getDao(DatabaseClasses.Teacher.class);
            PreparedQuery<DatabaseClasses.Teacher> teacherPreparedQuery = teacherIntegerDao.queryBuilder()
                    .where()
                    .eq(Contract.TeacherContract.REGNO, username)
                    .prepare();

            List<DatabaseClasses.Teacher> teachers = teacherIntegerDao.query(teacherPreparedQuery);


            teacher_id = teachers.get(0).getId();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}

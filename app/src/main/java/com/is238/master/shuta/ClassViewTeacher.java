package com.is238.master.shuta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.is238.master.shuta.Database.Contract;
import com.is238.master.shuta.Database.DatabaseClasses;
import com.is238.master.shuta.Database.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassViewTeacher extends AppCompatActivity {

    ListView classes;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_view_teacher);
        init();
    }

    protected void init(){
        Bundle data = getIntent().getExtras();
        int teacher_id = data.getInt("id");
        List<DatabaseClasses.Class> classList;
        List<String> classNames = new ArrayList<>();
        classes = findViewById(R.id.list_subject);

        try{
            Dao<DatabaseClasses.Class, Integer> classIntegerDao = getHelper().getDao(DatabaseClasses.Class.class);
            PreparedQuery<DatabaseClasses.Class> preparedQuery = classIntegerDao.queryBuilder()
                    .where()
                    .eq(Contract.ClassContract.TEACHER_ID, (teacher_id-1))
                    .prepare();

            classList = classIntegerDao.query(preparedQuery);
            Log.e("Inayokuja", Integer.toString(teacher_id));
            for(DatabaseClasses.Class classIns: classList){
                classNames.add(classIns.getClass_name());
                Log.e("Name", classIns.getClass_name());
                Log.e("id", Integer.toString(classIns.getTeacher_id()));
            }


        }
        catch (SQLException e){
            e.printStackTrace();
        }

        ArrayAdapter<String> subjectArrayAdapter = new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,
                classNames
        );
        classes.setAdapter(subjectArrayAdapter);

    }
    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }
}

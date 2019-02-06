package com.is238.master.shuta.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.is238.master.shuta.R;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // DatabaseClasses Name
    private static final String DATABASE_NAME = "shuta.db";
    private static final int DATABASE_VERSION = 2;


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
       try{
           Log.i(DatabaseHelper.class.getName(), "OnCreate");
           TableUtils.createTableIfNotExists(connectionSource, DatabaseClasses.Student.class);
           TableUtils.createTableIfNotExists(connectionSource, DatabaseClasses.Class.class);
           TableUtils.createTableIfNotExists(connectionSource, DatabaseClasses.Teacher.class);
           TableUtils.createTableIfNotExists(connectionSource, DatabaseClasses.Admin.class);
           TableUtils.createTableIfNotExists(connectionSource, DatabaseClasses.Results.class);
           TableUtils.createTableIfNotExists(connectionSource, DatabaseClasses.Subject.class);
           TableUtils.createTableIfNotExists(connectionSource, DatabaseClasses.Stream.class);


       }
       catch (SQLException e){
           Log.v(DatabaseHelper.class.getName(), "Error Writing to DatabaseClasses");
       }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try{
            Log.i(DatabaseHelper.class.getName(), "OnUpgrade");
            TableUtils.dropTable(connectionSource, DatabaseClasses.Student.class, true);
            TableUtils.dropTable(connectionSource, DatabaseClasses.Class.class, true);
            TableUtils.dropTable(connectionSource, DatabaseClasses.Teacher.class, true);
            TableUtils.dropTable(connectionSource, DatabaseClasses.Admin.class, true);
            TableUtils.dropTable(connectionSource, DatabaseClasses.Results.class, true);
            TableUtils.dropTable(connectionSource, DatabaseClasses.Subject.class, true);
            TableUtils.dropTable(connectionSource, DatabaseClasses.Stream.class, true);
            onCreate(database, connectionSource);
        }
        catch (SQLException e){
            Log.v(DatabaseHelper.class.getName(), "Error Updating DatabaseClasses");
        }
        
    }
}

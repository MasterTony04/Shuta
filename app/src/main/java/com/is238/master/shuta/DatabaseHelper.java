package com.is238.master.shuta;

import android.content.Context;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // Database Name
    private static final String DATABASE_NAME = "shuta.db";
    private static final int DATABASE_VERSION = 1;


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }
}

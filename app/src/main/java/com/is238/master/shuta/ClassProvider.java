package com.is238.master.shuta;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import java.util.HashMap;

import static android.provider.MediaStore.Audio.Playlists.Members._ID;

public class ClassProvider extends ContentProvider {
    static final String PROVIDER_NAME = "com.is238.master.shuta.ClassProvider";
    static final String URL = "content://" + PROVIDER_NAME + "/class_tb";
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final String ID = "class_id";
    static final String CLASS = "class";
    static final String SECTION = "section";
    static final String SUBJECT= "subject";
    static final String TEACHER = "teacher";

    private static HashMap<String, String> CLASSES_PROJECTION_MAP;

    static final int CLASSES = 1;
    static final int CLASS_ID = 2;

    static final UriMatcher uriMatcher;
    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "class_tb", CLASSES);
        uriMatcher.addURI(PROVIDER_NAME, "class_tb/#",CLASS_ID);
    }

    private SQLiteDatabase db;
    static final String DATABASE_NAME = "shuta";
    static final String CLASS_TABLE_NAME = "class_tb";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE =
            " CREATE TABLE " + CLASS_TABLE_NAME +
                    " (class_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " classname TEXT NOT NULL, " +" section TEXT NOT NULL, " +" subjectname TEXT NOT NULL, " +
                    " teachersname TEXT NOT NULL);";

    public static void setClassesProjectionMap(HashMap<String, String> classesProjectionMap) {
        CLASSES_PROJECTION_MAP = classesProjectionMap;
    }

    private class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(CREATE_DB_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " +  CLASS_TABLE_NAME);
            onCreate(db);
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
         /** Add a new student record**/
        long rowID = db.insert(	CLASS_TABLE_NAME, "", values);

        /**
         * If record is added successfully
         */
        if (rowID > 0) {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }

        throw new SQLException("Failed to add a record into " + uri);
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        DatabaseHelper dbHelper = new DatabaseHelper(context);
         db=dbHelper.getWritableDatabase();
        return (db==null)?false:true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(CLASS_TABLE_NAME);

        switch (uriMatcher.match(uri)) {
            case CLASSES:
                qb.setProjectionMap(CLASSES_PROJECTION_MAP);
                break;

            case CLASS_ID:
                qb.appendWhere( _ID + "=" + uri.getPathSegments().get(1));
                break;

            default:
        }

        if (sortOrder == null || sortOrder == ""){
            /**
             * By default sort on student names
             */
            sortOrder = CLASS;
        }

        Cursor c = qb.query(db,	projection,	selection,
                selectionArgs,null, null, sortOrder);
        /**
         * register to watch a content URI for changes
         */
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

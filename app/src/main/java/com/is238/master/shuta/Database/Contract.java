package com.is238.master.shuta.Database;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class Contract {
    public static final String DATABASE_NAME = "shuta.db";
    public static final int DATABASE_VERSION = 1;

    public static final String AUTHORITY = "com.is238.master.shuta.Database.ContentProviderDb";

    // accounts table info
    public static class AdminContract implements BaseColumns
    {
        public static final String TABLE_NAME = "admin";

        public static final String CONTENT_URI_PATH = TABLE_NAME;

        public static final String MIMETYPE_TYPE = TABLE_NAME;
        public static final String MIMETYPE_NAME = AUTHORITY
                + ".provider";

        // feild info
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";


        // content uri pattern code
        public static final int CONTENT_URI_PATTERN_MANY = 1;
        public static final int CONTENT_URI_PATTERN_ONE = 2;

        // Refer to activity.
        public static final Uri contentUri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_CONTENT)
                .authority(AUTHORITY)
                .appendPath(CONTENT_URI_PATH)
                .build();
        public static final Uri CONTENT_URI = new Uri.Builder().scheme(ContentResolver.SCHEME_CONTENT).authority(AUTHORITY).appendPath(CONTENT_URI_PATH).build();
    }

    public static class TeacherContract implements BaseColumns
    {
        public static final String TABLE_NAME = "teacher";

        public static final String CONTENT_URI_PATH = TABLE_NAME;

        public static final String MIMETYPE_TYPE = TABLE_NAME;
        public static final String MIMETYPE_NAME = AUTHORITY + ".provider";

        // feild info
        public static final String _ID = "_id";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String PASSWORD = "password";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String GENDER = "gender";
        public static final String REGNO = "regNo";


        // content uri pattern code
        public static final int CONTENT_URI_PATTERN_MANY = 3;
        public static final int CONTENT_URI_PATTERN_ONE = 4;

        // Refer to activity.
        public static final Uri contentUri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_CONTENT)
                .authority(AUTHORITY)
                .appendPath(CONTENT_URI_PATH)
                .build();
    }

    public static class ClassContract implements BaseColumns
    {
        public static final String TABLE_NAME = "class";

        public static final String CONTENT_URI_PATH = TABLE_NAME;

        public static final String MIMETYPE_TYPE = TABLE_NAME;
        public static final String MIMETYPE_NAME = AUTHORITY + ".provider";

        // feild info
        public static final String CLASS_ID = "class_id";
        public static final String CLASS_NAME = "class_name";
        public static final String TEACHER_ID = "teacher_id";
        public static final String STREAM_ID = "stream_id";


        // content uri pattern code
        public static final int CONTENT_URI_PATTERN_MANY = 5;
        public static final int CONTENT_URI_PATTERN_ONE = 6;

        // Refer to activity.
        public static final Uri contentUri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_CONTENT)
                .authority(AUTHORITY)
                .appendPath(CONTENT_URI_PATH)
                .build();
        public static final Uri CONTENT_URI = new Uri.Builder().scheme(ContentResolver.SCHEME_CONTENT).authority(AUTHORITY).appendPath(CONTENT_URI_PATH).build();

    }

    public static class StudentContract implements BaseColumns
    {
        public static final String TABLE_NAME = "student";

        public static final String CONTENT_URI_PATH = TABLE_NAME;

        public static final String MIMETYPE_TYPE = TABLE_NAME;
        public static final String MIMETYPE_NAME = AUTHORITY + ".provider";

        // feild info
        public static final String STUDENT_ID = "student_id";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String CLASS_ID = "class_id";
        public static final String REGNO = "regNo";
        public static final String RESIDENCE = "residence";
        public static final String PHONE = "phone_number";
        public static final String GENDER = "gender";
        public static final String PASSWORD = "password";




        // content uri pattern code
        public static final int CONTENT_URI_PATTERN_MANY = 7;
        public static final int CONTENT_URI_PATTERN_ONE = 8;

        // Refer to activity.
        public static final Uri contentUri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_CONTENT)
                .authority(AUTHORITY)
                .appendPath(CONTENT_URI_PATH)
                .build();
    }

    public static class ResultsContract implements BaseColumns
    {
        public static final String TABLE_NAME = "results";

        public static final String CONTENT_URI_PATH = TABLE_NAME;

        public static final String MIMETYPE_TYPE = TABLE_NAME;
        public static final String MIMETYPE_NAME = AUTHORITY + ".provider";

        // feild info
        public static final String COMMENTS = "comments";
        public static final String RESULT_ID = "result_id";
        public static final String REG_NO = "regNo";
        public static final String SUBJECT_ID = "subject_id";
        public static final String MARKS = "marks";


        // content uri pattern code
        public static final int CONTENT_URI_PATTERN_MANY = 9;
        public static final int CONTENT_URI_PATTERN_ONE = 10;

        // Refer to activity.
        public static final Uri contentUri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_CONTENT)
                .authority(AUTHORITY)
                .appendPath(CONTENT_URI_PATH)
                .build();
    }

    public static class SubjectContract implements BaseColumns
    {
        public static final String TABLE_NAME = "subject";

        public static final String CONTENT_URI_PATH = TABLE_NAME;

        public static final String MIMETYPE_TYPE = TABLE_NAME;
        public static final String MIMETYPE_NAME = AUTHORITY + ".provider";

        // feild info
        public static final String SUBJECT_ID = "subject_id";
        public static final String NAME = "name";
        public static final String TEACHER_ID = "teacher_id";


        // content uri pattern code
        public static final int CONTENT_URI_PATTERN_MANY = 11;
        public static final int CONTENT_URI_PATTERN_ONE = 12;

        // Refer to activity.
        public static final Uri contentUri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_CONTENT)
                .authority(AUTHORITY)
                .appendPath(CONTENT_URI_PATH)
                .build();
    }
    public static class StreamContract implements BaseColumns{
        public static final String TABLE_NAME = "stream";

        public static final String CONTENT_URI_PATH = TABLE_NAME;

        public static final String MIMETYPE_TYPE = TABLE_NAME;
        public static final String MIMETYPE_NAME = AUTHORITY + ".provider";

        // feild info
        public static final String STREAM_ID = "stream_id";
        public static final String LETTER = "letter";


        // content uri pattern code
        public static final int CONTENT_URI_PATTERN_MANY = 13;
        public static final int CONTENT_URI_PATTERN_ONE = 14;

        // Refer to activity.
        public static final Uri contentUri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_CONTENT)
                .authority(AUTHORITY)
                .appendPath(CONTENT_URI_PATH)
                .build();
    }
}

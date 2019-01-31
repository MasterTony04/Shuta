package com.is238.master.shuta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database {


    public class Teacher{
        private String first_name;
        private String last_name;
        private String password;

        public String getFirst_name(){
            return first_name;
        }

        public void setFirst_name(String first_name){
            this.first_name=first_name;
        }

        public String getLast_name(){
            return last_name;
        }

        public void setLast_name(String last_name){
            this.last_name=last_name;
        }

        public String getPassword(){
            return password;
        }

        public void setPassword(String password){
            this.password=password;
        }

        public class DatabaseHandler extends SQLiteOpenHelper{

            //----------- TABLE COLUMNS -----------//
            public static final String KEY_ID = "id"; // eash user has unique id
            public static final String KEY_FIRST_NAME = "first_name";
            public static final String KEY_MIDDLE_NAME = "middle_name";
            public static final String KEY_LAST_NAME = "last_name";
            public static final String KEY_PASSWORD = "password";
            //----------- TABLE COLUMNS -----------//




            private static final String DATABASE_NAME = "newUser";
            private static final String TABLE_NAME = "User";

            public DatabaseHandler(Context context){
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
            }

            private static final int DATABASE_VERSION = 1;

            @Override
            public void onCreate(SQLiteDatabase db) {

            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            }
        }
    }

    public class Admin{
        private String password;

        public String getPassword(){
            return password;
        }

        public void setPassword(String password){
            this.password=password;
        }

        public class DatabaseHandler extends SQLiteOpenHelper{


            //----------- TABLE COLUMNS -----------//
            public static final String KEY_USERNAME = "username"; // eash user has unique id
            public static final String KEY_PASSWORD = "password";

            //----------- TABLE COLUMNS -----------//


            private static final String DATABASE_NAME = "shuta_db";
            private static final String TABLE_NAME = "Admin";

            public DatabaseHandler(Context context){
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
            }

            private static final int DATABASE_VERSION = 1;

            @Override
            public void onCreate(SQLiteDatabase db) {

            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            }
        }


    }

    public class Class{
        private String class_name;
        private int teacher_id;

        public String getClass_name(){
            return class_name;
        }

        public void setClass_name(String class_name){
            this.class_name=class_name;
        }

        public int getTeacher_id(){
            return teacher_id;
        }

        public void setTeacher_id(int teacher_id){
            this.teacher_id=teacher_id;
        }

        public class DatabaseHandler extends Orm{

            //----------- TABLE COLUMNS -----------//
            public static final String KEY_ID = "id"; // eash user has unique id
            public static final String KEY_NAME = "name";
            public static final String KEY_PASSWORD = "password";
            public static final String KEY_BALANCE = "balance";
            public static final String KEY_AGE ="age";
            //----------- TABLE COLUMNS -----------//


            private static final String DATABASE_NAME = "newUser";
            private static final String TABLE_NAME = "User";

            public DatabaseHandler(Context context){
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
            }

            private static final int DATABASE_VERSION = 1;

            @Override
            public void onCreate(SQLiteDatabase db) {

            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            }
        }



    }

    public class Student{
        private String First_name;
        private String last_name;
        private String password;
        private int class_id;

        public String getFirst_name(){
            return First_name;
        }

        public void setFirst_name(String First_name){
            this.First_name=First_name;
        }

        public String getLast_name(){
            return last_name;
        }

        public void setLast_name(String last_name){
            this.last_name=last_name;
        }

        public String getPassword(){
            return password;
        }

        public void setPassword(String password){
            this.password=password;
        }

        public int getClass_id(){
            return class_id;
        }

        public void setClass_id(int class_id){
            this.class_id=class_id;
        }
    }

    public class Subject{
        private String name;
        private int teacher_id;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name=name;
        }

        public int getTeacher_id(){
            return teacher_id;
        }

        public void setTeacher_id(int teacher_id){
            this.teacher_id=teacher_id;
        }
    }

    public class Results{
        private String comments;
        private int result_id;
        private String regNo;
        private int subject_id;

        public String getComments(){
            return comments;
        }

        public void setComments(String comments){
            this.comments=comments;
        }

        public int getResult_id(){
            return result_id;
        }

        public void setResult_id(int result_id){
            this.result_id=result_id;
        }

        public String getRegno(){
            return regNo;
        }

        public void setRegno(String regNo){
            this.regNo=regNo;
        }

        public int getSubject_id(){
            return subject_id;
        }

        public void setSubject_id(int subject_id){
            this.subject_id=subject_id;
        }
    }



}


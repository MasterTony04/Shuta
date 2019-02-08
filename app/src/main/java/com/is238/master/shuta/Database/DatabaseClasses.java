package com.is238.master.shuta.Database;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.tojc.ormlite.android.annotation.AdditionalAnnotation;


public class DatabaseClasses {
    @AdditionalAnnotation.DefaultContentUri(authority = Contract.AUTHORITY, path = Contract.TeacherContract.CONTENT_URI_PATH)
    @AdditionalAnnotation.DefaultContentMimeTypeVnd(name = Contract.TeacherContract.MIMETYPE_NAME, type = Contract.TeacherContract.MIMETYPE_TYPE)
    @DatabaseTable(tableName = Contract.TeacherContract.TABLE_NAME)
    public static class Teacher{

        @DatabaseField(columnName = Contract.TeacherContract._ID, generatedId = true)
        private int id;
        @DatabaseField
        private String first_name;
        @DatabaseField
        private String last_name;
        @DatabaseField
        private String password;
        @DatabaseField
        private String phone_number;
        @DatabaseField
        private char gender;
        @DatabaseField
        private String regNo;

        public char getGender() {
            return gender;
        }

        public void setGender(char gender) {
            this.gender = gender;
        }

        public String getRegNo() {
            return regNo;
        }

        public void setRegNo(String regNo) {
            this.regNo = regNo;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        Teacher(){

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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

        public Teacher(String first_name, String last_name, String password, String phone_number, String regNo, char gender){
            this.first_name = first_name;
            this.last_name = last_name;
            this.password = password;
            this.phone_number = phone_number;
            this.gender = gender;
            this.regNo = regNo;
        }


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(", ").append("first_name=").append(first_name);
            stringBuilder.append(", ").append("last_name=").append(last_name);
            stringBuilder.append(", ").append("password=").append(password);
            stringBuilder.append(", ").append("phone_number=").append(phone_number);
            stringBuilder.append(", ").append("gender=").append(gender);
            stringBuilder.append(", ").append("regNo=").append(regNo);


            return stringBuilder.toString();
        }
    }
    @AdditionalAnnotation.DefaultContentUri(authority = Contract.AUTHORITY, path = Contract.AdminContract.CONTENT_URI_PATH)
    @AdditionalAnnotation.DefaultContentMimeTypeVnd(name = Contract.AdminContract.MIMETYPE_NAME, type = Contract.AdminContract.MIMETYPE_TYPE)
    @DatabaseTable(tableName = Contract.AdminContract.TABLE_NAME)
    public static class Admin{
        @DatabaseField(id = true, columnName = BaseColumns._ID)
        private String username;
        @DatabaseField
        private String password;

        Admin(){

        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Admin(String username, String password){
            this.username = username;
            this.password = password;
        }


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("username=").append(username);
            stringBuilder.append(",").append("password").append(password);
            return stringBuilder.toString();
        }
    }
    @AdditionalAnnotation.DefaultContentUri(authority = Contract.AUTHORITY, path = Contract.ClassContract.CONTENT_URI_PATH)
    @AdditionalAnnotation.DefaultContentMimeTypeVnd(name = Contract.ClassContract.MIMETYPE_NAME, type = Contract.ClassContract.MIMETYPE_TYPE)
    @DatabaseTable(tableName =Contract.ClassContract.TABLE_NAME)
    public static class Class{
        @DatabaseField(columnName = BaseColumns._ID, generatedId = true)
        private int class_id;
        @DatabaseField
        private String class_name;
        @DatabaseField
        private int teacher_id;
        @DatabaseField
        private int stream_id;

        Class(){

        }

        public int getStream_id() {
            return stream_id;
        }

        public void setStream_id(int stream_id) {
            this.stream_id = stream_id;
        }

        public Class(String class_name, int teacher_id, int stream_id){
            this.class_name = class_name;
            this.teacher_id = teacher_id;
            this.stream_id = stream_id;
        }

        public int getClass_id() {
            return class_id;
        }

        public void setClass_id(int class_id) {
            this.class_id = class_id;
        }

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


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("class_id=").append(class_id);
            stringBuilder.append(",").append("class_name=").append(class_name);
            stringBuilder.append(",").append("teacher_id=").append(teacher_id);
            return stringBuilder.toString();
        }
    }

    @AdditionalAnnotation.DefaultContentUri(authority = Contract.AUTHORITY, path = Contract.StudentContract.CONTENT_URI_PATH)
    @AdditionalAnnotation.DefaultContentMimeTypeVnd(name = Contract.StudentContract.MIMETYPE_NAME, type = Contract.StudentContract.MIMETYPE_TYPE)
    @DatabaseTable(tableName = Contract.StudentContract.TABLE_NAME)
    public static class Student{
        @DatabaseField(generatedId = true, columnName = BaseColumns._ID)
        private int student_id;
        @DatabaseField
        private String first_name;
        @DatabaseField
        private String last_name;
        @DatabaseField
        private String password;
        @DatabaseField
        private int class_id;
        @DatabaseField
        private char gender;
        @DatabaseField
        private String residence;
        @DatabaseField
        private String phone_number;
        @DatabaseField
        private String regNo;

        public char getGender() {
            return gender;
        }

        public void setGender(char gender) {
            this.gender = gender;
        }

        public String getResidence() {
            return residence;
        }

        public void setResidence(String residence) {
            this.residence = residence;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public String getRegNo() {
            return regNo;
        }

        public void setRegNo(String regNo) {
            this.regNo = regNo;
        }

        Student(){

        }


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("student_id=").append(student_id);
            stringBuilder.append(",").append("first_name=").append(first_name);
            stringBuilder.append(",").append("last_name=").append(last_name);
            stringBuilder.append(",").append("password=").append(password);
            stringBuilder.append(",").append("class_id=").append(class_id);

            return stringBuilder.toString();
        }

        public Student(String first_name, String last_name, String password, int class_id, char gender, String phone_number, String residence, String regNo){
            setGender(gender);
            setPhone_number(phone_number);
            setRegNo(regNo);
            setResidence(residence);
            setFirst_name(first_name);
            setLast_name(last_name);
            setPassword(password);
            setClass_id(class_id);
        }

        public int getStudent_id() {
            return student_id;
        }

        public void setStudent_id(int student_id) {
            this.student_id = student_id;
        }

        public String getFirst_name(){
            return first_name;
        }

        public void setFirst_name(String First_name){
            this.first_name =First_name;
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
    @AdditionalAnnotation.DefaultContentUri(authority = Contract.AUTHORITY, path = Contract.SubjectContract.CONTENT_URI_PATH)
    @AdditionalAnnotation.DefaultContentMimeTypeVnd(name = Contract.SubjectContract.MIMETYPE_NAME, type = Contract.SubjectContract.MIMETYPE_TYPE)
    @DatabaseTable(tableName = Contract.SubjectContract.TABLE_NAME)
    public static class Subject{
        @DatabaseField(id = true, columnName = BaseColumns._ID)
        private int subject_id;
        @DatabaseField
        private String name;
        @DatabaseField
        private int teacher_id;

        Subject(){

        }
        public Subject(int subject_id, String name, int teacher_id){
            this.name = name;
            this.teacher_id = teacher_id;
            this.subject_id = subject_id;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("subject_id=").append(subject_id);
            stringBuilder.append(",").append("name=").append(name);
            stringBuilder.append(",").append("teacher_id").append(teacher_id);
            return stringBuilder.toString();
        }

        public int getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(int subject_id) {
            this.subject_id = subject_id;
        }

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
    @AdditionalAnnotation.DefaultContentUri(authority = Contract.AUTHORITY, path = Contract.ResultsContract.CONTENT_URI_PATH)
    @AdditionalAnnotation.DefaultContentMimeTypeVnd(name = Contract.ResultsContract.MIMETYPE_NAME, type = Contract.ResultsContract.MIMETYPE_TYPE)
    @DatabaseTable(tableName = Contract.ResultsContract.TABLE_NAME)
    public static class Results{
        @DatabaseField
        private String comments;
        @DatabaseField(id = true, columnName = BaseColumns._ID)
        private int result_id;
        @DatabaseField
        private String regNo;
        @DatabaseField
        private int subject_id;
        @DatabaseField
        private int marks;

        Results(){

        }

        public String getRegNo() {
            return regNo;
        }

        public void setRegNo(String regNo) {
            this.regNo = regNo;
        }

        public int getMarks() {
            return marks;
        }

        public void setMarks(int marks) {
            this.marks = marks;
        }

        public Results(int result_id, String regNo, int subject_id, int marks, String comments){
            setRegno(regNo);
            setResult_id(result_id);
            setSubject_id(subject_id);
            setComments(comments);
            setMarks(marks);
        }



        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("result_id=").append(result_id);
            stringBuilder.append(",").append("regNo=").append(regNo);
            stringBuilder.append(",").append("subject_id=").append(subject_id);
            stringBuilder.append(",").append("marks=").append(marks);
            stringBuilder.append(",").append("comments=").append(comments);

            return stringBuilder.toString();
        }

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

    @AdditionalAnnotation.DefaultContentUri(authority = Contract.AUTHORITY, path = Contract.ResultsContract.CONTENT_URI_PATH)
    @AdditionalAnnotation.DefaultContentMimeTypeVnd(name = Contract.ResultsContract.MIMETYPE_NAME, type = Contract.ResultsContract.MIMETYPE_TYPE)
    @DatabaseTable(tableName = Contract.StreamContract.TABLE_NAME)
    public static class Stream{
        @DatabaseField(id=true, columnName = BaseColumns._ID)
        private static int stream_id;
        @DatabaseField
        private static char letter;

        public static int getStream_id() {
            return stream_id;
        }

        public static void setStream_id(int stream_id) {
            Stream.stream_id = stream_id;
        }

        public static char getLetter() {
            return letter;
        }

        public static void setLetter(char letter) {
            Stream.letter = letter;
        }


        public Stream(int stream_id, char letter){
            setLetter(letter);
            setStream_id(stream_id);
        }
        public Stream(){

        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("stream_id=").append(stream_id);
            stringBuilder.append(",").append("letter=").append(letter);
            return stringBuilder.toString();
        }



    }

    public Admin adminCall(String username, String password){
        return new Admin(username, password);
    }
    public Admin adminCall(){
        return new Admin();
    }
    public Teacher teacherCall(String first_name,String last_name, String password, String phone_number, String regNo, char gender){
        return new Teacher(first_name,last_name, password, phone_number, regNo, gender);
    }
    public Teacher teacherCall(){
        return new Teacher();
    }
    public Class classCall(String class_name, int teacher_id, int stream_id){
        return new Class(class_name,teacher_id, stream_id);
    }
    public Class classCall(){
        return new Class();
    }
    public Stream streamCall(int stream_id, char letter){
        return new Stream(stream_id, letter);
    }
    public Stream streamCall(){
        return new Stream();
    }
    public Student studentCall(){
        return new Student();
    }
    public Student studentCall(String first_name, String last_name, String password, int class_id, char gender, String phone_number, String residence, String regNo){
        return new Student(first_name,last_name,password,class_id,gender,phone_number,residence,regNo);
    }


}
//0755515187


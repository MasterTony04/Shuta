package com.is238.master.shuta.Database;

import android.accounts.Account;

import com.tojc.ormlite.android.OrmLiteSimpleContentProvider;
import com.tojc.ormlite.android.framework.MatcherController;
import com.tojc.ormlite.android.framework.MimeTypeVnd.SubType;

public class ContentProviderDb extends OrmLiteSimpleContentProvider<DatabaseHelper> {

    @Override
    protected Class<DatabaseHelper> getHelperClass() {
        return DatabaseHelper.class;
    }

    @Override
    public boolean onCreate() {

        //How do I create a Matc
        setMatcherController(new MatcherController()//
                .add(DatabaseClasses.Admin.class)
                .add(SubType.DIRECTORY, "", Contract.AdminContract.CONTENT_URI_PATTERN_MANY)
                .add(SubType.ITEM, "#", Contract.AdminContract.CONTENT_URI_PATTERN_ONE)
                .add(DatabaseClasses.Teacher.class)
                .add(SubType.DIRECTORY, "", Contract.TeacherContract.CONTENT_URI_PATTERN_MANY)
                .add(SubType.ITEM, "#", Contract.TeacherContract.CONTENT_URI_PATTERN_ONE)
                .add(DatabaseClasses.Class.class)
                .add(SubType.DIRECTORY, "", Contract.ClassContract.CONTENT_URI_PATTERN_MANY)
                .add(SubType.ITEM, "#", Contract.ClassContract.CONTENT_URI_PATTERN_ONE)
                .add(DatabaseClasses.Student.class)
                .add(SubType.DIRECTORY, "", Contract.StudentContract.CONTENT_URI_PATTERN_MANY)
                .add(SubType.ITEM, "#", Contract.StudentContract.CONTENT_URI_PATTERN_ONE)
                .add(DatabaseClasses.Results.class)
                .add(SubType.DIRECTORY, "", Contract.ResultsContract.CONTENT_URI_PATTERN_MANY)
                .add(SubType.ITEM, "#", Contract.ResultsContract.CONTENT_URI_PATTERN_ONE)
                .add(DatabaseClasses.Subject.class)
                .add(SubType.DIRECTORY, "", Contract.SubjectContract.CONTENT_URI_PATTERN_MANY)
                .add(SubType.ITEM, "#", Contract.SubjectContract.CONTENT_URI_PATTERN_ONE)
                .add(DatabaseClasses.Stream.class)
                .add(SubType.DIRECTORY, "", Contract.StreamContract.CONTENT_URI_PATTERN_MANY)
                .add(SubType.ITEM, "#", Contract.StreamContract.CONTENT_URI_PATTERN_ONE)
        );
        return true;
    }


}

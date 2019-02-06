package com.is238.master.shuta.Database;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

public class DatabaseConfigUtil extends OrmLiteConfigUtil {
    private static final Class<?>[] classes = new Class[] {
            DatabaseClasses.Teacher.class,
            DatabaseClasses.Admin.class,
            DatabaseClasses.Class.class,
            DatabaseClasses.Subject.class,
            DatabaseClasses.Student.class,
            DatabaseClasses.Results.class

    };

    public static void main(String[] args) throws Exception {
        writeConfigFile("ormlite_config.txt", classes);
    }
}

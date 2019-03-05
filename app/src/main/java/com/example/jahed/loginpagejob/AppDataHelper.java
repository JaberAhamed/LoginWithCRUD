package com.example.jahed.loginpagejob;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jahed on 10/2/2018.
 */

public class AppDataHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME="AppDataDB";

    private static final int DATABASE_VERSION=1;







    public  static final String UserLOGINTable="userInfoTable";
    public static final String COLUMN_USEREMAIL_ID="id";
    public static final String COLUMN_USER_EMAIL="user_email";
    public static final String COLUMN_USER_PASSWORD="user_pass";


    public  static final String UsetTaskTable="userTaskTable";
    public static final String COLUMN_USERTASK_ID="id";
    public static final String COLUMN_USER_TASK="task";








    private String createUserLogInfo="create table "+UserLOGINTable+"("+COLUMN_USEREMAIL_ID+" integer primary key autoincrement,"+COLUMN_USER_EMAIL+" text,"+COLUMN_USER_PASSWORD+" text );";

    private String createUserTaskDb="create table "+UsetTaskTable+"("+COLUMN_USERTASK_ID+" integer primary key autoincrement,"+COLUMN_USER_TASK+" text );";


    public AppDataHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createUserLogInfo);
        db.execSQL(createUserTaskDb);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

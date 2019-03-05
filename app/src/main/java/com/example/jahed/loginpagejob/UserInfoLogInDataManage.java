package com.example.jahed.loginpagejob;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by jahed on 10/26/2018.
 */

public class UserInfoLogInDataManage {



    private Context context;

    private AppDataHelper appDataHelper;
    private SQLiteDatabase sqLiteDatabase;

    public UserInfoLogInDataManage(Context context) {
        this.context = context;
        appDataHelper=new AppDataHelper(context);
    }

    public long addUserLoginInfo(UserLoginfo userLoginfo){
        open();
        ContentValues contentValues=new ContentValues();
        contentValues.put(AppDataHelper.COLUMN_USER_EMAIL,userLoginfo.getUserEmail());
        contentValues.put(AppDataHelper.COLUMN_USER_PASSWORD,userLoginfo.getUserPassword());




        long insertedRow=sqLiteDatabase.insert(AppDataHelper.UserLOGINTable,null,contentValues);
        sqLiteDatabase.close();
        return insertedRow;
    }



    public ArrayList<UserLoginfo> getUserLogInfo(){
        ArrayList<UserLoginfo>userEmailInfos=new ArrayList<>();
        open();
        String selectQuery="select * from "+AppDataHelper.UserLOGINTable;
        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                UserLoginfo userLoginfo=new UserLoginfo();
                userLoginfo.setId(cursor.getInt(cursor.getColumnIndex(AppDataHelper.COLUMN_USEREMAIL_ID)));
                userLoginfo.setUserEmail(cursor.getString(cursor.getColumnIndex(AppDataHelper.COLUMN_USER_EMAIL)));

                userLoginfo.setUserPassword(cursor.getString(cursor.getColumnIndex(AppDataHelper.COLUMN_USER_PASSWORD)));



                userEmailInfos.add(userLoginfo);
            }while(cursor.moveToNext());
        }
        return userEmailInfos;
    }

    private void open() {

        sqLiteDatabase=appDataHelper.getWritableDatabase();
    }
}

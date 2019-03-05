package com.example.jahed.loginpagejob;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UserTaskDataManager {


    private Context context;

    private AppDataHelper appDataHelper;
    private SQLiteDatabase sqLiteDatabase;

    public UserTaskDataManager(Context context) {
        this.context = context;
        appDataHelper=new AppDataHelper(context);
    }

    public long addUserTask(UserTask userTask){
        open();
        ContentValues contentValues=new ContentValues();
        contentValues.put(AppDataHelper.COLUMN_USER_TASK,userTask.getUsertask());





        long insertedRow=sqLiteDatabase.insert(AppDataHelper.UsetTaskTable,null,contentValues);
        sqLiteDatabase.close();
        return insertedRow;
    }


    public long updateTask(UserTask userTask){
        open();
        ContentValues contentValues=new ContentValues();
        contentValues.put(AppDataHelper.COLUMN_USER_TASK,userTask.getUsertask());


        long insertedRow=sqLiteDatabase.update(AppDataHelper.UsetTaskTable,contentValues,AppDataHelper.COLUMN_USERTASK_ID+" = "+userTask.getUserTaskId(),null);
        sqLiteDatabase.close();
        return insertedRow;

    }

    public long deleteTask(int id){
        open();
        long deleted=sqLiteDatabase.delete(AppDataHelper.UsetTaskTable,AppDataHelper.COLUMN_USERTASK_ID+" = "+id,null);
        sqLiteDatabase.close();
        return deleted;
    }


    public ArrayList<UserTask> getUserTask(){
        ArrayList<UserTask>userTasks=new ArrayList<>();
        open();
        String selectQuery="select * from "+AppDataHelper.UsetTaskTable;
        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                UserTask task=new UserTask();
                task.setUserTaskId(cursor.getInt(cursor.getColumnIndex(AppDataHelper.COLUMN_USERTASK_ID)));
                task.setUsertask(cursor.getString(cursor.getColumnIndex(AppDataHelper.COLUMN_USER_TASK)));






                userTasks.add(task);
            }while(cursor.moveToNext());
        }
        return userTasks;
    }

    private void open() {

        sqLiteDatabase=appDataHelper.getWritableDatabase();
    }
}

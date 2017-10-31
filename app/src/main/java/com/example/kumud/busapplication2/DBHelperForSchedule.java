package com.example.kumud.busapplication2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kumud on 10/29/17.
 */

public class DBHelperForSchedule extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ScheduleService.db";
    public DBHelperForSchedule(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addScheduleTableData(Schedule schedule){
        SQLiteDatabase db =  this.getWritableDatabase();

        //adding schedule in schedule table

        db.close(); // Closing database connection
    }




}

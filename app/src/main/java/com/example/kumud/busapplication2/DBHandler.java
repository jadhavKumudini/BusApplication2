package com.example.kumud.busapplication2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Kumud on 10/11/17.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "ShuttleService.db";
    private static final String TABLE_LOCATIONS = "locations";
    private static final String TABLE_SHUTTLE_SCHEDULE = "ShuttleSchedule";

    public static final String COLUMN_LOCATIONNAME = "locationName";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGITUDE = "longitude";


    public static final String COLUMN_PICKLOCATION = "pickup";
    public static final String COLUMN_TOUR= "tour";
    public static final String COLUMN_SCHEDULE_LIST = "ScheduleList";

    // Locations table create statement
    private static final String CREATE_TABLE_LOCATIONS = "CREATE TABLE "
            + TABLE_LOCATIONS + "(" + COLUMN_LOCATIONNAME + " TEXT PRIMARY KEY," + COLUMN_LATITUDE
            + " TEXT," + COLUMN_LONGITUDE + " TEXT "  + ")";

    private static final String CREATE_TABLE_SCHEDULE = "CREATE TABLE "
            + TABLE_SHUTTLE_SCHEDULE + "(" + COLUMN_PICKLOCATION + " TEXT," + COLUMN_TOUR
            + " TEXT," + COLUMN_SCHEDULE_LIST + " TEXT "  + ")";


    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public DBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //createing tables

        db.execSQL(CREATE_TABLE_LOCATIONS);
        db.execSQL(CREATE_TABLE_SCHEDULE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
       // db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_LOCATIONS);
        // create new tables
       // onCreate(db);

        db.execSQL(CREATE_TABLE_SCHEDULE);
    }

   public void addLocationTableData(Location location){
       SQLiteDatabase db =  this.getWritableDatabase();
    //adding locations in location table
       ContentValues valuesLocation = new ContentValues();
       valuesLocation.put(COLUMN_LOCATIONNAME, location.getLocationName());
       valuesLocation.put(COLUMN_LATITUDE, location.getLocationLatitude());
       valuesLocation.put(COLUMN_LONGITUDE, location.getLocationLongitude());

       db.insert(TABLE_LOCATIONS, null, valuesLocation);

       db.close(); // Closing database connection
   }

    public void addScheduleTableData(Schedule schedule){
        SQLiteDatabase db =  this.getWritableDatabase();
        //adding schedule in schedule table
        ContentValues valuesSchedule = new ContentValues();
        valuesSchedule.put(COLUMN_PICKLOCATION, schedule.getPickupLocation());
        valuesSchedule.put(COLUMN_TOUR, schedule.getTour());
        valuesSchedule.put(COLUMN_SCHEDULE_LIST, schedule.getListshifts());

        db.insert(TABLE_SHUTTLE_SCHEDULE, null, valuesSchedule);

        db.close(); // Closing database connection
    }

    public ArrayList<Location> getAllLocations() {
        ArrayList<Location> locationArrayList = new ArrayList<Location>();

        String selectQuery = "SELECT  * FROM " + TABLE_LOCATIONS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Location location = new Location();
                location.setLocationName(c.getString(0));
                location.setLocationLatitude(c.getString(1));
                location.setLocationLongitude(c.getString(2));

                // adding to location list
                locationArrayList.add(location);
            } while (c.moveToNext());
        }

        c.close();
        db.close(); // Closing database connection

        return locationArrayList;
    }

    public ArrayList<String> getAllLocationsNames() {
        ArrayList<String> locationNames = new ArrayList<String>();

        String selectQuery = "SELECT " + COLUMN_LOCATIONNAME +" FROM " + TABLE_LOCATIONS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                String lc = "";
                 lc = c.getString(0);


                // adding to location list
                locationNames.add(lc);
            } while (c.moveToNext());
        }

        c.close();
        db.close(); // Closing database connection

        return locationNames;
    }

    public String getScheduleListForPickup(String pickupLocation, String tour ) {

        SQLiteDatabase db= this.getReadableDatabase();
        final String columNames[] = {COLUMN_PICKLOCATION, COLUMN_TOUR, COLUMN_SCHEDULE_LIST};
        String whereClause = COLUMN_PICKLOCATION + " = ? AND " + COLUMN_TOUR + " = ? ";
        String[] whereArgs = {pickupLocation, tour};
        Schedule sch = new Schedule();
        String str = "";
        Cursor cursor = db.query(TABLE_SHUTTLE_SCHEDULE, columNames, whereClause, whereArgs, null, null, null);
        while (cursor.moveToNext()) {
            str = cursor.getString(0);

            str = cursor.getString(2);
           /* sch.setPickupLocation(cursor.getString(cursor.getColumnIndex(COLUMN_PICKLOCATION)));
            sch.setPickupLocation(cursor.getString(cursor.getColumnIndex(COLUMN_TOUR)));
            sch.setPickupLocation(cursor.getString(cursor.getColumnIndex(COLUMN_SCHEDULE_LIST)));*/

        }

        cursor.close();
        db.close(); // Closing database connection

        return str;
    }




}

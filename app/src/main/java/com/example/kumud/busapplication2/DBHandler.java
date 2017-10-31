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

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ShuttleService.db";
    private static final String TABLE_LOCATIONS = "locations";

    public static final String COLUMN_LOCATIONNAME = "locationName";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGITUDE = "longitude";

   // private static final String TABLE_SCHEDULE = "Schedule";
     private static final String TABLE_SCHEDULE = "BusSchedule";
    private static final String TABLE_BUS_SCHEDULE = "BusSchedule";
    public static final String COLUMN_PICKUPLOCATION = "pickupLocation";
    public static final String COLUMN_TOURTO = "tourTo";
    public static final String COLUMN_TOTALSHIFTS = "totalShifts";
    public static final String COLUMN_SHIFTLIST = "shiftsList";


    // Locations table create statement
    private static final String CREATE_TABLE_LOCATIONS = "CREATE TABLE "
            + TABLE_LOCATIONS + "(" + COLUMN_LOCATIONNAME + " TEXT PRIMARY KEY," + COLUMN_LATITUDE
            + " TEXT," + COLUMN_LONGITUDE + " TEXT "  + ")";

    // Schedule table create statement
    private static final String CREATE_TABLE_SCHEDULE = "CREATE TABLE " + TABLE_SCHEDULE
            + "(" + COLUMN_PICKUPLOCATION + " TEXT," + COLUMN_TOURTO + " TEXT,"
            + COLUMN_TOTALSHIFTS + " TEXT," + COLUMN_SHIFTLIST + " TEXT" + ")";



    // Schedule table create statement
    private static final String CREATE_TABLE_BUS_SCHEDULE = "CREATE TABLE " + TABLE_BUS_SCHEDULE
            + "(" + COLUMN_PICKUPLOCATION + " TEXT," + COLUMN_TOURTO + " TEXT,"
            + COLUMN_TOTALSHIFTS + " TEXT," + COLUMN_SHIFTLIST + " TEXT" + ")";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    public DBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //createing tables
        db.execSQL(CREATE_TABLE_BUS_SCHEDULE);
        db.execSQL(CREATE_TABLE_LOCATIONS);
       // db.execSQL(CREATE_TABLE_SCHEDULE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables

        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_BUS_SCHEDULE);

        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_LOCATIONS);
       // db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_SCHEDULE);

        // create new tables
        onCreate(db);
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
        valuesSchedule.put(COLUMN_PICKUPLOCATION, schedule.getPickupLocation());
        valuesSchedule.put(COLUMN_TOURTO, schedule.getTourTo());
        valuesSchedule.put(COLUMN_TOTALSHIFTS, schedule.getTotalShifts());
        valuesSchedule.put(COLUMN_SHIFTLIST, schedule.getListshifts());

        db.insert(TABLE_BUS_SCHEDULE, null, valuesSchedule);

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
        String str = "";
       // String query = "SELECT * FROM " +  TABLE_SCHEDULE  +  "WHERE " +  COLUMN_PICKUPLOCATION +  "='"+ pickupLocation + "' "  +   "AND " +  COLUMN_TOURTO + "='" + tour + "' ";
        String query = "SELECT"+ COLUMN_SHIFTLIST + "FROM" +  TABLE_BUS_SCHEDULE + "WHERE" + COLUMN_PICKUPLOCATION + "='"+ pickupLocation + "' "  +   "AND " +  COLUMN_TOURTO + "='" + tour + "' ";
        //+  "='"+ pickupLocation + "' "  +   "AND " +  COLUMN_TOURTO + "='" + tour + "' ";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);

        if(c.moveToFirst()){
            do{
               str = c.getString(c.getColumnIndex(COLUMN_SHIFTLIST));

            }while (c.moveToFirst());
        }

        c.close();
        db.close();
        return str;
    }




}

package com.example.kumud.busapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kumud on 10/13/17.
 */

public class ScheduleActivity extends AppCompatActivity {

    TextView text;
    DBHandler db;
    List<String> timingsList;
    String listStr;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String pickupLocation;
    String tour;
    Intent intent;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_recyclerview);

        Schedule schedule;
        intent = getIntent();
        tour = intent.getStringExtra("tour");
        pickupLocation = intent.getStringExtra("pickupLocation");

        db = new DBHandler(this);
        timingsList = new ArrayList<String>() ;


        schedule = db.getScheduleForPickup(pickupLocation,tour);

        listStr =schedule.getListshifts();
       // listStr = db.getScheduleListForPickup(pickupLocation, tour);


        timingsList = generateListFromString(listStr);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new TimingAdapter(this,timingsList);
        recyclerView.setAdapter(adapter);


    }

      public List<String> generateListFromString(String listStr){
          List<String> list = new ArrayList<String>(Arrays.asList(listStr.split(",")));
          System.out.println(list);

          return list;
      }

}

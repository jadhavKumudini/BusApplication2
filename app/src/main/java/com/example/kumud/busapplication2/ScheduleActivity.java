package com.example.kumud.busapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
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
    List<String> listStr;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String pickupLocation;
    String tour;
    TextView textNote;
    TextView serviceText;
    Intent intent;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_recyclerview);
        textNote = (TextView) findViewById(R.id.textViewNote);
        serviceText = (TextView)findViewById(R.id.textViewNameService);

        Schedule schedule = new Schedule();
        intent = getIntent();
        tour = intent.getStringExtra("tour");
        pickupLocation = intent.getStringExtra("pickupLocation");

        db = new DBHandler(this);
        String serviceTxt ="";

        if(tour.contains("From")) {
           serviceTxt = tour + " To " + pickupLocation;
        }else{
            serviceTxt = pickupLocation + " " + tour;
        }
        serviceText.setText(serviceTxt);
        String str = db.getScheduleListForPickup(pickupLocation,tour);
        listStr = generateListFromString(str);

        if(str != "") {
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);


            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            adapter = new TimingAdapter(this, listStr,pickupLocation,tour);
            recyclerView.setAdapter(adapter);
            textNote.setText("");
        }
        else{
            textNote.setText("No Data Found");
        }

    }

      public List<String> generateListFromString(String listStr){
          List<String> list = new ArrayList<String>(Arrays.asList(listStr.split(",")));
          System.out.println(list);

          return list;
      }

}

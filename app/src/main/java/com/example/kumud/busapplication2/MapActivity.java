package com.example.kumud.busapplication2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Kumud on 10/31/17.
 */

public class MapActivity extends AppCompatActivity {

    String pickupLocation;
    String tour;

    List<String> stringList1 = getListLocationDetails( pickupLocation);
    List<String> stringList2 = getListLocationDetails("Bayou");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);

    }


    public List <String> getListLocationDetails(String location){
       List<String> str = new ArrayList<String>();


        switch(location){
            case "Bayou Front Enterance":
                str.add(0,"29.582626");
                str.add(1,"-95.099264");
                break;

            case "Bayou Student enterance":
                str.add(0,"29.583410");
                str.add(1,"-95.098165");
                break;

            case "Ivy":
                str.add(0,"29.574454");
                str.add(1,"-95.105283");
                break;

            case "Delta":
                str.add(0,"29.577830");
                str.add(1,"-95.104155");
                break;

            case "Lakeshore":
                str.add(0,"29.571553");
                str.add(1,"-95.111778");
                break;

            case "Cove":
                str.add(0,"29.567877");
                str.add(1,"-95.111382");
                break;

            case "Wolfcreek":
                str.add(0,"29.571553");
                str.add(1,"-95.111778");
                break;

            case "University Green":
                str.add(0,"29.567877");
                str.add(1,"-95.111382");
                break;

            case "UFA":
                str.add(0,"29.576959");
                str.add(1,"-95.106414");
                break;

            case "Bayou":
                str.add(0,"29.582626");
                str.add(1,"-95.099264");
                break;

        }
        return null;
    }




}

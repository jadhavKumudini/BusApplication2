package com.example.kumud.busapplication2;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String pickupLocation;
    String tour;
    Intent intent;


    List<String> stringList1;
    List<String> stringList2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        int check = 0;

        intent = getIntent();
        tour = intent.getStringExtra("tour");
        pickupLocation = intent.getStringExtra("pickupLocation");

        stringList1 = getListLocationDetails( pickupLocation);
        stringList2 = getListLocationDetails("Bayou");
        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);

        LatLng place1 = new LatLng( Double.parseDouble(stringList1.get(0)),Double.parseDouble(stringList1.get(1)));
        LatLng place2 = new LatLng(Double.parseDouble(stringList2.get(0)),Double.parseDouble(stringList2.get(1)));

        if(tour.contains("To")){
            check =1;
            mMap.addMarker(new MarkerOptions().position(place2).title(tour));

        }else{
            check =2;
            mMap.addMarker(new MarkerOptions().position(place2).title(tour));

        }

        mMap.addMarker(new MarkerOptions().position(place1).title(pickupLocation));


        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));


       // mMap.moveCamera(CameraUpdateFactory.newLatLng(place1));



        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place1,14));
        // Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14), 30000, null);
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
                str.add(0,"29.573479");
                str.add(1,"-95.112844");
                break;
            case "University Green":
                str.add(0,"29.566211");
                str.add(1,"-95.112075");
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
        return str;
    }







}

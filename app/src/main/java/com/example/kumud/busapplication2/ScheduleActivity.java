package com.example.kumud.busapplication2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Kumud on 10/13/17.
 */

public class ScheduleActivity extends AppCompatActivity {

    TextView text;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        text = (TextView) findViewById(R.id.textViewSc);

        text.setText("welcome");


    }



}

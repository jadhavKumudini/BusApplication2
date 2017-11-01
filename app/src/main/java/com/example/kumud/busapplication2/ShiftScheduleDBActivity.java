package com.example.kumud.busapplication2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Kumud on 10/11/17.
 */

public class ShiftScheduleDBActivity extends AppCompatActivity {

    EditText edPickup, edTour, edTotal, edShifts;
    Button btnsave, btnCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shiftscheduledb);

        edTour = (EditText) findViewById(R.id.editTextT);
        edPickup = (EditText) findViewById(R.id.editTextPK);
        edShifts = (EditText) findViewById(R.id.editTextSL);

        btnsave = (Button) findViewById(R.id.buttonSave);
        btnCancel = (Button) findViewById(R.id.buttonCancel);



        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pickup = edPickup.getText().toString();
                String tour = edTour.getText().toString();
                String shifts = edShifts.getText().toString();

                DBHandler db = new DBHandler(getApplicationContext());

                db.addScheduleTableData(new Schedule(pickup,tour,shifts));

                Toast.makeText(ShiftScheduleDBActivity.this, "Working", Toast.LENGTH_SHORT).show();

                edPickup.setText("");
                edTour.setText("");
                edShifts.setText("");

                Toast.makeText(ShiftScheduleDBActivity.this, "Successfully stored!", Toast.LENGTH_SHORT).show();

            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}

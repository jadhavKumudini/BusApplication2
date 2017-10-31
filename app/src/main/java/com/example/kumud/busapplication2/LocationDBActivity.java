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

public class LocationDBActivity extends AppCompatActivity {


    private Button buttonSave, buttonCancel;
    private EditText editTextLocation, editTextLatitude, editTextLongitude;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locationdb);

        editTextLocation = (EditText) findViewById(R.id.editTextLC);
        editTextLatitude = (EditText) findViewById(R.id.editTextLT);
        editTextLongitude = (EditText) findViewById(R.id.editTextLN);

        buttonSave = (Button) findViewById(R.id.buttonS);

        buttonCancel = (Button) findViewById(R.id.buttonC);



        buttonSave.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String lname = editTextLocation.getText().toString();
                String lt = editTextLatitude.getText().toString();
                String ln = editTextLongitude.getText().toString();
                Location loc = new Location(lname,lt,ln);


                DBHandler db = new DBHandler(getApplicationContext());

                db.addLocationTableData(loc);


                editTextLocation.setText("");
                editTextLatitude.setText("");
                editTextLongitude.setText("");
                Toast.makeText(LocationDBActivity.this, "Stored Successfuly!", Toast.LENGTH_SHORT).show();

            }
        });



        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



}

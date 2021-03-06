package com.example.kumud.busapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public Spinner spinner;
    public Button btn;
    public RadioButton rb;
    public RadioGroup radioButtonGroup;

    public String selectedtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinnerLC);
        btn = (Button) findViewById(R.id.buttonViewSchedule);

        spinner.setOnItemSelectedListener(this);
        loadSpinnerData();

        radioButtonGroup = (RadioGroup) findViewById(R.id.radioGroupTour);






        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
                View radioButton = radioButtonGroup.findViewById(radioButtonID);
                int idx = radioButtonGroup.indexOfChild(radioButton);

                rb = (RadioButton)  radioButtonGroup.getChildAt(idx);
                selectedtext = rb.getText().toString();

               Intent  intent = new Intent(v.getContext(), ScheduleActivity.class);
                intent.putExtra("pickupLocation",spinner.getSelectedItem().toString());
                intent.putExtra("tour",selectedtext);
                startActivity(intent);
            }
        });

    }


    public void loadSpinnerData(){

        // database handler
        DBHandler db = new DBHandler(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.getAllLocationsNames();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

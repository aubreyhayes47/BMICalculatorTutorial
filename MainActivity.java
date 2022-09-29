package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText heightEt, weightEt;
    RadioGroup genderRg;
    Button btn;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set all of the views as they appear on the layout
        heightEt = findViewById(R.id.height_et);
        weightEt = findViewById(R.id.weight_et);
        btn = findViewById(R.id.bmi_btn);
        genderRg = findViewById(R.id.gender_rg);

        //Get the ID of the radio button which has been selected
        genderRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.male_rb){
                    gender = "Male";
                }
                else{
                    gender = "Female";
                }

            }
        });

        //Create an on click listener for the button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get info from user
                String heightVal = heightEt.getText().toString().trim();
                String weightVal = weightEt.getText().toString().trim();

                //Calculate bmi with floats of variables entered
                float height = Float.parseFloat(heightVal);
                float weight = Float.parseFloat(weightVal);
                float bmi = calBMI(height, weight);

                //Pass the info into the result activity using an intent
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("bmi", bmi);
                intent.putExtra("gender", gender);
                startActivity(intent);

            }
        });
    }

    public float calBMI(float h, float w){
        //BMI is weight in kg / height in meters squared or kg/m^2
        float bmi = 0;
        float h_m = h / 100;
        bmi = w/(h_m*h_m);
        return bmi;
    }

}
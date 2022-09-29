package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    String gender;
    float bmi;

    TextView messageTv, bmiTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Get gender and bmi from previous activity using the name and a default value if not found
        bmi = getIntent().getFloatExtra("bmi", -1);
        gender = getIntent().getStringExtra("gender");

        //Get text and image view components
        messageTv = findViewById(R.id.message_tv);
        bmiTv = findViewById(R.id.bmi_tv);

        //Get and set the message text
        String msg ;

        if(bmi < 18){
            msg = "You are Underweight.";
        }
        else if(bmi < 24){
            msg = "You are a Healthy Weight.";
        }
        else if(bmi < 30){
            msg = "You are Overweight.";
        }else if(bmi < 35){
            msg = "You are Class I Obese.";
        }else if (bmi < 40){
            msg = "You are Class II Obese.";
        }else{
            msg = "You are Class III Obese.";
        }

        messageTv.setText(msg);
        bmiTv.setText(String.format("%.2f", bmi));

    }
}
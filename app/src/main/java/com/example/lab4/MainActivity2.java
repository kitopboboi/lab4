package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity {
    private EditText set_drink;
    private RadioGroup rg1, rg2;
    private Button btn_send;
    private String sugar ="No Sugar";
    private String ice_opt = "No Ice";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rg1= findViewById(R.id.radioGroup);
        rg1.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.radioButton1) {
                sugar = "No Sugar";
            } else if (i == R.id.radioButton2) {
                sugar = "Less Sugar";
            } else if(i == R.id.radioButton3) {
                sugar = "Half Sugar";
            } else if (i == R.id.radioButton4) {
                sugar = "Full Sugar";
            }

        });

        rg2= findViewById(R.id.radioGroup2);
        rg2.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.radioButton5) {
                ice_opt = "No Ice";
            } else if (i == R.id.radioButton6) {
                ice_opt = "30% Ice";
            } else if (i == R.id.radioButton7) {
                ice_opt = "Less Ice";
            } else if (i == R.id.radioButton8) {
                ice_opt = "Normal Ice";
            }
        });

        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(view -> {
            set_drink = findViewById((R.id.ed_drink);
            String drink = set_drink.getText().toString();
            Intent i = new Intent();
            Bundle b = new Bundle();
            b.putString("drink", drink);
            b.putString("sugar", sugar);
            b.putString("ice", ice_opt);
            i.putExtras(b);
            setResult(Activity.RESULT_OK, i);

        });
    }
}
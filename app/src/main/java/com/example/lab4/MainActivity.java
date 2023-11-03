package com.example.lab4;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_meal;
    private Button btn_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_meal = findViewById(R.id.tv_meal);
        btn_select = findViewById(R.id.btn_choice);
        btn_select.setOnClickListener(view -> {
            mStartForResult.launch(
              new Intent(this, MainActivity.class)

            );
        });
    }

    private final ActivityResultLauncher<Intent> mStarFoResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if(result.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = result.getData();

                    if(intent != null && getIntent().getExtras() != null) {
                        Bundle b = intent.getExtras();
                        String str1 = b.getString("Drink");
                        String str2 = b.getString("Sugar");
                        String str3 = b.getString("Ice");
                        tv_meal.setText(String.format("Drinks: %s\n\nSweetness: %s\n\nIce: %s", str1, str2, str3));
                        }
                    }
                });
            }
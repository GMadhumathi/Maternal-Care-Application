package com.example.mommygram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MomPageActivity extends AppCompatActivity {

    ImageView exercise,music,nutrient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mom_page);
        exercise=findViewById(R.id.mom_ex);
        nutrient=findViewById(R.id.mom_food);

        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MomPageActivity.this,ExerciseActivity.class));
            }
        });

        nutrient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MomPageActivity.this,NutrientActivity.class));
            }
        });

    }
}
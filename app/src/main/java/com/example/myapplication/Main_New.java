package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Main_New extends AppCompatActivity {
    ImageView ibtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__new);

        ibtn = findViewById(R.id.imageView);


        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("button clicked!");
                Intent activity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(activity);
                ibtn.setBackgroundColor(Color.BLUE);
            }
        });



    }
}
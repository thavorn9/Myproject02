package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    EditText Name,Score,Love;
    Button bt1,bt2,ex;
    myManager manager;
    View mView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText) findViewById(R.id.textUsername);
        Score = (EditText) findViewById(R.id.textPassword);
        Love = (EditText) findViewById(R.id.textLove);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        ex = (Button) findViewById(R.id.ex);

        manager = new myManager(this);
        mView = findViewById(R.id.view);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
            });
        bt2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewData();{

                            }
                        }
                    });
        ex.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("button clicked");
                Intent MainNew = new Intent(getApplicationContext(), com.example.myapplication.Main_New.class);
                startActivity(MainNew);
                ex.setBackgroundColor(Color.RED);
            }
        });


        mView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                System.out.println("touched");
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ex.setBackgroundColor(Color.MAGENTA);
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        ex.setBackgroundColor(Color.BLUE);
                        break;
                    }
                }
                return false;
            }
        });
      }

    public void viewData(){
        String data = manager.getData();
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
        }
    public void addUser() {
//get value from EditText
        String t1 = Name.getText().toString();
        String t2 = Score.getText().toString();
        String t3 = Love.getText().toString();
//check if empty?
        if (t1.isEmpty() || t2.isEmpty()) {
            Toast.makeText(this, "Enter Both Name and Score", Toast.LENGTH_LONG).show();
        } else {
//add data to database
            long id = manager.insert(t1,t2,t3);
            if (id <= 0) {
                Toast.makeText(this, "Insertion Unsuccessful", Toast.LENGTH_LONG).show();
                Name.setText("");
                Score.setText("");
                Love.setText("");

            } else {
                Toast.makeText(this, "Insertion Successful", Toast.LENGTH_LONG).show();
                Name.setText("");
                Score.setText("");
                Love.setText("");

            }
        }
    }
}
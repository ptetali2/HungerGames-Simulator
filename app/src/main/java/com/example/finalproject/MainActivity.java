package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Hunger Games Simulator");

        RelativeLayout main = findViewById(R.id.main);
        main.setBackgroundColor(Color.BLACK);
        Button start = findViewById(R.id.startGame);
        //ImageView
        ImageView titleImage = findViewById(R.id.titleImage);
        TextView text = findViewById(R.id.textView);
        text.setAlpha(1);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }
    public void openActivity() {
        Intent intent = new Intent(this,SetupActivity.class);
        startActivity(intent);
    }

}

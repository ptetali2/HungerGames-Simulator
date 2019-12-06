package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setTitle("Hunger Games Simulator");
        RelativeLayout game = findViewById(R.id.game);
        game.setBackgroundColor(Color.BLACK);
        generateDays();
    }
    private void generateDays() {
        Button cont = findViewById(R.id.cont);
        Button status = findViewById(R.id.status);
        cont.setOnClickListener(v -> {
            System.out.println("simulation");
        });
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStatusActivity();
            }
        });

    }
    public void openStatusActivity() {
        Intent intent = new Intent(this,StatusActivity.class);
        startActivity(intent);

    }
}

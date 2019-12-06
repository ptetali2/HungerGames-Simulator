package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SetupActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> defaultNames = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Set up stuff
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        setTitle("Hunger Games Simulator");
        RelativeLayout setup = findViewById(R.id.setup);
        setup.setBackgroundColor(Color.BLACK);
        //Add default names to ArrayList
        defaultNames.add("1");
        defaultNames.add("2");
        defaultNames.add("3");
        defaultNames.add("4");
        defaultNames.add("5");
        defaultNames.add("6");
        defaultNames.add("7");
        defaultNames.add("8");
        defaultNames.add("9");
        defaultNames.add("10");
        defaultNames.add("11");
        defaultNames.add("12");


        //Set up RecyclerView
        recyclerView = findViewById(R.id.nameSetup);
        recyclerView.setHasFixedSize(true);
        //LinearLayout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //Set up Adapter
        adapter = new SetupAdapter(defaultNames);
        recyclerView.setAdapter(adapter);

        //if continue button is clicked open GameActivity
        Button cont = findViewById(R.id.cont);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }

        });
    }
    //open gameActivity
    public void openActivity() {
        System.out.println("goes back to gameActivity");
        Intent game = new Intent(this, GameActivity.class);
        startActivity(game);
    }


}

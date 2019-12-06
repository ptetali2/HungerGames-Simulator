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
    private ArrayList<String> labels = new ArrayList<>();
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
        defaultNames.add("13");
        defaultNames.add("14");
        defaultNames.add("15");
        defaultNames.add("16");
        defaultNames.add("17");
        defaultNames.add("18");
        defaultNames.add("19");
        defaultNames.add("20");
        defaultNames.add("21");
        defaultNames.add("22");
        defaultNames.add("23");
        defaultNames.add("24");


        labels.add("District 1a");
        labels.add("District 1b");
        labels.add("District 2a");
        labels.add("District 2b");
        labels.add("District 3a");
        labels.add("District 3b");
        labels.add("District 4a");
        labels.add("District 4b");
        labels.add("District 5a");
        labels.add("District 5b");
        labels.add("District 6a");
        labels.add("District 6b");
        labels.add("District 7a");
        labels.add("District 7b");
        labels.add("District 8a");
        labels.add("District 8b");
        labels.add("District 9a");
        labels.add("District 9b");
        labels.add("District 10a");
        labels.add("District 10b");
        labels.add("District 11a");
        labels.add("District 11b");
        labels.add("District 12a");
        labels.add("District 12b");


        //Set up RecyclerView
        recyclerView = findViewById(R.id.nameSetup);
        recyclerView.setHasFixedSize(true);
        //LinearLayout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //Set up Adapter
        adapter = new SetupAdapter(defaultNames, labels);
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

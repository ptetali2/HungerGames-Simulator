package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    private ArrayList<String> finalNames = new ArrayList<String>();
    public static ArrayList<Tribute> tributeList = new ArrayList<Tribute>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Set up stuff
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        setTitle("Hunger Games Simulator");
        RelativeLayout setup = findViewById(R.id.setup);
        setup.setBackgroundColor(Color.BLACK);
        TextView title = findViewById(R.id.textView2);
        title.setTextColor(Color.rgb(243, 143, 42));
        title.setTextSize(32);

        //Add default names to ArrayList
        String[] randomNames = {"Adam","Adrian","Alan","Alexander","Andrew","Anthony","Austin","Benjamin","Blake","Boris","Brandon","Brian","Cameron","Carl","Charles","Christian","Christopher","Colin","Connor","Dan","David","Dominic","Dylan","Edward","Eric","Evan","Frank","Gavin","Gordon","Harry","Abigail","Alexandra","Alison","Amanda","Amelia","Amy","Andrea","Angela","Anna","Anne","Audrey","Ava","Bella","Bernadette","Carol","Caroline","Carolyn","Chloe","Claire","Deirdre","Diana","Diane","Donna","Dorothy","Elizabeth","Ella","Emily","Emma","Faith","Felicity","Fiona","Gabrielle","Grace","Hannah","Heather","Irene","Jan","Jane","Jasmine","Jennifer","Jessica","Joan","Joanne","Julia","Karen","Katherine","Kimberly","Kylie","Lauren","Leah","Lillian","Lily","Lisa","Madeleine","Maria","Mary","Megan","Melanie","Michelle","Molly","Natalie","Nicola","Olivia","Penelope","Pippa","Rachel","Rebecca","Rose","Ruth","Sally","Samantha","Sarah","Sonia","Sophie","Stephanie","Sue","Theresa","Tracey","Una","Vanessa","Victoria","Virginia","Wanda","Wendy","Yvonne"};
        String[] testArray = new String[24];
        boolean different = false;
        while (!different) {
            different = true;
            for (int i = 0; i < 24; i++) {
                int x = (int) (Math.random() * ((114 - 0) + 1));
                testArray[i] = randomNames[x];
            }
            for (int i = 0; i < testArray.length; i++) {
                for (int j = i + 1; j < testArray.length; j++) {
                    if (testArray[i].equals(testArray[j])) {
                        different = false;
                    }
                }
            }
        }
        for (int i = 0; i < 24; i++) {
            defaultNames.add(testArray[i]);
        }


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
                finalNames = ((SetupAdapter)adapter).getEditedNames();
                //Make tributes
                createTributes();
                openActivity();
            }

        });
    }
    //open gameActivity
    public void openActivity() {
        System.out.println("goes back to gameActivity");
        Intent intent = new Intent(this, GameActivity.class);
        //intent.putExtra("tributesList",tributeList);
        startActivity(intent);
    }
    public void createTributes() {
        int[] districts = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12,12};
        for (int i = 0; i < 24; i++) {
            Tribute t = new Tribute(finalNames.get(i), districts[i]);
            tributeList.add(t);
        }
    }


}

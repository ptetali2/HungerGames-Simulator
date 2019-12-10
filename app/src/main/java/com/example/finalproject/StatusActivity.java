package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class StatusActivity extends AppCompatActivity {
    public static ArrayList<Tribute> tributeList = new ArrayList<Tribute>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_status);
        setTitle("Hunger Games Simulator");
        RelativeLayout status = findViewById(R.id.status);
        status.setBackgroundColor(Color.BLACK);
        Button back = findViewById(R.id.back);
        //everything else (name, district, status)
        tributeList = GameActivity.tributeList;
        //kills
        init();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

    }
    public void init() {
        TableLayout table = findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);
        TextView tDistrict = new TextView(this);
        tDistrict.setText(" District ");
        tDistrict.setTextColor(Color.WHITE);
        tDistrict.setTextSize(20);
        tbrow0.addView(tDistrict);
        TextView tName = new TextView(this);
        tName.setText("   Name ");
        tName.setTextColor(Color.WHITE);
        tName.setTextSize(20);
        tbrow0.addView(tName);
        TextView tKills = new TextView(this);
        tKills.setText(" Number of Kills " + "\n");
        tKills.setTextColor(Color.WHITE);
        tKills.setTextSize(20);
        tbrow0.addView(tKills);
        table.addView(tbrow0);
        for (int i = 0; i < tributeList.size(); i++) {
            System.out.println(tributeList.get(i).getName());
        }

        for (int i = 0;i < tributeList.size(); i++) {
            TableRow tbrow = new TableRow(this);

            TextView district = new TextView(this);
            String dist = Integer.toString(tributeList.get(i).getDistrict());
            district.setText(dist);
            district.setTextColor(Color.WHITE);
            district.setGravity(Gravity.CENTER);
            tbrow.addView(district);

            TextView name = new TextView(this);
            name.setText(tributeList.get(i).getName());
            name.setTextColor(Color.WHITE);
            name.setGravity(Gravity.CENTER);
            tbrow.addView(name);


            TextView kills = new TextView(this);

            kills.setText(Integer.toString(tributeList.get(i).getKills()));
            kills.setTextColor(Color.WHITE);
            kills.setGravity(Gravity.CENTER);
            tbrow.addView(kills);
            table.addView(tbrow);
        }

    }

    public void openActivity() {
        Intent game = new Intent(this, GameActivity.class);

        startActivity(game);
    }


}

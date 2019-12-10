package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    public static ArrayList<Tribute> tributeList;
    private static int dayCount = 0;
    private static int nightCount = 0;
    private static int count = 0;
    private static boolean dies = false;
    private static String bigString = "Click CONTINUE to start the simulation ";
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setTitle("Hunger Games Simulator");
        RelativeLayout game = findViewById(R.id.game);
        game.setBackgroundColor(Color.BLACK);
        text = findViewById(R.id.text);
        text.setMovementMethod(new ScrollingMovementMethod());
        tributeList = SetupActivity.tributeList;
        text.setText(bigString);
        simulation();
    }
    private void simulation() {
        Button cont = findViewById(R.id.cont);
        Button status = findViewById(R.id.status);
        Button back = findViewById(R.id.back);

        cont.setOnClickListener(v -> {
            //tributeListCopy.addAll(tributeList);

            if (tributeList.size() == 1) {
                bigString += "\n" + "\n"+ "The winner of the Hunger Games is  " + tributeList.get(0).getName() + " from District " + tributeList.get(0).getDistrict()+ "\n" ;
                tributeList.clear();
            } else if (tributeList.size() == 0) {
                bigString += "\n" + "\n"+ "There is no winner" + "\n";
                tributeList.clear();
            } else {
                if (count == 0) {
                    bigString = "";
                    bigString += "Welcome to the Bloodbath: May the odds be ever in your favor" + "\n" + "\n"+ "\n";
                    bloodBath();
                    count++;
                    //day
                } else if (count % 2 != 0) {
                    dayCount++;
                    bigString += "\n" + "Day " + dayCount + "\n" + "\n";
                    day();
                    count++;
                    //night
                } else {
                    nightCount++;
                    bigString += "\n" + "Night " + nightCount + "\n" + "\n";
                    night();
                    count++;
                }
            }
            text.setText(bigString);

        });
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStatusActivity();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigString = "";
                count = 0;
                nightCount = 0;
                dayCount = 0;
                tributeList.clear();
                openMainActivity();
            }
        });



    }
    public void day() {
        for (int i = 0; i < tributeList.size(); i++) {
            int prob = (int) (Math.random() * 100);
            if (prob >= 1 && prob <= 40) {
                //fight
                int otherTribute = (int) (Math.random() * tributeList.size());
                if (i == otherTribute) {
                    bigString += tributeList.get(i).getName() + " " + "could not handle the pressure of the games and decided to take their own life" + "\n";;
                    tributeList.get(i).setStatus();
                    //find index
                    tributeList.remove(i);
                    i--;
                } else {
                    bigString += fight(i, otherTribute) + "\n";
                    if (dies) {
                        i--;
                        dies = false;
                    }
                }
            } else if (prob >= 41 && prob <= 71) {
                int prob1 = (int) (Math.random() * 100);
                String[] survivalActions = {"searches for food", "searches for water source", "climbs a tree", "hides under a rock", "searches for a place to sleep", "starts a fire", "goes hunting", "goes fishing", "builds a shelter", "spots smoke in the distance", "finds a cave"};
                if (prob1 >= 1 && prob1 <= 20) {
                    //forms alliance
                    int otherTribute = (int) (Math.random() * tributeList.size());
                    if (i == otherTribute) {
                        bigString += tributeList.get(i).getName() + " " + "thinks about home" + "\n";
                    } else {
                        bigString += tributeList.get(i).getName() + " forms and alliance with " + tributeList.get(otherTribute).getName() + "\n";
                    }
                }
                //survival actions
                else {
                    int survivalLength = survivalActions.length - 1;
                    int actionIndex = (int) (Math.random() * ((survivalLength - 0) + 1));
                    String action  = survivalActions[actionIndex];
                    bigString += tributeList.get(i).getName() + " " + action + "\n";
                }
                //Sponsorship
            } else if (prob >= 72 && prob <= 82 ){
                bigString += tributeList.get(i).getName() + " receives a " + grabItems(i) + " from an unknown sponsor" + "\n";
                //Random Action
            } else {
                String[] randomActions = {"dabs secretly", "trips over their own leg", "cries for two hours", "misses their family", "wishes they were dreaming", "barfs endlessly", "doodles with a stick", "cries for help", "cleans themselves in a body of water"};
                int randLength = randomActions.length - 1;
                int randAct = (int) (Math.random() * ((randLength - 0) + 1));
                String randAction  = randomActions[randAct];
                bigString += tributeList.get(i).getName() + " " + randAction + "\n";
            }
        }
    }
    public void night() {
        for (int i = 0; i < tributeList.size(); i++) {
            int prob = (int) (Math.random() * 100);
            if (prob >= 1 && prob <= 21) {
                int otherTribute = (int) (Math.random() * tributeList.size());
                if (i == otherTribute) {
                    bigString += tributeList.get(i).getName() + " " + "could not handle the pressure of the games and decided to take their own life" + "\n";
                    tributeList.get(i).setStatus();
                    tributeList.remove(i);
                    i--;
                } else {
                    bigString += fight(i, otherTribute) + "\n";
                    if (dies) {
                        i--;
                        dies = false;
                    }
                }
            } else if (prob >= 22 && prob <= 52) {
                String[] nightDeathActions = {"strangles", "chokes", "sneaks up on and", "slits the throat of", "kills"};
                int actionSize = nightDeathActions.length;
                int action = (int) (Math.random() * ((actionSize)));
                int otherTribute = (int) (Math.random() * tributeList.size());
                if (i == otherTribute) {
                    bigString += tributeList.get(i).getName() + " " + "could not handle the pressure of the games and decided to take their own life" + "\n";
                    tributeList.get(i).setStatus();
                    tributeList.remove(i);
                    i--;
                } else {
                    bigString += tributeList.get(i).getName() + " " + nightDeathActions[action] + " " + tributeList.get(otherTribute).getName() + " from District " + tributeList.get(otherTribute).getDistrict() + " in their sleep" + "\n";
                    tributeList.get(otherTribute).setStatus();
                    //updateStatus in tributeList

                    tributeList.get(i).updateKills();
                    tributeList.remove(otherTribute);
                }
            } else {
                String[] sleepActions = {"falls asleep in a tree", "sleeps throughout the night", "cries themselves to sleep", "is on guard throughout the night", "starts a fire for warmth", "forms a blanket out of leaves", "finds a cave to sleep in", "thinks about loved ones", "hunts for resources throughout the night", "has a hard time falling asleep", "sleeps peacefully "};
                int sleepAction = (int) (Math.random() * ((sleepActions.length)));
                bigString += tributeList.get(i).getName() + " " + sleepActions[sleepAction] + "\n";
            }
        }

    }
    public void openStatusActivity() {
        Intent intent = new Intent(this,StatusActivity.class);
        startActivity(intent);

    }
    public void openMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
    public String grabItems(int position) {
        String[] specialItems = {" First Aid Kit ", " Backpack", " Pack of Food and Water", " Trident", " Frying Pan", " Sword"};
        String[] allItems = {" First Aid Kit ", " Backpack", " Pack of Food and Water", " Trident", " Frying Pan", "n Axe", " Mace", " Bow and Arrow", " Brick", " Crossbow", " Knife", " Machette", " Net", " pile of Rocks", " Sickle", " Slingshot", " Spear", " Sword", " Few Throwing Knives", " Few Matches", " Blanket", " Water Flask", " Rope"};
        //Generate a probability
        int allItemsLength = allItems.length - 1;
        int itemIndex = (int) (Math.random() * ((allItemsLength - 0) + 1));
        String item  = allItems[itemIndex];
        for (int i = 0; i < specialItems.length; i++) {
            if (item.equals(specialItems[i])) {
                tributeList.get(position).updateSpecialItem();
            }
        }
        return item;

    }
    public String fight(int position1, int position2) {
        String[] deathActions = {"stabs", "snaps the neck of", "drowns", "kills"};
        String[] injuredActions = {"punches", "knocks out", "beats up", "knocks the wind out of", "bruises"};
        String statement = "";
        int probWinner = (int) (Math.random() * 2);
        int probDeath = (int) (Math.random() * 2);
        int deathSize = deathActions.length;
        int injureSize = injuredActions.length;
        if (probDeath == 0) {
            int death = (int) (Math.random() * ((deathSize)));
            if (probWinner == 0) {
                statement = tributeList.get(position1).getName() + " " + deathActions[death] + " " + tributeList.get(position2).getName() + " from District " + tributeList.get(position2).getDistrict();
                tributeList.get(position2).setStatus();
                tributeList.get(position1).updateKills();
                dies = true;
                tributeList.remove(position2);
            } else {
                statement = tributeList.get(position2).getName() + " " + deathActions[death] + " " + tributeList.get(position1).getName() + " from District " + tributeList.get(position1).getDistrict();
                tributeList.get(position1).setStatus();
                tributeList.get(position2).updateKills();
                dies = true;
                tributeList.remove(position1);
            }
        } else {
            int injured = (int) (Math.random() * ((injureSize)));
            if (probWinner == 0) {
                statement = tributeList.get(position1).getName() + " " + injuredActions[injured] + " " + tributeList.get(position2).getName();
            } else {
                statement = tributeList.get(position2).getName() + " " + injuredActions[injured] + " " + tributeList.get(position1).getName();
            }
        }
        return statement;
    }
    public void bloodBath() {
        for (int i = 0; i < tributeList.size(); i++) {
            int prob = (int) (Math.random() * 100);
            if (prob >= 1 && prob <= 25) {
                //fight
                int otherTribute = (int) (Math.random() * tributeList.size());
                if (i == otherTribute) {
                    bigString += tributeList.get(i).getName() + " " + "could not handle the pressure of the games and decided to take their own life" + "\n";
                    tributeList.get(i).setStatus();
                    tributeList.remove(i);
                    i--;
                } else {
                    bigString += fight(i, otherTribute) + "\n";
                    if (dies) {
                        i--;
                        dies = false;
                    }
                }
            } else if (prob >= 26 && prob <= 66) {
                bigString += tributeList.get(i).getName() + " grabs a" + grabItems(i) + "\n";
            } else {
                bigString += tributeList.get(i).getName() + " runs away from the Cornucopia"+ "\n";
            }
        }

    }
    public ArrayList<Tribute> getTributes() {
        return tributeList;
    }
}

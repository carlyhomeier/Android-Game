package com.cayoticreations.lifesim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

    public void go_to_main_screen (View view){
        Intent mainScreen = new Intent(StartScreen.this, MainScreen.class);
        startActivity(mainScreen);
    }

    public void set_stats_new(View view){
        StatsPage.newgamestatus = true;
        Intent mainScreen = new Intent(StartScreen.this, MainScreen.class);
        startActivity(mainScreen);
    }
}
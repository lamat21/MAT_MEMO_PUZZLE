package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class SubmitBtn extends AppCompatActivity {
    TextView nickName, latestScore, highScore, numOfGame;
    private Button playAgain = (Button) findViewById(R.id.playAgain);
    private Button homeButton = (Button) findViewById(R.id.homeButton);
    private Stats userStats = new Stats();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_btn);

        //Set Stats
        userStats = getIntent().getParcelableExtra("userStats");

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivitySelectLevels();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitymainActivity();
            }

        });

        //Set Settings
        nickName = findViewById(R.id.name);
        latestScore = findViewById(R.id.latestScore);
        highScore = findViewById(R.id.highScore);
        numOfGame = findViewById(R.id.gamesPlayed);

        Stats userStats = getIntent().getParcelableExtra("userStats");
        nickName.setText(userStats.getNickname());
        latestScore.setText("  " + userStats.getLatestScore());
        highScore.setText("  " + userStats.getHighScore());
        numOfGame.setText("  " + (userStats.getNumOfGames()));
    }

    public void openActivitySelectLevels() {
        Intent playAgain = new Intent(this, SelectFromLevels.class);
        startActivity(playAgain);
    }
    public void openActivitymainActivity() {
        Intent homeButton = new Intent(this, MainActivity.class);
        homeButton.putExtra("StatsUpdate", userStats);
        startActivity(homeButton);
    }
}
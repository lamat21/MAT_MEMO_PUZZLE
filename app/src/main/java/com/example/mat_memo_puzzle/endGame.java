package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class endGame extends AppCompatActivity {

    private TextView latestScore, highScore2, numGamesPlayed2;
    private Button playAgain;
    private Button homeButton ;
    //private Stats userStats = new Stats();
    private int score = 0;
    private int latestScore2 = 0;
    private int highScore = 0;
    private int numGamesPlayed  =0;
    private String name = "Dema";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        name = getIntent().getStringExtra("name");
        latestScore2 = getIntent().getIntExtra("latestScore", latestScore2);
        highScore = getIntent().getIntExtra("highScore", highScore);
        numGamesPlayed = getIntent().getIntExtra("numGamesPlayed", numGamesPlayed);
        numGamesPlayed++;


        latestScore = findViewById(R.id.latestScore);
        highScore2 = findViewById(R.id.highScore);
        numGamesPlayed2 = findViewById(R.id.numGamesPlayed);
        highScore2.setText(" " + highScore);
        latestScore.setText("  " + latestScore2);
        numGamesPlayed2.setText(" " + numGamesPlayed);
        playAgain = (Button) findViewById(R.id.playAgain);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivitySelectLevels();
            }
        });
        homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivitymainActivity();
            }

        });
    }
    public void openActivitySelectLevels() {
        Intent playAgain = new Intent(this, SelectFromLevels.class);
        playAgain.putExtra("latestScore", latestScore2);
        playAgain.putExtra("highScore", highScore);
        playAgain.putExtra("numGamesPlayed", numGamesPlayed);
        playAgain.putExtra("name", name);
        startActivity(playAgain);
    }
    public void openActivitymainActivity() {
        Intent homeButton = new Intent(this, MainActivity.class);
        homeButton.putExtra("latestScore", latestScore2);
        homeButton.putExtra("highScore", highScore);
        homeButton.putExtra("numGamesPlayed", numGamesPlayed);
        homeButton.putExtra("name", name);
        startActivity(homeButton);
    }
}
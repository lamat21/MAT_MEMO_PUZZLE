package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;

public class PopStats extends AppCompatActivity {

    private TextView nickName , latestScore, highScore, numOfGame;
    private int latestScore2 = 0;
    private int highScore2 = 0;
    private int numGamesPlayed  =0;
    private String name = "Dema";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_stats);

        //popUP Settings
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width =  dm. widthPixels;
        int height =  dm.heightPixels;

        getWindow(). setLayout ((int) (width*.8) , (int) (height*.6));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        //Set Settings
        nickName = findViewById(R.id.nickName);
        latestScore = findViewById(R.id.latestScore);
        highScore = findViewById(R.id.highestScore);
        numOfGame = findViewById(R.id.numberOfGames);


        name = getIntent().getStringExtra("name");
        latestScore2 = getIntent().getIntExtra("latestScore", 0);
        highScore2 = getIntent().getIntExtra("highScore", 0);
        numGamesPlayed = getIntent().getIntExtra("numGamesPlayed", 0);


        nickName.setText(name);
        latestScore.setText("  " + latestScore2);
        highScore.setText("  " + highScore2);
        numOfGame.setText("  " + numGamesPlayed);

    }
}
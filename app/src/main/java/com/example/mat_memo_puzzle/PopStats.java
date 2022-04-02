package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;

public class PopStats extends AppCompatActivity {

    TextView nickName, latestScore, highScore, numOfGame;

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

        Stats userStats = getIntent().getParcelableExtra("userStats");
        nickName.setText(userStats.getNickname());
        latestScore.setText(userStats.getLatestScore());
        highScore.setText(userStats.getHighScore());
        numOfGame.setText(userStats.getNumOfGames());

    }
}
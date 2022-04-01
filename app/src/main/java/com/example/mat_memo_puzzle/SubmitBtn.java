package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class SubmitBtn extends AppCompatActivity {
    private Button playAgain;
    private Button homeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_btn);

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
        startActivity(playAgain);
    }
    public void openActivitymainActivity() {
        Intent homeButton = new Intent(this, MainActivity.class);
        startActivity(homeButton);
    }
}
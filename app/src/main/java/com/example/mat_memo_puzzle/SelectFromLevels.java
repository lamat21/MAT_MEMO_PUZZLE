package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectFromLevels extends AppCompatActivity {
    private Button easyButton, mediumButton, hardButton;
    private int latestScore = 0;
    private int highScore = 0;
    private int numGamesPlayed  =0;
    private String name = "Dema";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_from_levels);


        //Set Stats
        name = getIntent().getStringExtra("name");
        latestScore = getIntent().getIntExtra("latestScore", latestScore);
        highScore = getIntent().getIntExtra("highScore", highScore);
        numGamesPlayed = getIntent().getIntExtra("numGamesPlayed", numGamesPlayed);

        easyButton = (Button) findViewById(R.id.easyButton);
        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityeasyLevel();
            }
        });
        mediumButton = (Button) findViewById(R.id.mediumButton);
        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitymediumLevel();
            }
        });
        hardButton = (Button) findViewById(R.id.hardButton);
        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityhardLevel();
            }
        });
    }

    public void openActivityeasyLevel() {
        Intent easyButton = new Intent(this, EasyLevel.class);
        easyButton.putExtra("latestScore", latestScore);
        easyButton.putExtra("highScore", highScore);
        easyButton.putExtra("numGamesPlayed", numGamesPlayed);
        easyButton.putExtra("name", name);
        startActivity(easyButton);
    }

   public void openActivitymediumLevel() {
        Intent mediumButton = new Intent(this, MediumLevel.class);
        mediumButton.putExtra("latestScore", latestScore);
        mediumButton.putExtra("highScore", highScore);
        mediumButton.putExtra("numGamesPlayed", numGamesPlayed);
        mediumButton.putExtra("name", name);
        startActivity(mediumButton);
    }
    public void openActivityhardLevel() {
        Intent hardButton = new Intent(this, HardLevel.class);
        hardButton.putExtra("latestScore", latestScore);
        hardButton.putExtra("highScore", highScore);
        hardButton.putExtra("numGamesPlayed", numGamesPlayed);
        hardButton.putExtra("name", name);
        startActivity(hardButton);
    }
}
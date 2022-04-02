package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuBtn extends AppCompatActivity {
    private Button settingsButton;
    private Button instructionButton;
    private Button quitGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_btn);

        settingsButton = (Button) findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPopSettings();
            }

        });
        instructionButton = (Button) findViewById(R.id.instructionButton);
        instructionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivityPopIntrctions();
            }

        });
        quitGame = (Button) findViewById(R.id.quitGame);
        quitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitymainActivity();
            }

        });

    }
    public void openActivityPopSettings() {
        Intent popSettings = new Intent(this, PopSettings.class);
        startActivity(popSettings);
    }
    public void openActivityPopIntrctions() {
        Intent popInstructions = new Intent(this, popInstructions.class);
        startActivity(popInstructions);
    }
    public void openActivitymainActivity() {
        Intent homeButton = new Intent(this, MainActivity.class);
        startActivity(homeButton);
    }
}
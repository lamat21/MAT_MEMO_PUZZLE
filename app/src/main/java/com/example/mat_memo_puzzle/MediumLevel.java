package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MediumLevel extends AppCompatActivity {
    private Button pauseBtn = findViewById(R.id.pauseBtn);
    private Button submitBtn = findViewById(R.id.submitBtn);
    private TextView DisplayList = findViewById(R.id.displayList);
    private TextView DisplayInstructions = findViewById(R.id.displayInstructions);
    private EditText userInput = findViewById(R.id.userInput);
    GameBoard game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_level);

        game = new GameBoard(1);

        displayRandNumList();

        displayScrambledNumList();

        pauseBtn = (Button) findViewById(R.id.pauseBtn);
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPauseBtn();
            }
        });
        submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitySubmitBtn();
            }

        });
    }
    public void openActivityPauseBtn() {
        Intent pausebtn = new Intent(this, MenuBtn.class);
        startActivity(pausebtn);
    }
    public void openActivitySubmitBtn() {

        if (!false){
            // game.checkanswer if false show end screen/popup, else reset gameboard and continue.

            Intent submitBtn = new Intent(this, SubmitBtn.class);
            startActivity(submitBtn);}
    }

    public void displayRandNumList() {
        for (int i = 0; i < game.getNumberList().size(); i++) {
            pause(1500);
            DisplayList.setText("" + game.getNumberList().get(i));
            pause(1500);
            DisplayList.setText("");
        }
    }

    public void displayScrambledNumList() {
        for (int i = 0; i < game.getNumberList().size(); i++) {
            pause(1500);
            DisplayList.setText("" + game.getNumberList().get(i));
            pause(1500);
            DisplayList.setText("");
        }
    }

    public void pause(int numMillisecond){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
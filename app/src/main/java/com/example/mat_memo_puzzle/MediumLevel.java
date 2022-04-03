package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MediumLevel extends AppCompatActivity {
    private Button pauseBtn = findViewById(R.id.pauseBtn);
    private Button submitBtn = findViewById(R.id.submitBtn);
    private TextView DisplayList = findViewById(R.id.displayList);
    private TextView DisplayInstructions = findViewById(R.id.displayInstructions);
    private EditText userInput = findViewById(R.id.userInput);
    GameBoard game;
    private Stats userStats = new Stats();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_level);

        //Set Stats
        userStats = getIntent().getParcelableExtra("userStats");

        pauseBtn = (Button) findViewById(R.id.pauseBtn);
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPauseBtn();
            }
        });

        game = new GameBoard(1);
        boolean keepPlaying = true;

        while (keepPlaying){
            displayRandNumList();

            displayScrambledNumList();

            keepPlaying = game.checkAnswer(getUserInput());
            if(keepPlaying){
                game.resetGameBoard(1);}
        }
        openActivitySubmitBtn();

    }
    public void openActivityPauseBtn() {
        Intent pausebtn = new Intent(this, MenuBtn.class);
        startActivity(pausebtn);
    }

    public void openActivitySubmitBtn() {
        userStats.addScore(game.getScore());
        Intent submitBtn = new Intent(this, SubmitBtn.class);
        submitBtn.putExtra("userStats", userStats);
        startActivity(submitBtn);
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
        DisplayInstructions.setText("Lets test your memory!");
        pause(1500);
        ArrayList<Integer> scrambleList = game.scramble();
        String numList = "";
        for (int i = 0; i < scrambleList.size(); i++) {
            numList += scrambleList.get(i);
        }
        DisplayList.setText(numList);
    }

    public ArrayList<Integer> getUserInput() {
        ArrayList<Integer> answerUser = new ArrayList<Integer>();
        for(int i = 0; i < game.getNumberList().size(); i++){
            DisplayInstructions.setText("Enter Number " + (i+1) + " In the Sequence");
            submitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int num = Integer.parseInt(userInput.getText().toString());
                    answerUser.add(num);
                }
            });
        }
        return answerUser;
    }


    public void pause(int numMillisecond){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
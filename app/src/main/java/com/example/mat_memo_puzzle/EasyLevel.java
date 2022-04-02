package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class EasyLevel extends AppCompatActivity {
    private Button pauseBtn;
    private Button submitBtn;
    private TextView DisplayList;
    private TextView DisplayInstructions;
    private EditText userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_level);

        DisplayList = (TextView) findViewById(R.id.DisplayList);
        DisplayInstructions = (TextView) findViewById(R.id.DisplayInstructions);

        boolean doWeKeepPlaying = true;
        GameBoard game = new GameBoard(1);
        try {
            while (doWeKeepPlaying){
                //Wait so user can read the starting massage
                Thread.sleep(1000);

                for (Integer i: game.getNumberList()) {
                    DisplayList.setText(i);
                    Thread.sleep(1250);
                    DisplayList.setText("");
                    Thread.sleep(1250);
                }

                //Displays the list of numbers in a scrambled order
                DisplayInstructions.setText("Let's test your memory!");
                ArrayList<Integer> scrambledList = game.scramble();
                String scrambledListOfNum = "";
                for (Integer i: scrambledList) {
                    scrambledListOfNum += i;
                    scrambledListOfNum += "   ";
                }
                DisplayList.setText(scrambledListOfNum);

                //Get users answer
                Thread.sleep(1000);
                ArrayList<Integer> userAnswer = new ArrayList<Integer>();

                for (int i = 0; i < game.getNumberList().size(); i++) {
                    DisplayInstructions.setText("Enter Number " + (i + 1));
                    int num = Integer.parseInt(userInput.getText().toString());
                    userAnswer.add(num);
                }

                //Check answer and give feedback
                if (game.checkAnswer(userAnswer)){
                    game.resetGameBoard(1);
                } else {
                    doWeKeepPlaying = false;
                }
            }
            openActivitySubmitBtn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


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

        Intent submitBtn = new Intent(this, SubmitBtn.class);
        startActivity(submitBtn);}
    }

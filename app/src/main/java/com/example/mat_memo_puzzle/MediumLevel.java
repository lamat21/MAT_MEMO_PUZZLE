package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MediumLevel extends AppCompatActivity {
    private Button pauseBtn;
    private Button submitBtn;
    private TextView DisplayList;
    private TextView DisplayInstructions;
    private EditText userInput;
    private ArrayList<Integer> numberList = new ArrayList<Integer>();
    private int count = 0;
    private ArrayList<Integer> userAns = new ArrayList<Integer>();
    private int score = 0 ;
    private int latestScore = 0;
    private int highScore = 0;
    private int numGamesPlayed  =0;
    private String name = "Dema";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level);

        name = getIntent().getStringExtra("name");
        latestScore =  getIntent().getIntExtra("latestScore", latestScore);
        highScore = getIntent().getIntExtra("highScore", highScore);
        numGamesPlayed = getIntent().getIntExtra("numGamesPlayed", numGamesPlayed);


        addToList(5);
        DisplayInstructions = (TextView)findViewById(R.id.displayInstructions);

        userInput = (EditText) findViewById(R.id.userInput);
        //int count = 0;
        DisplayList = (TextView)findViewById(R.id.displayList);
        DisplayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count < numberList.size()){
                    DisplayList(numberList.get(count));
                    count++;
                }
                else {
                    DisplayList.setText("Enter the numbers in order");
                    count = 0;
                }

            }

        });

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

                if (count < numberList.size()){
                    String value = userInput.getText().toString();
                    int input = Integer.parseInt(value);
                    userAns.add(input);
                    count++;
                    DisplayList.setText(input + "");
                }
                else {
                    if (check()){
                        count = 0;
                        addToList();
                        userAns.removeAll(userAns);
                        DisplayList.setText("Click Me When Ready!");
                        score++;
                    }
                    else{
                        latestScore = score;
                        if (latestScore > highScore){
                            highScore = latestScore;
                        }
                        openActivitySubmitBtn();
                    }
                }

            }

        });
    }
    public void openActivityPauseBtn() {
        latestScore = score;
        if (latestScore > highScore){
            highScore = latestScore;
        }
        Intent pausebtn = new Intent(this, MenuBtn.class);
        pausebtn.putExtra("latestScore", latestScore);
        pausebtn.putExtra("highScore", highScore);
        pausebtn.putExtra("numGamesPlayed", numGamesPlayed);
        pausebtn.putExtra("name", name);
        startActivity(pausebtn);
    }
    public void openActivitySubmitBtn() {

        Intent submitBtn = new Intent(this, endGame.class);
        submitBtn.putExtra("latestScore", latestScore);
        submitBtn.putExtra("highScore", highScore);
        submitBtn.putExtra("numGamesPlayed", numGamesPlayed);
        submitBtn.putExtra("name", name);

        startActivity(submitBtn);
    }

    public void pause(int num){
        try {
            Thread.sleep(num * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void DisplayList(int count) {
        DisplayList = (TextView)findViewById(R.id.displayList);
        DisplayList.setText(count + "");
    }

    public void addToList(){
        int maximum = 5;
        int minimum = 1;
        int x = (int)(Math.random() * maximum) + minimum;

        if (numberList.size() != 0 ){
            while (x == numberList.get(numberList.size() - 1)){
                x = (int)(Math.random() * maximum) + minimum;
            }
        }
        numberList.add(x);
    }

    public void addToList(int num){
        for (int i = 0; i < num; i++) {
            addToList();
        }
    }

    public boolean check(){
        if (userAns.equals(numberList))
        {
            return true;}
        else {
            return false;
        }

    }
}
package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HardLevel extends AppCompatActivity {
    private Button pauseBtn;
    private Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level);

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
}
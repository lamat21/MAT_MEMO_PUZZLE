package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button playButton;
    private Button instructionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivitySelectLevels();
            }
        });
        instructionButton = (Button) findViewById(R.id.instructionButton);
        instructionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivityPopIntrctions();
            }
        });
    }

    public void openActivitySelectLevels(){
        Intent intent = new Intent(this, SelectFromLevels.class);
        startActivity(intent);
    }

    public void openActivityPopIntrctions() {
        Intent popInstructions = new Intent(this, popInstructions.class);
        startActivity(popInstructions);
    }
}
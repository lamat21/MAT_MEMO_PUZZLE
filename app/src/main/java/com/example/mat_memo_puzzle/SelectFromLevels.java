package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectFromLevels extends AppCompatActivity {
    private Button easyButton;
    private Button mediumButton;
    private Button hardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_from_levels);

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
        startActivity(easyButton);
    }

   public void openActivitymediumLevel() {
        Intent mediumButton = new Intent(this, MediumLevel.class);
        startActivity(mediumButton);
    }
    public void openActivityhardLevel() {
        Intent hardButton = new Intent(this, HardLevel.class);
        startActivity(hardButton);
    }
}
package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class PopNickname extends AppCompatActivity {
    private Button submitNickname;
    private EditText nameInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_nickname);

        //popUP Settings
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width =  dm. widthPixels;
        int height =  dm.heightPixels;

        getWindow(). setLayout ((int) (width*.8) , (int) (height*.6));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        //Set Settings
        nameInput = findViewById(R.id.nameInput);
        Stats userStats = getIntent().getParcelableExtra("userStats");

        submitNickname = (Button) findViewById(R.id.submitNicknameBtn);
        submitNickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userStats.resetNickName("" + nameInput.getText());
                openActivitySubmitNickname(userStats);
            }

        });
    }
    public void openActivitySubmitNickname(Stats userStats) {
        Intent submitNickname = new Intent(this, MainActivity.class);
        submitNickname.putExtra("userStatsChangeName", userStats);
        startActivity(submitNickname);
    }

}
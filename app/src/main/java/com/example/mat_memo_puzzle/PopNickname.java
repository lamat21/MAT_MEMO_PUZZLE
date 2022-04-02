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
   /* private Stats userStats = new Stats();*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_nickname);
       /* if (!(getIntent() == null)) {
            Intent recieveName = getIntent();
            String newName = recieveName.getStringExtra("ChangeName");
            userStats.resetNickName(newName);
        }*/
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
        submitNickname = (Button) findViewById(R.id.submitNicknameBtn);
        submitNickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = ("" + nameInput.getText().toString());
                openActivitySubmitNickname(newName);
            }

        });
    }
    public void openActivitySubmitNickname(String newName) {

        Intent submitNickname = new Intent(this, MainActivity.class);
        submitNickname.putExtra("ChangeName", newName);
        startActivity(submitNickname);
        finish();
    }

}
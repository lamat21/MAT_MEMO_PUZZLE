package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class PopNickname extends AppCompatActivity {
    private Button submitNickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_nickname);

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

        submitNickname = (Button) findViewById(R.id.submitNickname);
        submitNickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivitySubmitNickname();
            }

        });
    }
    public void openActivitySubmitNickname() {
        Intent submitNickname = new Intent(this, MainActivity.class);
        startActivity(submitNickname);
    }

}
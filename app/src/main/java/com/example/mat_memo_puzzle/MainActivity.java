package com.example.mat_memo_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private Button playButton;
    private Button instructionButton;
    private Button nicknameButton;
    private Button statsButton;
    private Button settingsButton;
    private VideoView videoview;
    private MediaPlayer mMediaPlayer;
    private int CurrentVideoPosition;
    public Stats userStats = new Stats();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoview = findViewById(R.id.videoview);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.backgroundvid);
        videoview.setVideoURI(uri);
        videoview.start();

        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mMediaPlayer = mediaPlayer;
                mediaPlayer.setLooping(true);

                if (CurrentVideoPosition !=0){
                    mMediaPlayer.seekTo(CurrentVideoPosition);
                    mMediaPlayer.start();
                }
            }
        });


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
        nicknameButton = (Button) findViewById(R.id.nicknameButton);
        nicknameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPopNickname();
            }
        });

        statsButton = (Button) findViewById(R.id.statsButton);
        statsButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                openActivityPopStats();
            }

        });

        settingsButton = (Button) findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPopSettings();
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

    public void openActivityPopNickname() {
        Intent popNickname = new Intent(this, PopNickname.class);
        startActivity(popNickname);
    }

    public void openActivityPopStats() {
        Intent popStats = new Intent(this, PopStats.class);
        popStats.putExtra("userStats", userStats);
        startActivity(popStats);
    }
    public void openActivityPopSettings() {
        Intent popSettings = new Intent(this, PopSettings.class);
        startActivity(popSettings);
    }

    @Override
    protected void onResume() {
        videoview.start();
        super.onResume();
    }

    @Override
    protected void onPause() {
        videoview.pause();
        CurrentVideoPosition = mMediaPlayer.getCurrentPosition();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mMediaPlayer.release();
        super.onDestroy();
        mMediaPlayer = null;
    }
}
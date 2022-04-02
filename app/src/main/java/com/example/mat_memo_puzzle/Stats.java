package com.example.mat_memo_puzzle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.*;

public class Stats implements Parcelable {
    private String nickname;
    private int highScore;
    private int numOfGames;
    private int latestScore;

    public Stats(){
        nickname = "Ali";
        highScore = 0;
        numOfGames = 0;
        latestScore = 0;
    }

    protected Stats(Parcel in) {
        nickname = in.readString();
        highScore = in.readInt();
        numOfGames = in.readInt();
        latestScore = in.readInt();
    }

    public static final Creator<Stats> CREATOR = new Creator<Stats>() {
        @Override
        public Stats createFromParcel(Parcel in) {
            return new Stats(in);
        }

        @Override
        public Stats[] newArray(int size) {
            return new Stats[size];
        }
    };

    public String getNickname(){
        return nickname;
    }

    public int getHighScore(){
        return highScore;
    }

    public int getLatestScore(){
        return latestScore;
    }

    public int getNumOfGames(){
        return numOfGames;
    }

    public void resetNickName(String newName){
        if (newName.length() >= 1 && newName.length() <= 20){
            nickname = newName;
        } else {
            throw new RuntimeException("Name has to be between 1 to 20 characters inclusively.");
        }
    }

    public void addScore (int newScore){
        latestScore = newScore;
        if (highScore < newScore){
            highScore = newScore;
        }
        numOfGames++;
    }

    public String toString (){
        return "nickname " + this.nickname +
                ", highScore " + this.highScore +
                ", numOfGames " + this.numOfGames +
                ", latestScore " + this.latestScore;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nickname);
        parcel.writeInt(highScore);
        parcel.writeInt(numOfGames);
        parcel.writeInt(latestScore);
    }
}
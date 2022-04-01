package com.example.mat_memo_puzzle;
import java.util.*;

public class Stats {
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
}
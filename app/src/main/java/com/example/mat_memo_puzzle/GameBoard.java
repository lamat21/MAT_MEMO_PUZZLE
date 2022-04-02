package com.example.mat_memo_puzzle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.*;
import java.util.ArrayList;

public class GameBoard implements Parcelable {
    private ArrayList<Integer> numberList;
    private int score;

    public GameBoard(int i) {
        int minimum;
        int maximum;
        if (i == 1){
            minimum = 1;
            maximum = 5;
        } else if (i == 2){
            minimum = 1;
            maximum = 10;
        } else {
            throw new RuntimeException("Invalid Input must be either 1 or 2");
        }

        numberList = new ArrayList<Integer>();
        int x = (int)(Math.random() * maximum) + minimum;
        int y = (int)(Math.random() * maximum) + minimum;
        numberList.add(x);
        numberList.add(y);
        this.score = 0;

    }

    protected GameBoard(Parcel in) {
        score = in.readInt();
    }

    public static final Creator<GameBoard> CREATOR = new Creator<GameBoard>() {
        @Override
        public GameBoard createFromParcel(Parcel in) {
            return new GameBoard(in);
        }

        @Override
        public GameBoard[] newArray(int size) {
            return new GameBoard[size];
        }
    };

    public ArrayList<Integer> getNumberList (){
        return numberList;
    }
    public int getScore (){
        return this.score;
    }

    public boolean checkAnswer(ArrayList<Integer> answer) {
        return this.numberList.equals(answer);
    }

    public ArrayList<Integer> scramble (){
        ArrayList<Integer> scrambledNumberList = new ArrayList<Integer>();

        for (int i = 0; i < numberList.size(); i++) {
            scrambledNumberList.add(Integer.valueOf((int)numberList.get(i)));
        }

        Collections.shuffle(scrambledNumberList);
        return scrambledNumberList;
    }

    public void resetGameBoard(int i) {
        int minimum;
        int maximum;
        if (i == 1){
            minimum = 1;
            maximum = 5;
        } else if (i == 2){
            minimum = 1;
            maximum = 10;
        } else {
            throw new RuntimeException("Invalid Input must be either 1 or 2");
        }

        int x = (int)(Math.random() * maximum) + minimum;
        numberList.add(x);
        this.score++;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(score);
    }
}

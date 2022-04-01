package com.example.mat_memo_puzzle;
import java.util.*;
import java.util.ArrayList;

public class GameBoard {
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
}

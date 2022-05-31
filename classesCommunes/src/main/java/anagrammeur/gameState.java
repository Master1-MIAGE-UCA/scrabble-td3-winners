package main.java.anagrammeur;

import java.util.ArrayList;

public class gameState {
    ArrayList<placedWord> wordsList ;
    // where letters are placed
    ArrayList<Character> easel;

    public gameState(ArrayList<placedWord> wordsList, ArrayList<Character> easel) {
        this.wordsList = wordsList;
        this.easel = easel;
    }

    public ArrayList<placedWord> getWordsList() {
        return wordsList;
    }

    public void setWordsList(ArrayList<placedWord> wordsList) {
        this.wordsList = wordsList;
    }

    public ArrayList<Character> getEasel() {
        return easel;
    }

    public void setEasel(ArrayList<Character> easel) {
        this.easel = easel;
    }
}

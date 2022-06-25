package anagramme;

import java.util.ArrayList;

public class gameState {
    ArrayList<position> wordsList ;
    // where letters are placed
    ArrayList<Character> easel;

    public gameState(ArrayList<position> wordsList, ArrayList<Character> easel) {
        this.wordsList = wordsList;
        this.easel = easel;
    }

    public ArrayList<position> getWordsList() {
        return wordsList;
    }

    public void setWordsList(ArrayList<position> wordsList) {
        this.wordsList = wordsList;
    }

    public ArrayList<Character> getEasel() {
        return easel;
    }

    public void setEasel(ArrayList<Character> easel) {
        this.easel = easel;
    }
}

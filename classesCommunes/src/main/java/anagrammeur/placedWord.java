package main.java.anagrammeur;

public class placedWord {
    private String word;
    private int abscissa;
    private int ordinate;
    private boolean vertical;

    public placedWord(String word, int abscissa, int ordinate, boolean vertical) {
        this.word = word;
        this.abscissa = abscissa;
        this.ordinate = ordinate;
        this.vertical = vertical;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getOrdinate() {
        return ordinate;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public void setOrdinate(int ordinate) {
        this.ordinate = ordinate;
    }

    public int getAbscissa() {
        return abscissa;
    }

    public void setAbscissa(int abscissa) {
        this.abscissa = abscissa;
    }
}

package anagramme;

public class placeLetter {
    private  String letter;

    public placeLetter(String letter){
        this.letter = letter;

    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
    @Override
    public String toString() {
        return "Letter{" +
                "letter='" + letter +
                '}';
    }
}

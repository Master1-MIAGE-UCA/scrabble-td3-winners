package anagramme;

public class box {
    int row;
    int cell;
    placeLetter letter;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    public box(int row, int cell) {
        this.row = row;
        this.cell = cell;
    }

    public void setLetter(placeLetter letter) {
        this.letter = letter;
    }
    public placeLetter getLetter() {
        return letter;
    }

}

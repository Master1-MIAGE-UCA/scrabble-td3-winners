package anagrammeur;

public class box {
    int row;
    int cell;

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
}

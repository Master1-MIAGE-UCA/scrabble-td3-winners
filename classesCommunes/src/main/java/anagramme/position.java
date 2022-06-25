package anagramme;

public class position {
    private int abscissa;
    private int ordinate;


    public position(int abscissa, int ordinate) {

        this.abscissa = abscissa;
        this.ordinate = ordinate;

    }


    public position(){

    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + abscissa +
                ", y=" + ordinate +
                '}';
    }


    public int getOrdinate() {
        return ordinate;
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

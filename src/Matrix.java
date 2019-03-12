import java.util.ArrayList;

/**
 * Created by mayalake on 3/11/19.
 */
public class Matrix {
    private int numRows;
    private int numCols;
    private Fraction[][] coefficients;

    public Matrix(Fraction[][] coefficients){
        numRows = coefficients.length;
        numCols = coefficients[0].length;
        this.coefficients = coefficients;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() { return numCols; }

    public Fraction[][] getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(Fraction[][] coefficients) {
        this.coefficients = coefficients;
    }
}



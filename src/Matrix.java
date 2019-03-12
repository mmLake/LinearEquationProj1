import java.util.ArrayList;

/**
 * Created by mayalake on 3/11/19.
 */
public class Matrix {
    private int numRows;
    private double[][] coefficients;

    public Matrix(double[][] coefficients){
        numRows = coefficients.length;
        this.coefficients = coefficients;
    }

    public int getNumRows() {
        return numRows;
    }

    public double[][] getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(double[][] coefficients) {
        this.coefficients = coefficients;
    }
}



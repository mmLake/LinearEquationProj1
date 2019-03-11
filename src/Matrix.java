import java.util.ArrayList;

/**
 * Created by mayalake on 3/11/19.
 */
public class Matrix {
    private int numRows;
    private ArrayList<ArrayList<Double>> coefficients = new ArrayList<>();

    private int[] finalVals;

    public Matrix(ArrayList<ArrayList<Double>> coefficients){
        this.coefficients = coefficients;
        numRows = coefficients.size();

        finalVals = new int[numRows];
    }

    public int getNumRows() {
        return numRows;
    }

    public ArrayList<ArrayList<Double>> getCoefficients() {
        return coefficients;
    }

    public int[] getFinalVals() {
        return finalVals;
    }

    public void setFinalVals(int[] finalVals) {
        this.finalVals = finalVals;
    }

}

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mayalake on 3/10/19.
 */
public class Methods {

    public static void gaussElimPartialPivot(Matrix matrix) {
        int[] finalVals = new int[matrix.getNumRows()];
        int[] maxVals = new int[matrix.getNumRows()];
        int rowIdx = 0;


        Arrays.setAll(maxVals, i -> Integer.MIN_VALUE);

        //find largest value in each row
        for (ArrayList<Double> row : matrix.getCoefficients()) {
            for (double rowVal : row) {
                if (Math.abs(rowVal) > maxVals[rowIdx])
                    maxVals[rowIdx] = (int) Math.abs(rowVal);
            }
            rowIdx++;
        }

        ArrayList<Double> pivotRow;
        int pivotIdx;
        double multiplier;

        for (int i = 0; i < matrix.getNumRows(); i++) {
            //get pivot row
            pivotIdx = getPivotIdx(matrix, i, maxVals);
            pivotRow = matrix.getCoefficients().get(pivotIdx);
            maxVals[pivotIdx] = Integer.MIN_VALUE;

            //update matrix based on pivot
            for (ArrayList<Double> row: matrix.getCoefficients()){
                if (!row.equals(pivotRow)){
                    multiplier = (row.get(i) - pivotRow.get(i))/pivotRow.get(i);
                }
            }

        }

    }

    private static void updateMatrix(Matrix matrix, double multiplier, int pivotIdx){
        for (ArrayList<Double> row : matrix.getCoefficients()){
            if (matrix.getCoefficients().get(pivotIdx) != row){
                for (double val : row){
                }
            }
        }
    }

    private static int getPivotIdx(Matrix matrix, int i, int[] maxVals){
        double maxPivotVal = -1;
        double tempPivotVal;
        int rowIdx = 0;
        int pivotIdx = -1;

        for (ArrayList<Double> row : matrix.getCoefficients()){
            tempPivotVal = row.get(i)/ maxVals[rowIdx];

            if (tempPivotVal > maxPivotVal) {
                maxPivotVal = tempPivotVal;
                pivotIdx = rowIdx;
            }
            rowIdx++;
        }

        return pivotIdx;
    }

    public static void jacobiIterative(){

    }

    public static void gaussSeidel(){

    }
}

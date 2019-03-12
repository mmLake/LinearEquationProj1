import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mayalake on 3/10/19.
 */
public class Methods {

    public static void gaussElimPartialPivot(Matrix matrix) {
        int pivotIdx;

        double[][] matrixVals = matrix.getCoefficients();
        double[][] finalMatrixVals = new double[matrix.getNumRows()][matrix.getNumRows()];
        int[] finalVals = new int[matrix.getNumRows()];
        int[] maxVals = new int[matrix.getNumRows()];

        //initialize
        int rowIdx = 0;
        Arrays.setAll(maxVals, i -> Integer.MIN_VALUE);

        //find largest value in each row & populate maxVals
        for (double[] row : matrixVals){
            for (double val : row){
                if (Math.abs(val) > maxVals[rowIdx])
                    maxVals[rowIdx] = (int) Math.abs(val);
            }
            rowIdx++;
        }

        //run algorithm
        for (int i = 0; i < matrix.getNumRows(); i++) {
            //get pivot row
            pivotIdx = getPivotIdx(matrixVals, i, maxVals);

            maxVals[pivotIdx] = Integer.MIN_VALUE;

            //save pivot row
            finalMatrixVals[matrix.getNumRows()-1-i] = matrixVals[pivotIdx];

            //update matrix based on pivot
            matrixVals = updateMatrix(matrixVals, pivotIdx, i);
        }

        matrix.setCoefficients(finalMatrixVals);
    }

    private static double[][] updateMatrix(double[][] matrixVals, int pivotIdx, int i){
        double multiplier;
        double[] row;

        double[] pivotRow = matrixVals[pivotIdx];

        for (int rowIdx=0; rowIdx < matrixVals.length; rowIdx++){
            if (rowIdx != pivotIdx){
                row = matrixVals[rowIdx];
                multiplier = -(row[i]/pivotRow[i]);

                for (int colIdx=rowIdx; colIdx < matrixVals.length; colIdx++){
                    row[colIdx] = multiplier * pivotRow[colIdx] + row[colIdx];
                }
            }
        }

        return matrixVals;
    }

    private static int getPivotIdx(double[][] matrixVals, int i, int[] maxVals){
        double maxPivotVal = -1;
        double tempPivotVal;
        int rowIdx = 0;
        int pivotIdx = -1;

        for (double[] row : matrixVals){
            tempPivotVal = row[i]/ maxVals[rowIdx];

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

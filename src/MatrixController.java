import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by mayalake on 3/11/19.
 */
public class MatrixController {

    public static void computeFinalVals(Matrix matrix){
        int rowIdx;
        int colIdx;
        Fraction b;

        Fraction[] finalAns = new Fraction[matrix.getNumRows()];

        Fraction[][] matrixVals = matrix.getCoefficients();
        int[] idxOrder = matrix.getIdxOrder();
        int bIdx = matrixVals.length;

        for (int i = idxOrder.length-1; i >= 0; i--){
            rowIdx = idxOrder[i];
            b = matrixVals[rowIdx][bIdx];

            colIdx = matrix.getNumRows()-1;

            while (colIdx > i){
                if (matrixVals[rowIdx][colIdx].numerator != 0 && matrixVals[rowIdx][colIdx].denominator != 0){
                    b = b.subtract(finalAns[colIdx].multiply(matrixVals[rowIdx][colIdx]));
                }
                colIdx--;
            }

            b = b.divide(matrixVals[rowIdx][colIdx]);

            finalAns[i] = b;
        }

        System.out.println(Arrays.toString(finalAns));
    }
}

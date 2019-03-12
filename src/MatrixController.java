import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by mayalake on 3/11/19.
 */
public class MatrixController {

    /*assume that matrix is in form matrixVals[row][col]:
    * W ..Y Z b
    * 0 ..Y Z b
    * .
    * .
    * 0 ..0 Z b
    *
    * final ans [W .. Y, Z]
    */
    public static void computeFinalVals(double[][] matrixVals){
        double b;
        int col;
        int finalAnsIdx;

        double[] finalAns = new double[matrixVals.length];
        int bIdx = matrixVals.length;

        Arrays.setAll(finalAns, i -> 0);

        for (int row=0; row < matrixVals.length; row++){
            b = matrixVals[row][bIdx];

            for (col= bIdx-1, finalAnsIdx =0; col >= 0 && col > bIdx-1-row; col--, finalAnsIdx++){
                b -= (finalAns[finalAnsIdx] * matrixVals[row][col]);
            }

            b = Math.round(b/matrixVals[row][col]);
            finalAns[row] = b;
        }

        System.out.println(Arrays.toString(finalAns));
    }
}

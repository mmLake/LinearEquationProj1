import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by mayalake on 3/10/19.
 */
public class Methods {

    public static void gaussElimPartialPivot(Matrix matrix) {
        List<Integer> availableIdx;
        int pivotIdx;

        int[] idxOrder = new int[matrix.getNumRows()];
        Fraction[][] matrixVals = matrix.getCoefficients();
        Fraction[] maxVals = new Fraction[matrix.getNumRows()];

        Arrays.setAll(maxVals, i -> new Fraction(Integer.MIN_VALUE, 1));
        availableIdx = IntStream.range(0, matrix.getNumRows()).boxed().collect(Collectors.toList());

        //find largest value in each row & populate maxVals
        int rowIdx = 0;
        Fraction val;

        for (Fraction[] row : matrixVals){
            for (int i=0; i < matrixVals.length; i++){
                val = row[i];

                if (val.absIsGreater(maxVals[rowIdx]))
                    maxVals[rowIdx] = val;
            }
            rowIdx++;
        }

        //run algorithm
        for (int i = 0; i < matrix.getNumRows(); i++) {
            //get pivot row
            pivotIdx = getPivotIdx(matrixVals, i, maxVals, availableIdx);
            availableIdx.remove((Integer) pivotIdx);
            idxOrder[i] = pivotIdx;

            System.out.println("pivot " + pivotIdx);

            //update matrix based on pivot
            matrixVals = updateMatrix(matrixVals, pivotIdx, i, availableIdx);

            for (int j=0; j< matrix.getNumRows(); j++){
                for (int k=0; k < matrix.getNumCols(); k++){
                    System.out.printf("%10s",matrixVals[j][k].toString());
                }
                System.out.println();
            }
            System.out.println();
        }

        matrix.setCoefficients(matrixVals);
        matrix.setIdxOrder(idxOrder);
    }

    private static Fraction[][] updateMatrix(Fraction[][] matrixVals, int pivotIdx, int i, List<Integer> availableIdx){
        Fraction multiplier;
        Fraction[] row;

        Fraction[] pivotRow = matrixVals[pivotIdx];

        for (int rowIdx=0; rowIdx < matrixVals.length; rowIdx++){
            if (availableIdx.contains(rowIdx)){
                row = matrixVals[rowIdx];
                multiplier = row[i].divide(pivotRow[i]).multiply(new Fraction(-1, 1));

                for (int colIdx=0; colIdx < matrixVals[0].length; colIdx++){
                    row[colIdx] = (multiplier.multiply(pivotRow[colIdx])).add(row[colIdx]);
                }
            }
        }

        return matrixVals;
    }

    private static int getPivotIdx(Fraction[][] matrixVals, int i, Fraction[] maxVals, List<Integer> availableIdx){
        Fraction maxPivotVal = new Fraction(1, 1000);
        Fraction tempPivotVal;
        int pivotIdx = -1;
        Fraction[] row;

        for (int idx : availableIdx){
            row = matrixVals[idx];

            tempPivotVal = row[i].divide(maxVals[idx]);

            if (tempPivotVal.absIsGreater(maxPivotVal)) {
                maxPivotVal = tempPivotVal;
                pivotIdx = idx;
            }
        }

        return pivotIdx;
    }

    public static void jacobiIterative(){

    }

    public static void gaussSeidel(){

    }
}

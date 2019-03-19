import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by mayalake on 3/18/19.
 */
public class ExtraCredit {
    private static final int INIT_ARRAY_SIZE = 25;
    private static final int NUM_ITERATIONS = 4;

    public static void run(){
        int arraySize = INIT_ARRAY_SIZE;

        Matrix matrix;
        Fraction[][] fracMatrixVals;
        double[][] matrixVals;
        double[][] matrixValsCopy;
        long timeSpent;
        int[] tempRandomArray;

        for (int i=0; i < NUM_ITERATIONS; i++){
            matrixVals = new double[arraySize][arraySize+1];
            matrixValsCopy = new double[arraySize][arraySize+1];
            fracMatrixVals = new Fraction[arraySize][arraySize+1];

            //instantiate array
            for (int row=0; row<arraySize; row++){
                tempRandomArray = ThreadLocalRandom.current().ints(0,100).limit(arraySize+1).toArray();
                matrixVals[row] = Arrays.stream(tempRandomArray).asDoubleStream().toArray();
            }

            //instantiate fraction array
            for (int row=0; row<arraySize; row++){
                for (int col=0; col<arraySize+1;col++){
                    fracMatrixVals[row][col] = new Fraction((int)matrixVals[row][col], 1);
                }
            }

            //instantiate matrix
            matrix = new Matrix(fracMatrixVals);


            //run jacobi
            for (int copyIdx=0; copyIdx < arraySize; copyIdx++)
                matrixValsCopy[copyIdx] = Arrays.copyOf(matrixVals[copyIdx], arraySize+1);

            timeSpent = System.nanoTime();
            Methods.jacobiIterative(matrixVals, 0.04);
//            Methods.jacobiIterative(View.readDoubleFile(new File("./src/input")), 0.04);
            timeSpent = System.nanoTime() - timeSpent;

            System.out.printf("JACOBI: Time in ns for array of size %d is %d\n", arraySize, timeSpent);

            //run gaus seidel
            timeSpent = System.nanoTime();
//            Methods.gaussSeidel(View.readDoubleFile(new File("./src/input")), 0.04);
            Methods.gaussSeidel(matrixVals, 0.04);
            timeSpent = System.nanoTime() - timeSpent;

            System.out.printf("GAUSS SEIDEL: Time in ns for array of size %d is %d\n", arraySize, timeSpent);

            //run gaus elim
            timeSpent = System.nanoTime();
            Methods.gaussElimPartialPivot(matrix);
            timeSpent = System.nanoTime() - timeSpent;

            System.out.printf("GAUSS ELIM: Time in ns for array of size %d is %d\n", arraySize, timeSpent);

            arraySize *=2;
        }

    }
}

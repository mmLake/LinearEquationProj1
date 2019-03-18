import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mayalake on 3/10/19.
 */
public class View {

    private static Scanner sc = new Scanner(System.in);

    public static double[][] readDoubleFile(File filename){
        FileReader fr;
        BufferedReader br;
        String val;
        String strRow[];
        ArrayList<Double> row;
        double[][] matrixVals;

        ArrayList<ArrayList<Double>> coefficients = new ArrayList<>();

        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);

            while ((val = br.readLine()) != null){
                row = new ArrayList<>();

                strRow = val.split(" ");
                for (String s : strRow){
                    row.add(Double.parseDouble(s));
                }

                coefficients.add(row);
            }

            matrixVals = new double[coefficients.size()][coefficients.get(0).size()];

            for (int rowIdx=0; rowIdx < matrixVals.length; rowIdx++){
                for (int colIdx = 0; colIdx < matrixVals[0].length; colIdx++){
                    matrixVals[rowIdx][colIdx] = coefficients.get(rowIdx).get(colIdx);
                }
            }

            return matrixVals;
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return null;

    }

    private static Matrix convertDoubleToFraction(double[][] matrix){
        Fraction[][] fracMatrix = new Fraction[matrix.length][matrix[0].length];

        for (int rowIdx=0; rowIdx < fracMatrix.length; rowIdx++){
            for (int colIdx = 0; colIdx < fracMatrix[0].length; colIdx++){
                fracMatrix[rowIdx][colIdx] = new Fraction((int)matrix[rowIdx][colIdx],1);
            }
        }

        return new Matrix(fracMatrix);
    }

    private static int getNumEq(){

        System.out.print("Enter the number of equations: ");
        while (!sc.hasNextInt()){
            System.out.printf("\nMust enter an integer value: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private static double[][] getCLInput(){
        int numEq;
        double[][] matrixVals;
        String val;
        String[] strRow;

        numEq = getNumEq();
        sc.nextLine();
        matrixVals =new double[numEq][numEq+1];

        System.out.println("Enter each row one line at a time. Row should have each integer or double separated by a space and include b val.");
        for (int rowIdx=0; rowIdx < numEq; rowIdx++){
            System.out.print("Enter row " + rowIdx);

            val = sc.nextLine();
            System.out.println(val);


            strRow = val.split(" ");
            for (int colIdx=0; colIdx < matrixVals[0].length; colIdx++){
                matrixVals[rowIdx][colIdx] = Double.parseDouble(strRow[colIdx]);
            }

            System.out.println();
        }

        return matrixVals;
    }

    private static File getFileName(){
        String filename;
        File file;


        System.out.println("Enter the file name and relative or absolute path to the file from where you are running the program");
        filename = sc.next();

        file = new File(filename);


        while (!file.canRead()){
            System.out.print("Unable to read file, enter filename again.");
            filename = sc.next();

            file = new File(filename);
            System.out.println();
        }

        return file;
    }

    private static int getError(){

        System.out.print("Enter the error value for Jacobi and Gaus-Seidel: ");
        while (!sc.hasNextInt()){
            System.out.printf("\nMust enter an integer value: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private static int getMenuOption(){
        int option = -1;
        boolean badOption = true;

        System.out.print("Enter the input option: ");
        while (badOption){
            if (!sc.hasNextInt()) {
                System.out.printf("\nMust enter an integer value: ");
                sc.next();
            } else if ((option =sc.nextInt()) < 1 || option > 3){
                System.out.printf("\nMust enter values between 1 and 3: ");
            } else{
                badOption = false;
            }
        }
        return option;
    }

    public static void menu(){
        int option = getMenuOption();
        int error = -1;

        switch (option){
            case 1:
                File f = getFileName();
                double[][] m = readDoubleFile(f);

                System.out.printf("\n*************************\n%s\n*************************\n","Gaus Elim Partial Pivot");
                Matrix mFraction = convertDoubleToFraction(m);
                Methods.gaussElimPartialPivot(mFraction);

                //get values needed for jacobi and gaus-seidel
                error = getError();

                System.out.printf("\n*************************\n%s\n*************************\n", "Jacobi Iterative");
                Methods.jacobiIterative(m, error);

                System.out.printf("\n*************************\n%s\n*************************\n", "Gaus-Seidel");
                Methods.gaussSeidel(m, error);

                break;
            case 2:
                double[][] m2 = getCLInput();

                System.out.printf("\n*************************\n%s\n*************************\n","Gaus Elim Partial Pivot");
                Matrix m2Fraction = convertDoubleToFraction(m2);
                Methods.gaussElimPartialPivot(m2Fraction);

                //get values needed for jacobi and gaus-seidel
                error = getError();

                System.out.printf("\n*************************\n%s\n*************************\n", "Jacobi Iterative");
                Methods.jacobiIterative(m2, error);

                System.out.printf("\n*************************\n%s\n*************************\n", "Gaus-Seidel");
                Methods.gaussSeidel(m2, error);

                break;
            case 3:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            case -1:
                System.out.println("ERROR READING MENU OPTION");
                break;
        }

        System.out.printf("\n\n");

    }

}

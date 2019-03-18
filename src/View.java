import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mayalake on 3/10/19.
 */
public class View {

    private static Scanner sc = new Scanner(System.in);

    public static double[][] readDoubleFile(){
        FileReader fr;
        BufferedReader br;
        String val;
        String strRow[];
        ArrayList<Double> row;
        double[][] matrixVals;

        ArrayList<ArrayList<Double>> coefficients = new ArrayList<>();

        try {
            fr = new FileReader("./src/input");
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

    public static Matrix readFile(){
        FileReader fr;
        BufferedReader br;
        String val;
        String strRow[];
        ArrayList<Integer> row;
        Fraction[][] matrixVals;

        ArrayList<ArrayList<Integer>> coefficients = new ArrayList<>();

        try {
            fr = new FileReader("./src/input");
            br = new BufferedReader(fr);

            while ((val = br.readLine()) != null){
                row = new ArrayList<>();

                strRow = val.split(" ");
                for (String s : strRow){
                    row.add(Integer.parseInt(s));
                }

                coefficients.add(row);
            }

            matrixVals = new Fraction[coefficients.size()][coefficients.get(0).size()];

            for (int rowIdx=0; rowIdx < matrixVals.length; rowIdx++){
                for (int colIdx = 0; colIdx < matrixVals[0].length; colIdx++){
                    matrixVals[rowIdx][colIdx] = new Fraction(coefficients.get(rowIdx).get(colIdx),1);
                }
            }

            return new Matrix(matrixVals);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    public void getCLInput(){
        int numEq;

        System.out.print("Enter the number of equations: ");
        while (!sc.hasNextInt()){
            System.out.printf("\nMust enter an integer value: ");
        }
        numEq = sc.nextInt();
    }

    public static void menu(){
        int option;

        System.out.print("Enter the input option: ");
        while (!sc.hasNextInt() || sc.nextInt() < 1 || sc.nextInt() > 3){
            System.out.printf("\nMust enter values between 1 and 3: ");
            sc.next();
        }
        option = sc.nextInt();

        switch (option){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }

    }

}

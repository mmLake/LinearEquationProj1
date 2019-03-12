import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mayalake on 3/10/19.
 */
public class View {

    public static Matrix readFile(){
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

            return new Matrix(matrixVals);

//            return new Matrix(coefficients.stream()
//                    .map(u -> u.toArray(new Double[0])).toArray(double[][]::new));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    public void getInput(){

    }

}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mayalake on 3/10/19.
 */
public class Controller {

    public Matrix readFile(){
        FileReader fr;
        BufferedReader br;
        String val;
        String strRow[];
        ArrayList<Integer> row;
        ArrayList<ArrayList<Integer>> coefficients = new ArrayList<>();

        try {
            fr = new FileReader("input");
            br = new BufferedReader(fr);

            while ((val = br.readLine()) != null){
                row = new ArrayList<>();

                strRow = val.split(" ");
                for (String s : strRow){
                    row.add(Integer.parseInt(s));
                }

                coefficients.add(row);
            }

            return new Matrix(coefficients);
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

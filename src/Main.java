public class Main {

    public static void main(String[] args) {
	// write your code here
        Matrix m = View.readFile();
        Methods.gaussElimPartialPivot(m);
        MatrixController.computeFinalVals(m.getCoefficients());
    }
}

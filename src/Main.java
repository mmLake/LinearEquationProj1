public class Main {

    public static void main(String[] args) {
//        menuOptions();
//        View.menu();


	// write your code here
        Matrix m = View.readFile();
        Methods.gaussElimPartialPivot(m);
        MatrixController.computeFinalVals(m);
    }

    private static void menuOptions(){
        System.out.printf("This program solves linear equation inputs using" +
                        "partial pivoting Gaussian elimination, Jacobi iterative method, and theGauss-Seidel method.\n" +
                        "Menu Options\n" +
                        "Enter 1 if the input is a file\n" +
                        "Enter 2 to input the matrix and its b values by command line\n"+
                        "Enter 3 to run the extra credit assignment, which will not print intermediate steps, and instead print runtime\n"
        );
    }


}

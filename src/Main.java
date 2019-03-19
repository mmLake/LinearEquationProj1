public class Main {

    public static void main(String[] args) {
        ExtraCredit.run();
//        menuOptions();
//        while (true)
//            View.menu();

    }

    private static void menuOptions(){
        System.out.printf("This program solves linear equation inputs using" +
                "partial pivoting Gaussian elimination, Jacobi iterative method, and theGauss-Seidel method.\n\n" +
                "Menu Options\n" +
                "Enter 1 if the input is a file\n" +
                "Enter 2 to input the matrix and its b values by command line\n"+
                "Enter 3 to quit the program\n"+
                "*************************************************\n\n"
        );
    }


}

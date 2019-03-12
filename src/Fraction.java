/**
* Created by mayalake on 3/11/19.
*/

public class Fraction {

    int numerator;
    int denominator;

    /**
     * Constructor
     *
     * @param numr
     * @param denr
     */
    public Fraction(int numr, int denr) {
        numerator = numr;
        denominator = denr;

        reduce();

        if (denominator < 0) {
            denominator *= -1;
            numerator *= -1;
        }
    }

    public int getNumerator() {
        return numerator;
    }


    public int getDenominator() {
        return denominator;
    }

    /**
     * Calculates gcd of two numbers
     *
     * @param numerator
     * @param denominator
     * @return
     */
    public int calculateGCD(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            return denominator;
        }
        return calculateGCD(denominator, numerator % denominator);
    }

    /**
     * Reduce the fraction to lowest form
     */
    void reduce() {
        int gcd = calculateGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    /**
     * Adds two fractions
     *
     * @param fractionTwo
     * @return
     */
    public Fraction add(Fraction fractionTwo) {
        int numer = (numerator * fractionTwo.getDenominator()) +
                (fractionTwo.getNumerator() * denominator);
        int denr = denominator * fractionTwo.getDenominator();
        return new Fraction(numer, denr);
    }

    /**
     * Subtracts two fractions
     *
     * @param fractionTwo
     * @return
     */
    public Fraction subtract(Fraction fractionTwo) {
        int newNumerator = (numerator * fractionTwo.denominator) -
                (fractionTwo.numerator * denominator);
        int newDenominator = denominator * fractionTwo.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Multiples two functions
     *
     * @param fractionTwo
     * @return
     */
    public Fraction multiply(Fraction fractionTwo) {
        int newNumerator = numerator * fractionTwo.numerator;
        int newDenominator = denominator * fractionTwo.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Divides two fractions
     *
     * @param fractionTwo
     * @return
     */
    public Fraction divide(Fraction fractionTwo) {
        int newNumerator = numerator * fractionTwo.getDenominator();
        int newDenominator = denominator * fractionTwo.numerator;

        return new Fraction(newNumerator, newDenominator);
    }

    public boolean isGreater(Fraction fractionTwo){
        //equal values
        if (this.numerator * fractionTwo.denominator == this.denominator * fractionTwo.numerator)
            return false;
        //greater than
        if (this.numerator * fractionTwo.denominator > this.denominator * fractionTwo.numerator)
            return true;
        else
            return false;
    }

    public boolean absIsGreater(Fraction fractionTwo){
        //greater than
        return (Math.abs(this.numerator) * fractionTwo.denominator > this.denominator * Math.abs(fractionTwo.numerator));
    }

    /**
     * Returns string representation of the fraction
     */
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}


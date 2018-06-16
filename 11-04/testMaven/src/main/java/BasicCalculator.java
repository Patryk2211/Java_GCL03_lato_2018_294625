import static java.lang.Math.*;

public class BasicCalculator {

    public double calculateSum(double a, double b) {

        return a + b;
    }


    public double calculateDifference(double a, double b) {

        return  a - b;
    }

    public double calculateMultiplication(double a, double b) {
        double multiplication = a * b;
        return multiplication;

    }

    public double calculateDivision(double a, double b) {

            if (b == 0) throw new IllegalArgumentException("Dzielenie przez zero!");



        return  a / b;
    }

    public double calculatePow(double a, double power) {



        return pow(a, power);

    }

    public double calculateSqrt(double a) {

            if (a < 0) throw new IllegalArgumentException("Ujemna wartosc podczas pierwiastkowania!");

        return sqrt(a);
    }

}
/*



        3. W przypadku podania niepoprawnych wartości dla metody, trzeba rzucać wyjątek
        java.lang.IllegalArgumentException (np. dzielenie przez zero, promień równy lub mniejszy od zera, ujemna
        wartość podczas pierwiastkowania, itp.).
        */
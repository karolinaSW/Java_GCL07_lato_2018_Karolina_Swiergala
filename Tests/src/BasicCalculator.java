import java.lang.Math.*;

public class BasicCalculator {
    protected double result;

    double getResult(){
        return result;
    }

    double calculateSum(double a, double b){

        result = a + b;
        return result;
    }
    double calculateDifference(double a, double b){

        result = a - b;
        return result;
    }
    double calculateMultiplication(double a, double b){

        result = a * b;
        return result;
    }
    double calculateDivision(double a, double b){

        result = a / b;
        return result;
    }
    double calculatePow(double a, double b){

        result = Math.pow(a, b);
        return result;
    }
    double calculateSqrt(double a, double b){

        result = Math.pow(a, (1.0/b));
        return result;
    }
}

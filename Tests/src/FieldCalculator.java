public class FieldCalculator {
    protected double result;

    double getResult(){
        return result;
    }


    public double calculateSquare(double side){

        result = side * side;
        return result;
    }
    public double calculateCircle(double radius){

        result = Math.pow(radius, 2) * Math.PI;
        return result;
    }
    public double calculateTriangle(double basis, double height){

        result = 0.5 * basis * height;
        return result;
    }
    public double calculateRectangle(double a, double b){

        result = a * b;
        return result;
    }
}

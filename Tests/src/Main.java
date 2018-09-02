import java.util.Scanner;
import java.lang.IllegalArgumentException;


public class Main {
    public static void main(String[] args) throws IllegalArgumentException {

        char calculate = 'y';

        while (calculate == 'y') {

            System.out.println("\nNormal calculator or field calculator? Chose a number: \n");
            System.out.println("1\t-\tNormal \n2\t-\tField\n");
            int choice1 = 0;
            Scanner stream = new Scanner(System.in);
            choice1 = stream.nextInt();

            switch (choice1) {
                case 1: {

                    System.out.println("Which operation? Chose a number: \n");
                    System.out.println("1\t-\tAddition \n2\t-\tSubtraction \n3\t-\tMultiplication \n4\t-\tDivision\n5\t-\tPower\n6\t-\tRoot");
                    int choice2;
                    choice2 = stream.nextInt();
                    BasicCalculator bc = new BasicCalculator();

                    double element1;
                    double element2;

                    switch (choice2) {
                        case 1: {
                            System.out.println("Give element 1: ");
                            element1 = stream.nextDouble();
                            System.out.println("Give element 2: ");
                            element2 = stream.nextDouble();

                            System.out.println("The result is:\t" + bc.calculateSum(element1, element2));


                            break;
                        }
                        case 2: {

                            System.out.println("Give minuend: ");  // minuend - odjemna
                            element1 = stream.nextDouble();
                            System.out.println("Give subtrahend: ");  // subtrahend - odjemnik
                            element2 = stream.nextDouble();

                            System.out.println("The result is:\t" + bc.calculateDifference(element1, element2));

                            break;
                        }
                        case 3: {

                            System.out.println("Give factor 1: ");
                            element1 = stream.nextDouble();
                            System.out.println("Give factor 2: ");
                            element2 = stream.nextDouble();

                            System.out.println("The result is:\t" + bc.calculateMultiplication(element1, element2));

                            break;
                        }
                        case 4: {

                            System.out.println("Give divident: ");  // divident - dzielna
                            element1 = stream.nextDouble();
                            System.out.println("Give divisor: ");  // divisor - dzielnik
                            element2 = stream.nextDouble();

                            if(element2 == 0)
                                throw new IllegalArgumentException("Dividing by ZERO is illegal!");

                            System.out.println("The result is:\t" + bc.calculateDivision(element1, element2));

                            break;
                        }
                        case 5: {

                            System.out.println("Give base: ");
                            element1 = stream.nextDouble();
                            System.out.println("Give exponent: ");  // exponent - wykladnik
                            element2 = stream.nextDouble();

                            System.out.println("The result is:\t" + bc.calculatePow(element1, element2));

                            break;
                        }
                        case 6: {

                            System.out.println("Give element to root: ");
                            element1 = stream.nextDouble();

                            if(element1 < 0)
                                throw new IllegalArgumentException("Rooting a number lesser than ZERO i illegal!");

                            System.out.println("Give index of rooting: ");  // stopien pierwiastka
                            element2 = stream.nextDouble();

                            System.out.println("The result is:\t" + bc.calculateSqrt(element1, element2));

                            break;
                        }
                    }

                    break;
                }
                case 2: {

                    System.out.println("Field of which geometrical figure to calculate? Chose a number: \n");
                    System.out.println("1\t-\tSquare \n2\t-\tCircle \n3\t-\tTriangle \n4\t-\tRectangle");
                    int choice2;
                    choice2 = stream.nextInt();

                    double element1;
                    double element2;

                    FieldCalculator fc = new FieldCalculator();

                    switch (choice2) {

                        case 1: {
                            System.out.println("Give a side length: ");
                            element1 = stream.nextDouble();

                            if(element1 <= 0)
                                throw new IllegalArgumentException("Cannot calculate field of figure with parameter lesser or equal 0.");
                            System.out.println("The result is:\t" + fc.calculateSquare(element1));


                            break;
                        }
                        case 2: {

                            System.out.println("Give radius: ");
                            element1 = stream.nextDouble();
                            if(element1 <= 0)
                                throw new IllegalArgumentException("Cannot calculate field of figure with parameter lesser or equal 0.");

                            System.out.println("The result is:\t" + fc.calculateCircle(element1));

                            break;
                        }
                        case 3: {

                            System.out.println("Give basis of the triangle ");
                            element1 = stream.nextDouble();
                            System.out.println("Give height: ");
                            element2 = stream.nextDouble();

                            if(element1 <= 0 || element2 <=0)
                                throw new IllegalArgumentException("Cannot calculate field of figure with parameter lesser or equal 0.");

                            System.out.println("The result is:\t" + fc.calculateTriangle(element1, element2));

                            break;
                        }
                        case 4: {

                            System.out.println("Give side 1: ");
                            element1 = stream.nextDouble();
                            System.out.println("Give side 2: ");
                            element2 = stream.nextDouble();

                            if(element1 <= 0 || element2 <=0)
                                throw new IllegalArgumentException("Cannot calculate field of figure with parameter lesser or equal 0.");

                            System.out.println("The result is:\t" + fc.calculateRectangle(element1, element2));

                            break;
                        }

                    }

                    break;
                }
            }
            System.out.println("Calculate once again? 'y' - yes, 'n' - no: ");
            calculate = stream.next().charAt(0);  // getting one char

        }


    }
}


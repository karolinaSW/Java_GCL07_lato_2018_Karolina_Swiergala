import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;


class BasicCalculatorTest {

    private BasicCalculator bcTest;  // making an instance


    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception{
        System.out.println("set up");
        this.bcTest = new BasicCalculator();
        System.out.flush();
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception{
        System.out.println("tear down");
        bcTest = null;
        System.out.flush();
    }


    @org.junit.jupiter.api.Test
    public void calculateSum_positiveNumbers() {
        bcTest.calculateSum(2.0, 2.5);
        assertEquals(4.5, bcTest.getResult());    // Zapytać o metodę z komentarzem w pierwszym argumencie

        bcTest.calculateSum(33.555, 21.223);
        assertEquals(54.778, bcTest.getResult());
    }

    @org.junit.jupiter.api.Test
    public void calculateSum_negativeNumbers() {
        bcTest.calculateSum(-2.5, 4.0);
        assertEquals(1.5, bcTest.getResult());
    }


    @org.junit.jupiter.api.Test
    public void calculateDifference_positiveNumbers() {
        bcTest.calculateDifference(2.0, 2.5);
        assertEquals(-0.5, bcTest.getResult());

        bcTest.calculateDifference(33.555, 21.223);
        assertEquals(12.332, bcTest.getResult());

        bcTest.calculateDifference(4.0, -2.0);
        assertEquals(6.0, bcTest.getResult());
    }

    @org.junit.jupiter.api.Test
    public void calculateDifference_negativeNumber() {

        bcTest.calculateDifference(4.0, -2.0);
        assertEquals(6.0, bcTest.getResult());
    }

    @org.junit.jupiter.api.Test
    public void calculateMultiplication_positiveNumber() {
        bcTest.calculateMultiplication(2.0, 2.5);
        assertEquals(5.0, bcTest.getResult());

    }

    @org.junit.jupiter.api.Test
    public void calculateMultiplication_negativeNumber() {

        bcTest.calculateMultiplication(-3.5, 2);
        assertEquals(-7, bcTest.getResult());

    }

    @org.junit.jupiter.api.Test
    public void calculateMultiplication_zero() {

        bcTest.calculateMultiplication(4.0, 0);
        assertEquals(0, bcTest.getResult());
    }

    @org.junit.jupiter.api.Test
    public void calculateDivision_bothPositive() {
        bcTest.calculateDivision(10, 2.5);
        assertEquals(4.0, bcTest.getResult());

    }

    @org.junit.jupiter.api.Test
    public void calculateDivision_negativeNumber() {

        bcTest.calculateDivision(-44, 2);
        assertEquals(-22, bcTest.getResult());

    }

    @org.junit.jupiter.api.Test
    public void calculateDivision_bothNegative() {

        bcTest.calculateDivision(-4.0, -2.0);
        assertEquals(2.0, bcTest.getResult());

    }
    @org.junit.jupiter.api.Test(expected = ArithmeticException.class)
    public void calculateDivision_byZero() {

        bcTest.calculateDivision(4.0, 0);
    }


    @org.junit.jupiter.api.Test
    public void calculatePow() {
        bcTest.calculatePow(2,4);
        assertEquals(16, bcTest.getResult());
    }

    @org.junit.jupiter.api.Test(expected = ArithmeticException.class)
    public void calculateSqrt() {

        bcTest.calculateSqrt(-4.0, 2);
    }
}
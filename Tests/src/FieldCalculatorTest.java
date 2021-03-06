import static org.junit.jupiter.api.Assertions.*;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import java.util.Collection;
import java.util.Collections;


class FieldCalculatorTest {

    private FieldCalculator fcTest;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception{
        System.out.println("set up");
        this.fcTest = new FieldCalculator();
        System.out.flush();
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception{
        System.out.println("tear down");
        fcTest = null;
        System.out.flush();
    }

    @org.junit.jupiter.api.Test
    public void calculateSquare_positiveNumber() {

        fcTest.calculateSquare(2.0);
        assertEquals(4.0, fcTest.getResult());
    }




    @org.junit.jupiter.api.Test(expected = IllegalArgumentException.class)
    public void calculateSquare_negativeNumber() {
        fcTest.calculateSquare(-2.0);
    }

    @org.junit.jupiter.api.Test(expected = IllegalArgumentException.class)
    public void calculateSquare_zero() {
        fcTest.calculateSquare(0.0);
    }

    @org.junit.jupiter.api.Test
    public void calculateCircle_positiveNumber() {
        fcTest.calculateSquare(1.0);
        assertEquals(Math.PI, fcTest.getResult());
    }

    @org.junit.jupiter.api.Test(expected = IllegalArgumentException.class)
    public void calculateCircle_negativeNumber() {
        fcTest.calculateCircle(-2.0);
    }

    @org.junit.jupiter.api.Test(expected = IllegalArgumentException.class)
    public void calculateCircle_zero() {
        fcTest.calculateCircle(0.0);
    }

    @org.junit.jupiter.api.Test
    public void calculateTriangle_positiveNumber() {
        fcTest.calculateTriangle(2.0, 6.0);
        assertEquals(6.0, fcTest.getResult());
    }

    @org.junit.jupiter.api.Test(expected = IllegalArgumentException.class)
    public void calculateTriangle_negativeNumber() {
        fcTest.calculateTriangle(-2.0, 2);
    }

    @org.junit.jupiter.api.Test(expected = IllegalArgumentException.class)
    public void calculateTriangle_zero() {
        fcTest.calculateTriangle(0.0, 2);
    }

    @org.junit.jupiter.api.Test
    public void calculateRectangle_positiveNumber() {
        fcTest.calculateRectangle(2.0, 6.0);
        assertEquals(12.0, fcTest.getResult());
    }

    @org.junit.jupiter.api.Test(expected = IllegalArgumentException.class)
    public void calculateRectangle_negativeNumber() {
        fcTest.calculateRectangle(-2.0, 2);
    }

    @org.junit.jupiter.api.Test(expected = IllegalArgumentException.class)
    public void calculateRectangle_zero() {
        fcTest.calculateRectangle(0.0, 2);
    }

}
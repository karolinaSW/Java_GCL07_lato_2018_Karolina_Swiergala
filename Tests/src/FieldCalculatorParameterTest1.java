import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class FieldCalculatorParameterTest1 {

    FieldCalculator fc = new FieldCalculator();

    @Parametrized.Parameters
    public static Collection<Object[]> dataSquare() {
        return Arrays.asList(new Object[][] {
                {2 , 4},
                {4, 16},
                {6, 36}
        });
    }

    @Parameterized.Parameter
    public double SquareInput;

    @Parametrized.Parameter(1)
    public double SquareExpect;

    @Parametrized.Parameters
    public static Collection<Object[]> dataTriangle() {
        return Arrays.asList(new Object[][] {
                {2 , 4, 4},
                {4, 4, 8},
                {6, 3, 9}
        });
    }

    @Parameterized.Parameter
    public double triangleInput1;

    @Parameterized.Parameter(1)
    public double triangleInput2;

    @Parametrized.Parameter(2)
    public double triangleExpect;





    @Test
    public void testSquare() {
        assertEquals(SquareExpect, fc.calculateSquare(SquareInput) );
    }

    @Test
    public void testTriangle() {
        assertEquals(triangleExpect, fc.calculateTriangle(triangleInput1, triangleInput2) );
    }



}
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import java.util.Collection;

@org.junit.jupiter.api.RunWith(Parametrized.class)
class FieldCalculatorParameterTest {

    FieldCalculator fc = new FieldCalculator();

    @Parametrized.Parameters
        public static Collection <Object[]> data() {
            return Arrays.asList(new Object[][] {
                    {2 , 4},
                    {4, 16},
                    {6, 36}
            });
        }

        @Parameterized.Parameter
        public double Cinput;

        @Parametrized.Parameter(1)
        public double Cexpect;




    @Test
    public void test() {
        assertEquals(Cexpect, fc.calculateSquare(Cinput) );
    }


}
import java.util.Arrays;
import java.util.Collection;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParamBasicCalculatorTest{
    private double inputNumber, inputNumber2, inputExpected;
    private BasicCalculator classUnderTest;

    @Before
    public void initialize() {
        classUnderTest=new BasicCalculator();
        System.out.println("Początek testu");
    }
    public  ParamBasicCalculatorTest(double inputNumber, double inputNumber2, double inputExpected){
        this.inputNumber = inputNumber;
        this.inputNumber2 = inputNumber2;
        this.inputExpected = inputExpected;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers(){
        return Arrays.asList(new Object[][]{
                {99,1,100},
                {0,0,0},
                {5,5,10},
                {23,0,23},
                {2,1,3}
        });
    }

    @Test
    public void testSumParametrized(){
        assertEquals(inputExpected,classUnderTest.calculateSum(inputNumber,inputNumber2),0);
    }

    @After
    public void test(){
        System.out.println("Koniec testu");
    }
}
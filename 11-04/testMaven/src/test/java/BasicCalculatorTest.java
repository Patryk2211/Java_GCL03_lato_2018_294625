import org.junit.*;
import sun.awt.geom.AreaOp;

import static org.junit.Assert.*;

public class BasicCalculatorTest {
    static BasicCalculator kalkulator;

    @BeforeClass
    public static void myTestSetUp()
    {
        kalkulator = new BasicCalculator();
    }

    @Before
    public void start() {
        System.out.println("Poczatek testu");
    }

    @After
    public void test(){
        System.out.println("Koniec testu");
    }

    @Test
    public void calculateSum() {
        double t1 = kalkulator.calculateSum(4, 2);
        assertEquals(6, t1, 0);
        double t2 = kalkulator.calculateSum(0, 100);
        assertEquals(100, t2, 0);
        double t3 = kalkulator.calculateSum(0, 0);
        assertEquals(0, t3, 0);
    }


    @Test
    public void calculateDifference() {
        double t1 = kalkulator.calculateDifference(4, 2);
        assertEquals(2, t1, 0);
        double t2 = kalkulator.calculateDifference(0, 100);
        assertEquals(-100, t2, 0);
        double t3 = kalkulator.calculateDifference(0, 0);
        assertEquals(0, t3, 0);
    }


    @Test
    public void calculateMultiplication() {
        double t1 = kalkulator.calculateMultiplication(4, 2);
        assertEquals(8, t1, 0);
        double t2 = kalkulator.calculateMultiplication(0, 100);
        assertEquals(0, t2, 0);
        double t3 = kalkulator.calculateMultiplication(0, 0);
        assertEquals(0, t3, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateDivision() {
        double t3 = kalkulator.calculateDivision(10, 0);
    }

    @Test
    public void calculatePow() {
        double t1 = kalkulator.calculatePow(2, 2);
        assertEquals(4, t1, 0);
        double t2 = kalkulator.calculatePow(10, 2);
        assertEquals(100, t2, 0);
        double t3 = kalkulator.calculatePow(10, 1);
        assertEquals(10, t3, 0);
    }

    @Test
    public void calculateSqrt() {
        double t1 = kalkulator.calculateSqrt(4);
        assertEquals(2, t1, 0);
        double t2 = kalkulator.calculateSqrt(100);
        assertEquals(10, t2, 0);
        double t3 = kalkulator.calculateSqrt(16);
        assertEquals(4, t3, 0);
    }


}
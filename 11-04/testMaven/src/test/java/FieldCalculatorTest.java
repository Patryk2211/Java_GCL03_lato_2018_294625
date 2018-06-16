import org.junit.*;

import static org.junit.Assert.*;

public class FieldCalculatorTest {
    static FieldCalculator kalkulator1;

    @BeforeClass
    public static void myTestSetUp() {
        kalkulator1 = new FieldCalculator();
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
    public void calculateSquare() {
        double t1 = kalkulator1.calculateSquare(4);
        assertEquals(16, t1, 0);
        double t2 = kalkulator1.calculateSquare(10);
        assertEquals(100, t2, 0);
        double t3 = kalkulator1.calculateSquare(2);
        assertEquals(4, t3, 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculateCircle(){
        double t1 = kalkulator1.calculateCircle(0);
        assertEquals(0, t1, 0);
        double t2 = kalkulator1.calculateCircle(10);
        assertEquals(314, t2, 0);
        double t3 = kalkulator1.calculateCircle(50);
        assertEquals(7850, t3, 0);
    }

    @Test
    public void calculateTriangle() {
        double t1 = kalkulator1.calculateTriangle(4,2);
        assertEquals(4, t1, 0);
        double t2 = kalkulator1.calculateTriangle(10,1);
        assertEquals(5, t2, 0);
        double t3 = kalkulator1.calculateTriangle(2,2);
        assertEquals(2, t3, 0);
    }

    @Test
    public void calculateRectangle() {
        double t1 = kalkulator1.calculateRectangle(10,2);
        assertEquals(20, t1, 0);
        double t2 = kalkulator1.calculateRectangle(10,1);
        assertEquals(10, t2, 0);
        double t3 = kalkulator1.calculateRectangle(2,22);
        assertEquals(44, t3, 0);
    }
}
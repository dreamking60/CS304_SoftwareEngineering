import example.util.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void addtion1() {
        assertEquals(2, calculator.add(1,1));
    }

    @Test
    void addtion2() {
        assertEquals(3, calculator.add(1,2));
    }

    @Test
    void addtion3() {
        assertEquals(-2, calculator.add(-1,-1));
    }

    @Test
    void addtion4() {
        assertTrue(calculator.add(1,2)==3, "1+2!=3");
    }

    @Test
    void testRef1(){
        String a = "aaa";
        String b = new String("aaa");

        assertEquals(a,b);
    }

    @Test
   void testRef2(){
        String a = "aaa";
        String b = "aaa";

        assertSame(a,b);
    }
}

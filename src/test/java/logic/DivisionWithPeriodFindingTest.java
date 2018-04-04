package logic;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionWithPeriodFindingTest {
    private DivisionWithPeriodFinding integerDivision = new DivisionWithPeriodFinding();

    @Test
    public void notNullTest(){
        integerDivision.longDivision(345, 45);
    }
    @Test(expected = ArithmeticException.class)
    public void divisionByZeroTest(){
        integerDivision.longDivision(234, 0);
    }
    @Test
    public void correctAnswerTest(){
        int expected = 205;
        assertEquals(expected, integerDivision.longDivision(6563, 32));
    }
}

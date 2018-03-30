package logic;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerDivisionTest {
    private IntegerDivision integerDivision = new IntegerDivision();

    @Test
    public void notNullTest(){
        integerDivision.longDivision(345, 45);
    }
    @Test(expected = ArithmeticException.class)
    public void divisionByZeroTest(){
        integerDivision.longDivision(234, 0);
    }
}

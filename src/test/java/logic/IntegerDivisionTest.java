package logic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerDivisionTest {

    IntegerDivision integerDivision = new IntegerDivision();

    @Test
    public void notNullTest(){
        assertNotNull(integerDivision);
    }
    @Test(expected = ArithmeticException.class)
    public void divisionByZeroTest(){
        integerDivision.longDivision(45, 0);
    }
    @Test
    public void correctDivisionTest(){
        int expected = 9;
        int actual = integerDivision.longDivision(25, 5);
        assertEquals(expected,actual);
    }
}

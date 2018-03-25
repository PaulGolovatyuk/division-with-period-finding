package logic;


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
        int expected = 25;
        int actual = integerDivision.longDivision(336, 13);
        assertEquals(expected,actual);
    }
}

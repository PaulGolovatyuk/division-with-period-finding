package logic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerDivisionTest {
    IntegerDivision integerDivision = new IntegerDivision();
    @Before
    public void init(){
        integerDivision.init();
    }
    @Test
    public void notNullTest(){
        assertNotNull(integerDivision);
    }
    @Test
    public void correctDivisionResultTest(){
        assertTrue(integerDivision.getQuotient()==19736);
    }
    @Test(expected = ArithmeticException.class)
    public void divisionByZeroTest(){
        IntegerDivision integerDivision = new IntegerDivision();
        integerDivision.init();
        integerDivision.longDivision(25, 5);
    }
}

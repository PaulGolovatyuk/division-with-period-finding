package logic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerDivisionTest {
    IntegerDivision integerDivision = new IntegerDivision(78945, 4);
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
        IntegerDivision integerDivision = new IntegerDivision(789, 0);
        integerDivision.init();
        integerDivision.longDivision();
    }
}

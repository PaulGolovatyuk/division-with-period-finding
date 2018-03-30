package logic;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerDivisionTest {
    IntegerDivision integerDivision = new IntegerDivision();

    @Test
    public void notNullTest(){
        assertNotNull(integerDivision.longDivision(345, 45));
    }
}

package view;
import logic.IntegerDivision;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShowResultTest {
    private ShowResult showResult = new ShowResult();
    private IntegerDivision integerDivision = new IntegerDivision();

    @Test
    public void createInstanceTest(){

        assertNotNull(showResult);
    }
    @Test(expected = NullPointerException.class)
    public void nullPointerExTest(){
        integerDivision = null;
        showResult.resultBuilder();
    }

}

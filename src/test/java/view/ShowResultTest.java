package view;

import logic.DivisionWithPeriodFinding;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShowResultTest {
    private DivisionWithPeriodFinding integerDivision = new DivisionWithPeriodFinding();
    private ShowResult showResult = new ShowResult();

    @Test
    public void dividendLessThanDivisorTest(){
            String expected = "_7 |12\n"+
                              " 60|-------\n"+
                              " --|0.58(3)\n"+
                              "_100\n"+
                              "  96\n"+
                              "  --\n"+
                              "  _40\n"+
                              "   36\n"+
                              "   --\n"+
                              "    4";

            assertEquals(expected, showResult.buildOutputStringOfDivision(integerDivision, 7, 12));
    }
    @Test
    public void periodDecimalWithNonPeriodPartInQuotientTest(){
            String expected =   "_7 |12\n"+
                                " 60|-------\n"+
                                " --|0.58(3)\n"+
                                "_100\n"+
                                "  96\n"+
                                "  --\n"+
                                "  _40\n"+
                                "   36\n"+
                                "   --\n"+
                                "    4";
        assertEquals(expected, showResult.buildOutputStringOfDivision(integerDivision, 7, 12));
    }
    @Test
    public void periodicDecimalInQuotientTest(){
            String expected = "_25 |39\n"+
                              " 234|----------\n"+
                              " ---|0.(641025)\n"+
                              " _160\n"+
                              "  156\n"+
                              "  ---\n"+
                              "   _40\n"+
                              "    39\n"+
                              "    --\n"+
                              "    _100\n"+
                              "      78\n"+
                              "      --\n"+
                              "     _220\n"+
                              "      195\n"+
                              "      ---\n"+
                              "       25";
            assertEquals(expected, showResult.buildOutputStringOfDivision(integerDivision,25, 39));
    }

    @Test
    public void dividendWithZerosTest(){
            String expected =   "_500000|3\n"+
                                " 3     |----------\n"+
                                " -     |166666.(6)\n"+
                                "_20\n"+
                                " 18\n"+
                                " --\n"+
                                " _20\n"+
                                "  18\n"+
                                "  --\n"+
                                "  _20\n"+
                                "   18\n"+
                                "   --\n"+
                                "   _20\n"+
                                "    18\n"+
                                "    --\n"+
                                "    _20\n"+
                                "     18\n"+
                                "     --\n"+
                                "     _20\n"+
                                "      18\n"+
                                "      --\n"+
                                "       2";
        assertEquals(expected, showResult.buildOutputStringOfDivision(integerDivision, 500000, 3));
    }


    @Test
    public void dividendIsZeroTest(){
        String expected =   "0|"+1028+"\n"+
                            " |----\n"+
                            " |0";
        assertEquals(expected, showResult.buildOutputStringOfDivision(integerDivision, 0, 1028));
    }
    @Test (expected = ArithmeticException.class)
    public void divisorIsZeroTest(){
        showResult.buildOutputStringOfDivision(integerDivision, 78949, 0);
    }

}

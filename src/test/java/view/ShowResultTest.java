package view;

import logic.IntegerDivision;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShowResultTest {
    private IntegerDivision integerDivision = new IntegerDivision();
    private ShowResult showResult = new ShowResult();

    @Test
    public void outputResultTest0(){
            String expected =   "_1034|15"+"\n"+
                                "  90 |--"+"\n"+
                                "  -- |68"+"\n"+
                                " _134"+"\n"+
                                "  120"+"\n"+
                                "  ---"+"\n"+
                                "   14";
        assertEquals(expected, showResult.resultBuilder(integerDivision, 1034, 15));
    }
    @Test
    public void outputResultTest1(){
            String expected =   "_500000|3"+"\n"+
                                " 3     |------"+"\n"+
                                " -     |166666"+"\n"+
                                "_20    "+"\n"+
                                " 18    "+"\n"+
                                " --    "+"\n"+
                                " _20   "+"\n"+
                                "  18   "+"\n"+
                                "  --   "+"\n"+
                                "  _20  "+"\n"+
                                "   18  "+"\n"+
                                "   --  "+"\n"+
                                "   _20 "+"\n"+
                                "    18 "+"\n"+
                                "    -- "+"\n"+
                                "    _20"+"\n"+
                                "     18"+"\n"+
                                "     --"+"\n"+
                                "      2";
        assertEquals(expected, showResult.resultBuilder(integerDivision, 500000, 3));
    }
    @Test
    public void outputResultTest2(){
            String expected =   "_6606|6"+"\n"+
                                " 6   |----"+"\n"+
                                " -   |1101"+"\n"+
                                " _6  "+"\n"+
                                "  6  "+"\n"+
                                "  -  "+"\n"+
                                "   _6"+"\n"+
                                "    6"+"\n"+
                                "    -"+"\n"+
                                "    0";
        assertEquals(expected, showResult.resultBuilder(integerDivision, 6606, 6));
    }

    @Test
    public void dividendIsNegativeTest(){
        String expected ="_-475|13"+"\n"+
                        "  39 |--"+"\n"+
                        "  -- |-36"+"\n"+
                        "  _85"+"\n"+
                        "   78"+"\n"+
                        "   --"+"\n"+
                        "    7";
        assertEquals(expected, showResult.resultBuilder(integerDivision, -475, 13));
    }

    @Test
    public void divisorIsNegativeTest(){
        String expected =   "_4984|-27"+"\n"+
                            " 27  |---"+"\n"+
                            " --  |-184"+"\n"+
                            "_228 "+"\n"+
                            " 216 "+"\n"+
                            " --- "+"\n"+
                            " _124"+"\n"+
                            "  108"+"\n"+
                            "  ---"+"\n"+
                            "   16";
        assertEquals(expected, showResult.resultBuilder(integerDivision, 4984, -27));
    }
    @Test
    public void dividendIsZeroTest(){
        String expected =   "0|1028"+"\n"+
                            " |----"+"\n"+
                            " |0";
        assertEquals(expected, showResult.resultBuilder(integerDivision, 0, 1028));
    }
    @Test (expected = ArithmeticException.class)
    public void divisorIsZeroTest(){
        showResult.resultBuilder(integerDivision, 78949, 0);
    }

}

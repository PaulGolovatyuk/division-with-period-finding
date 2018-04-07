package logic;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DivisionWithPeriodFinding {
    private int dividend;
    private int divisor;
    private int remainder;
    private int actualQuotient;
    private int subDividend;
    private int partOfQuotient;
    private int subtrahend;
    private int indivisibleRemainder;
    private int indivisibleRemainderLength;
    private int firstSubdividend;
    private int firstSubtrahend;
    private int lastDividendBeforeComma;
    private int lastSubtrahendBeforeComma;

    private boolean isDividendIsNegative;
    private boolean isDivisorIsNegative;

    private List<Integer> dividendList;
    private List<Integer> actualQuotientList;


    public int longDivision(int aDividend, int aDivisor) {
        boolean firstSubDivAssigned = false;
        boolean firstSubtrahendAssigned = false;
        this.dividend = aDividend;
        this.divisor = aDivisor;

        if (aDividend < 0) {
            isDividendIsNegative = true;
            dividend *= -1;
        }
        if (aDivisor < 0) {
            isDivisorIsNegative = true;
            divisor *= -1;
        }

        //init block
        indivisibleRemainder = dividend % divisor;
        Integer indivRem = indivisibleRemainder;
        indivisibleRemainderLength = indivRem.toString().length();
        actualQuotient = dividend / divisor;
        dividendList = fromIntToList(dividend);
        actualQuotientList = fromIntToList(actualQuotient);
        firstSubdividend = 0;
        firstSubtrahend = 0;


        //calculations
        subDividend = 0;
        boolean integerPartIsCalculated = false;
        for (int i = 0; i <dividendList.size() ; ) {
            if (subDividend < divisor) {
                subDividend = subDividend * 10 + dividendList.get(i);
            }
            if (subDividend / divisor > 0 && !firstSubDivAssigned) {
                firstSubdividend = subDividend;
                firstSubDivAssigned = true;
            }
            partOfQuotient = subDividend / divisor;

            remainder = subDividend % divisor;
            subtrahend = partOfQuotient * divisor;
            if (subDividend / divisor > 0 && !firstSubtrahendAssigned) {
                if (!integerPartIsCalculated) {
                    firstSubtrahend = subtrahend;
                }
                firstSubtrahendAssigned = true;
            }
            subDividend = remainder;
            //////////////////////////////////////////////////
            i++;
            if (i == dividendList.size()-1){
                integerPartIsCalculated = true;
                lastDividendBeforeComma = subDividend;
                lastSubtrahendBeforeComma = subtrahend;
            }
            if (indivisibleRemainder != 0&&integerPartIsCalculated) {
                while (indivisibleRemainder / divisor == 0) {
                    indivisibleRemainder *= 10;
                    dividendList.add(0);
                }
                subDividend = indivisibleRemainder;
            }
        }


        return  dividend/divisor;
    }

    public String findingPeriod(int aDividend, int aDivisor){
        String result = null;
        double doubleDividend = (double) aDividend;
        double doubleDivisor = (double) aDivisor;
        double doubleResult = doubleDividend/doubleDivisor;
        int quotient = aDividend/aDivisor;
        int quotientLength = Integer.toString(quotient).length();
        char[] tenDigitsAfterCommaArray = new char[10];;
        String digitsAfterCommaString;
        String doubleResultString = doubleResult+"";
        String digitsAfterCommaStr = doubleResultString.substring(quotientLength+1);
        char [] digitsAfterCommaCharsArray = digitsAfterCommaStr.toCharArray();
        if (digitsAfterCommaCharsArray.length>11) {
            for (int i = 0; i < 10; i++) {
                tenDigitsAfterCommaArray[i] = digitsAfterCommaCharsArray[i];
            }
            digitsAfterCommaString = new String(tenDigitsAfterCommaArray);
        }else {
            digitsAfterCommaString = new String(digitsAfterCommaCharsArray);
            return digitsAfterCommaString;
        }
        List <Integer> digitsInPeriod =new ArrayList<Integer>();
        for (char aTenDigitsAfterCommaArray : tenDigitsAfterCommaArray) {
            digitsInPeriod.add(Integer.parseInt(String.valueOf(aTenDigitsAfterCommaArray)));
        }
            StringBuilder res = new StringBuilder();
            for (Integer integer : digitsInPeriod) {
                res.append(integer);
            }
             result = res.toString();

        return result ;
    }

    private List<Integer> fromIntToList(Integer i) {
        List<Integer> integers = new ArrayList<Integer>();
        char[] intCharArray = i.toString().toCharArray();
        for (char anIntCharArray : intCharArray) {
            integers.add(Integer.parseInt(String.valueOf(anIntCharArray)));
        }

        return integers;
    }

    public boolean isDividendIsNegative() {
        return isDividendIsNegative;
    }
    public boolean isDivisorIsNegative() {
        return isDivisorIsNegative;
    }
    public int getIndivisibleRemainderLength() {
        return indivisibleRemainderLength;
    }
    public int getIndivisibleRemainder() {
        return indivisibleRemainder;
    }
    public List<Integer> getActualQuotientList() {
        return actualQuotientList;
    }
    public List<Integer> getDividendList() {
        return dividendList;
    }
    public int getDividend() {
        return dividend;
    }
    public int getDivisor() {
        return divisor;
    }
    public int getActualQuotient() {
        return actualQuotient;
    }
    public int getFirstSubdividend() {
        return firstSubdividend;
    }

    public int getFirstSubtrahend() {
        return firstSubtrahend;
    }

    public int getLastDividendBeforeComma() {
        return lastDividendBeforeComma;
    }

    public int getLastSubtrahendBeforeComma() {
        return lastSubtrahendBeforeComma;
    }
}



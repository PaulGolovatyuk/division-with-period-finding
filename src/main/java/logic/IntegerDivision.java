package logic;

import java.util.ArrayList;
import java.util.List;

public class IntegerDivision {
    private int dividend;
    private int divisor;
    private int remainder;
    private int actualQuotient;
    private int subDividend;
    private int partOfQuotient;
    private int subtrahend;
    private int indivisibleRemainder;
    private int indivisibleRemainderLength;



    private boolean isDividendIsNegative;
    private boolean isDivisorIsNegative;

    private List<Integer> subtrahendList;
    private List<Integer> subDividendList;
    private List<Integer> dividendList;
    private List<Integer> actualQuotientList;


    public int longDivision(int aDividend, int aDivisor) {
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
        subtrahendList = new ArrayList<Integer>();
        subDividendList = new ArrayList<Integer>();
        actualQuotient = dividend / divisor;
        dividendList = fromIntToList(dividend);
        actualQuotientList = fromIntToList(actualQuotient);

        //calculations
        subDividend = 0;

        for (int i = 0; i < dividendList.size(); ) {
            if (subDividend < divisor) {
                subDividend = subDividend * 10 + dividendList.get(i);
            }
            if (subDividend / divisor > 0) {
                subDividendList.add(subDividend);
            }
            partOfQuotient = subDividend / divisor;

            remainder = subDividend % divisor;
            subtrahend = partOfQuotient * divisor;
            if (subDividend / divisor > 0) {
                subtrahendList.add(subtrahend);
            }
            subDividend = remainder;
            i++;
        }
        return  dividend/divisor;
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
    public List<Integer> getSubtrahendList() {
        return subtrahendList;
    }
    public List<Integer> getSubDividendList() {
        return subDividendList;
    }
}



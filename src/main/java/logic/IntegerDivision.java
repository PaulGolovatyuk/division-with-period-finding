package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerDivision {
    private int dividend;
    private int divisor;
    private int quotient;
    private int result;
    private int remainder = 0;
    private int actualQuotient;
    private int subDividend = 0;
    private int partOfQuotient;
    private int actualIndivisible;
    private int subtrahend;
    private int indivisibleRemainder;
    private int indivisibleRemainderLength;

    private StringBuilder sb;

    private List<Integer> subtrahendList;
    private List<Integer> subdividendList;
    private List<Integer> dividendList;
    private List<Integer> actualQuotientList;
    private List<Integer> remainderList;

    private List<Integer> subDividendListToPrint;
    private List<Integer> subtrahendListToPrint;
    private List<Integer> indivisibleRemainderLengthList;

    public void init() {


        quotient = actualQuotient;

;





    }

    public void longDivision(int aDividend, int aDivisor) {
//        init();

        subtrahendListToPrint = new ArrayList<Integer>();
        subDividendListToPrint = new ArrayList<Integer>();
        sb = new StringBuilder();

        indivisibleRemainderLengthList = fromIntToList(indivisibleRemainder);
        indivisibleRemainderLength = indivisibleRemainderLengthList.size();
        subtrahendList = new ArrayList<Integer>();
        remainderList = new ArrayList<Integer>();
        subdividendList = new ArrayList<Integer>();
        this.dividend = aDividend;
        this.divisor = aDivisor;
        actualQuotient = dividend / divisor;
        actualIndivisible = dividend % divisor;
        indivisibleRemainder = dividend % divisor;
        indivisibleRemainder = dividend % divisor;
        dividendList = fromIntToList(dividend);
        actualQuotientList = fromIntToList(actualQuotient);

        for (int i = 0; i < dividendList.size(); ) {
            if (subDividend < divisor) {
                subDividend = subDividend * 10 + dividendList.get(i);
                if (subDividend / divisor > 0||subDividend==0) {
                    subDividendListToPrint.add(subDividend);
                }
            }
            if (subDividend/divisor>0) {
                subdividendList.add(subDividend);
            }
            partOfQuotient = subDividend / divisor;

            remainder = subDividend % divisor;
            remainderList.add(remainder);
            subtrahend = partOfQuotient * divisor;
            if (subDividend/divisor>0) {
                subtrahendList.add(subtrahend);
            }
//            if (subtrahendList.get(0) == 0) {
//                subtrahendList.remove(0);

                subtrahendListToPrint.add(subtrahend);


            subDividend = remainder;
            sb.append(partOfQuotient);
            i++;

        }
//        subtrahendList.remove(0);
//        subtrahendListToPrint.remove(0);
    }

    private List<Integer> fromIntToList(Integer i) {
        List<Integer> integers = new ArrayList<Integer>();
        char[] intCharArray = i.toString().toCharArray();
        for (char anIntCharArray : intCharArray) {
            integers.add(Integer.parseInt(String.valueOf(anIntCharArray)));
        }

        return integers;
    }

    public List<Integer> getSubtrahendListToPrint() {
        return subtrahendListToPrint;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getIndivisibleRemainderLength() {
        return indivisibleRemainderLength;
    }

    public int getIndivisibleRemainder() {
        return indivisibleRemainder;
    }

    public List<Integer> getSubDividendListToPrint() {
        return subDividendListToPrint;
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

    public int getActualIndivisible() {
        return actualIndivisible;
    }

    public List<Integer> getSubtrahendList() {
        return subtrahendList;
    }

    public List<Integer> getSubdividendList() {
        return subdividendList;
    }
}



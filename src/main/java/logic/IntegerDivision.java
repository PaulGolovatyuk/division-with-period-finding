package logic;

import java.util.ArrayList;
import java.util.List;

public class IntegerDivision {
    private int dividend;
    private int divisor;
    private int quotient;
    int result;
    int remainder = 0;
    int actualQuotient;
    int subDividend = 0;
    int partOfQuotient;
    int actualIndivisible;
    int subtrahend;

    StringBuilder sb;

    List<Integer> subtrahendList;
    List<Integer> subdividendList;
    List<Integer> dividendList;
    List<Integer> actualQuotientList;
    List<Integer> remainderList;



    public void init(){
        actualQuotient = dividend / divisor;
        actualIndivisible = dividend % divisor;
        subtrahendList = new ArrayList<Integer>();
        subdividendList = new ArrayList<Integer>();
        dividendList = fromIntToList(dividend);
//        dividendList.add(dividend);
        sb = new StringBuilder();
        actualQuotientList = fromIntToList(actualQuotient);
        remainderList = new ArrayList<Integer>();
    }
    public void   longDivision() {
        for (int i = 0; i <dividendList.size() ; ) {
            if (subDividend<divisor){
                subDividend = subDividend*10+dividendList.get(i);
            }
                subdividendList.add(subDividend);
                partOfQuotient = subDividend/divisor;

                remainder = subDividend%divisor;
                remainderList.add(remainder);
                subtrahend = partOfQuotient*divisor;
                subtrahendList.add(subtrahend);
                if (subtrahendList.get(0)==0){
                    subtrahendList.remove(0);
                }
                subDividend = remainder;
                sb.append(partOfQuotient);
                i++;

        }

    }

    public IntegerDivision(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    public List<Integer> fromIntToList(Integer i) {
        List<Integer> integers = new ArrayList<Integer>();
        char[] intCharArray = i.toString().toCharArray();
        for (char anIntCharArray : intCharArray) {
            integers.add(Integer.parseInt(String.valueOf(anIntCharArray)));
        }
        return integers;
    }

    public List<Integer> getRemainderList() {
        return remainderList;
    }

    public List<Integer> getActualQuotientList() {
        return actualQuotientList;
    }

    public int getSubtrahend() {
        return subtrahend;
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

    public int getQuotient() {
        return quotient;
    }

    public int getResult() {
        return result;
    }

    public int getRemainder() {
        return remainder;
    }

    public int getActualQuotient() {
        return actualQuotient;
    }

    public int getSubDividend() {
        return subDividend;
    }

    public int getPartOfQuotient() {
        return partOfQuotient;
    }

    public int getActualIndivisible() {
        return actualIndivisible;
    }

    public StringBuilder getSb() {
        return sb;
    }

    public List<Integer> getSubtrahendList() {
        return subtrahendList;
    }

    public List<Integer> getSubdividendList() {
        return subdividendList;
    }
}



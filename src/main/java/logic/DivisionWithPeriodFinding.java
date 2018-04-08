package logic;

import javafx.util.Pair;
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
    private boolean isRepeater = false;

    private List<Integer> dividendList;
    private List<Integer> actualQuotientList;

    private int secondAppearenceIndex;
    private int thirdAppearenceIndex;
    private int startOfRepeatedSequence;
    private int lengthofRepeatedSequence;
    private int  firstAppearanceIndex;
    private char[] periodSequenceCharsArray;
    private char[] terminatedSequenceCharsArray;
    private char [] digitsAfterCommaCharsArray;
    private char[] tenDigitsAfterCommaArray;
    private boolean isTerminatedSequenceEmpty;



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
        findingPeriod(dividend, divisor);

        actualQuotientList = fromIntToList(actualQuotient);
                if (!isRepeater){
            if (digitsAfterCommaCharsArray.length>10){
                for (char c : tenDigitsAfterCommaArray) {
                    actualQuotientList.add(Integer.parseInt(String.valueOf(c)));
                }
            }else{
                for (char c : digitsAfterCommaCharsArray) {
                    actualQuotientList.add(Integer.parseInt(String.valueOf(c)));
                }
            }

        }else{
            if (!isTerminatedSequenceEmpty){
                for (char c : terminatedSequenceCharsArray) {
                    actualQuotientList.add(Integer.parseInt(String.valueOf(c)));
                }
            }
            for (char c : periodSequenceCharsArray) {
                actualQuotientList.add(Integer.parseInt(String.valueOf(c)));
            }
        }

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
            if (integerPartIsCalculated&&indivisibleRemainder!=0){
                dividendList.add(0);
            if (i==actualQuotientList.size())break;
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
        String digitsAfterCommaString;
        String doubleResultString = doubleResult+"";
        String digitsAfterCommaStr = doubleResultString.substring(quotientLength+1);

        isRepeater = false;

        digitsAfterCommaCharsArray = digitsAfterCommaStr.toCharArray();
        tenDigitsAfterCommaArray = new char[10];
        boolean firstCoincidence = false;
        boolean secondCoincidence = false;
        boolean startAppearanceSequenceAssiggned = false;
        boolean firstAppearanceIndexAssigned = false;



        for (int i = 0; i <digitsAfterCommaCharsArray.length ; i++) {
            for (int j = i+1; j <digitsAfterCommaCharsArray.length ; j++) {
                if (digitsAfterCommaCharsArray[i]==digitsAfterCommaCharsArray[j]){
                    firstCoincidence = true;
                    secondAppearenceIndex = j;
                    for (int k = j+1; k < digitsAfterCommaCharsArray.length; k++) {
                        if (digitsAfterCommaCharsArray[i]==digitsAfterCommaCharsArray[k]){
                            secondCoincidence = true;
                            thirdAppearenceIndex = k;
                            if ((k-j)==(j-i)&&digitsAfterCommaCharsArray[j-1]==digitsAfterCommaCharsArray[k-1]){
                                isRepeater = true;
                                lengthofRepeatedSequence = j-i;
                                if (!startAppearanceSequenceAssiggned){
                                    startOfRepeatedSequence = Integer.parseInt(String.valueOf(digitsAfterCommaCharsArray[i]));
                                    startAppearanceSequenceAssiggned = true;
                                }
                                if (!firstAppearanceIndexAssigned){
                                    firstAppearanceIndex = i;
                                    firstAppearanceIndexAssigned = true;
                                }
                            }
                        }
                    }
                }
            }


        }
        if (digitsAfterCommaCharsArray.length>10&&!isRepeater){
            for (int i = 0; i <10 ; i++) {
                tenDigitsAfterCommaArray[i] = digitsAfterCommaCharsArray[i];
            }
        }


            periodSequenceCharsArray = new char[lengthofRepeatedSequence];
            for (int i = firstAppearanceIndex,  j = 0; j <periodSequenceCharsArray.length ; i++, j++ ) {
            periodSequenceCharsArray[j] = digitsAfterCommaCharsArray[i];
        }
        //find terminated sequence
        terminatedSequenceCharsArray = new char[digitsAfterCommaCharsArray.length - (digitsAfterCommaCharsArray.length - firstAppearanceIndex)];
        for (int i = 0; i <firstAppearanceIndex ; i++) {
            terminatedSequenceCharsArray[i] =  digitsAfterCommaCharsArray[i];
        }
        if (firstAppearanceIndex==0){
            isTerminatedSequenceEmpty = true;
        }

        return new String(periodSequenceCharsArray) ;


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

    public int getSecondAppearenceIndex() {
        return secondAppearenceIndex;
    }

    public int getThirdAppearenceIndex() {
        return thirdAppearenceIndex;
    }

    public int getStartOfRepeatedSequence() {
        return startOfRepeatedSequence;
    }

    public int getLengthofRepeatedSequence() {
        return lengthofRepeatedSequence;
    }

    public int getFirstAppearanceIndex() {
        return firstAppearanceIndex;
    }

    public char[] getPeriodSequenceCharsArray() {
        return periodSequenceCharsArray;
    }

    public char[] getTerminatedSequenceCharsArray() {
        return terminatedSequenceCharsArray;
    }

    public boolean isTerminatedSequenceEmpty() {
        return isTerminatedSequenceEmpty;
    }

    public boolean isRepeater() {
        return isRepeater;
    }

    public char[] getDigitsAfterCommaCharsArray() {
        return digitsAfterCommaCharsArray;
    }

    public char[] getTenDigitsAfterCommaArray() {
        return tenDigitsAfterCommaArray;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }
}



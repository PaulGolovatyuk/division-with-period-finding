package logic;


import java.util.ArrayList;
import java.util.List;

public class DivisionWithPeriodFinding {
    private int dividend;
    private int divisor;
    private int remainder;
    private int actualQuotientBeforeComma;
    private long actualQuotientAfterComma;
    private int subDividend;
    private int partOfQuotient;
    private int subtrahend;
    private int indivisibleRemainder;
    private int indivisibleRemainderLength;
    private int firstSubdividend;
    private int firstSubtrahend;
    private int lastDividendBeforeComma;
    private int lastSubtrahendBeforeComma;
    private int numberOfZerosAfterComma;

    private boolean isDividendIsNegative;
    private boolean isDivisorIsNegative;
    private boolean isDecimal;
    private boolean isPeriodDecimal = false;
    private boolean isTerminatedDecimal = false;

    private List<Integer> dividendList;
    private List<Integer> actualQuotientList;
    private List<Integer> remainderList;

    private int secondAppearenceIndex;
    private int thirdAppearenceIndex;
    private int startOfRepeatedSequence;
    private int lengthOfRepeatedSequence;
    private int firstAppearanceIndex;
    private char[] periodSequenceCharsArray;
    private char[] terminatedSequenceCharsArray;
    private char[] digitsAfterCommaCharsArray;
    private char[] tenDigitsAfterCommaArray;
    private boolean isTerminatedSequenceEmpty;


    public int longDivision(int aDividend, int aDivisor) {
        isDecimal = false;
        isTerminatedDecimal = false;
        isTerminatedSequenceEmpty = false;
        actualQuotientAfterComma = 0;
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
        findingPeriod(dividend, divisor);
        if (dividend < divisor || dividend % divisor != 0) {
            isDecimal = true;
        }
        if (isDecimal && !isPeriodDecimal) {
            isTerminatedDecimal = true;
        }
        numberOfZerosAfterComma = 0;
        remainderList = new ArrayList<Integer>();
        indivisibleRemainder = dividend % divisor;
        Integer indivRem = indivisibleRemainder;
        indivisibleRemainderLength = indivRem.toString().length();
        actualQuotientBeforeComma = dividend / divisor;

        if (isDecimal && isTerminatedDecimal && digitsAfterCommaCharsArray.length <= 10) {
            actualQuotientAfterComma = Integer.parseInt(new String(digitsAfterCommaCharsArray));
        } else if (!isPeriodDecimal && digitsAfterCommaCharsArray.length > 10) {
            actualQuotientAfterComma = Long.parseLong(new String(tenDigitsAfterCommaArray));
        } else if (isPeriodDecimal && !isTerminatedSequenceEmpty) {
            actualQuotientAfterComma = Long.parseLong(new String(terminatedSequenceCharsArray) +
                    new String(periodSequenceCharsArray));
        } else if (isPeriodDecimal && isTerminatedSequenceEmpty) {
            actualQuotientAfterComma = Integer.parseInt(new String(periodSequenceCharsArray));
        }

        char[] actualQuotientAfterCommaCharArray;
        actualQuotientAfterCommaCharArray = (actualQuotientAfterComma + "").toCharArray();
        for (char c : actualQuotientAfterCommaCharArray) {
            if (c == '0' && actualQuotientAfterCommaCharArray.length != 1) numberOfZerosAfterComma++;
        }
        dividendList = fromIntToList(dividend);
        findingPeriod(dividend, divisor);

        //if remainder > 0
        if (dividend % divisor >= 0 || dividend < divisor) {
            actualQuotientList = fromIntToList(actualQuotientBeforeComma);
            if (!isPeriodDecimal) {
                if (digitsAfterCommaCharsArray.length > 10) {
                    for (char c : tenDigitsAfterCommaArray) {
                        actualQuotientList.add(Integer.parseInt(String.valueOf(c)));
                    }
                } else {
                    for (char c : digitsAfterCommaCharsArray) {
                        actualQuotientList.add(Integer.parseInt(String.valueOf(c)));
                    }
                }
            } else {
                if (!isTerminatedSequenceEmpty) {
                    for (char c : terminatedSequenceCharsArray) {
                        actualQuotientList.add(Integer.parseInt(String.valueOf(c)));
                    }
                }
                for (char c : periodSequenceCharsArray) {
                    actualQuotientList.add(Integer.parseInt(String.valueOf(c)));
                }
            }
            for (int i = 0; i < actualQuotientList.size() - 1; i++) {
                dividendList.add(0);
            }
        }
        //calculations
        firstSubdividend = 0;
        firstSubtrahend = 0;
        subDividend = 0;
        for (int i = 0; i < dividendList.size(); ) {
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
                firstSubtrahend = subtrahend;
                firstSubtrahendAssigned = true;
            }
            subDividend = remainder;
            i++;

        }


        return dividend / divisor;
    }

    public String findingPeriod(int aDividend, int aDivisor) {
        double doubleDividend = (double) aDividend;
        double doubleDivisor = (double) aDivisor;
        double doubleResult = doubleDividend / doubleDivisor;
        int quotient = aDividend / aDivisor;
        int quotientLength = Integer.toString(quotient).length();
        String doubleResultString = doubleResult + "";
        String digitsAfterCommaStr = doubleResultString.substring(quotientLength + 1);

        isPeriodDecimal = false;
        lengthOfRepeatedSequence = 0;
        digitsAfterCommaCharsArray = digitsAfterCommaStr.toCharArray();
        tenDigitsAfterCommaArray = new char[10];
        boolean startAppearanceSequenceAssigned = false;
        boolean firstAppearanceIndexAssigned = false;
        for (int i = 0; i < digitsAfterCommaCharsArray.length; i++) {
            for (int j = i + 1; j < digitsAfterCommaCharsArray.length; j++) {
                if (digitsAfterCommaCharsArray[i] == digitsAfterCommaCharsArray[j]) {
                    secondAppearenceIndex = j;
                    for (int k = j + 1; k < digitsAfterCommaCharsArray.length; k++) {
                        if (digitsAfterCommaCharsArray[i] == digitsAfterCommaCharsArray[k]) {
                            thirdAppearenceIndex = k;
                            if ((k - j) == (j - i) && digitsAfterCommaCharsArray[j - 1] == digitsAfterCommaCharsArray[k - 1]) {
                                isPeriodDecimal = true;
                                lengthOfRepeatedSequence = j - i;
                                if (!startAppearanceSequenceAssigned) {
                                    startOfRepeatedSequence = Integer.parseInt(String.valueOf(digitsAfterCommaCharsArray[i]));
                                    startAppearanceSequenceAssigned = true;
                                }
                                if (!firstAppearanceIndexAssigned) {
                                    firstAppearanceIndex = i;
                                    firstAppearanceIndexAssigned = true;
                                }
                            }
                        }
                    }
                }
            }


        }
        if (digitsAfterCommaCharsArray.length > 10 && !isPeriodDecimal) {
            for (int i = 0; i < 10; i++) {
                tenDigitsAfterCommaArray[i] = digitsAfterCommaCharsArray[i];
            }
        }

        periodSequenceCharsArray = new char[lengthOfRepeatedSequence];
        for (int i = firstAppearanceIndex, j = 0; j < periodSequenceCharsArray.length; i++, j++) {
            periodSequenceCharsArray[j] = digitsAfterCommaCharsArray[i];
        }
        //find terminated sequence
        terminatedSequenceCharsArray = new char[digitsAfterCommaCharsArray.length - (digitsAfterCommaCharsArray.length - firstAppearanceIndex)];
        for (int i = 0; i < firstAppearanceIndex; i++) {
            terminatedSequenceCharsArray[i] = digitsAfterCommaCharsArray[i];
        }
        if (firstAppearanceIndex == 0) {
            isTerminatedSequenceEmpty = true;
        }

        return new String(periodSequenceCharsArray);
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

    public int getActualQuotientBeforeComma() {
        return actualQuotientBeforeComma;
    }

    public int getFirstSubdividend() {
        return firstSubdividend;
    }

    public int getFirstSubtrahend() {
        return firstSubtrahend;
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

    public boolean isPeriodDecimal() {
        return isPeriodDecimal;
    }

    public char[] getDigitsAfterCommaCharsArray() {
        return digitsAfterCommaCharsArray;
    }

    public char[] getTenDigitsAfterCommaArray() {
        return tenDigitsAfterCommaArray;
    }

    public long getActualQuotientAfterComma() {
        return actualQuotientAfterComma;
    }

    public boolean isDecimal() {
        return isDecimal;
    }
}



package view;


import logic.DivisionWithPeriodFinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowResult {
    private int beforeVerticalPipeLineLength;
    private int maxLengthOfBottom;
    private int maxLengthOfBottomIfZero;
    private String lastRemainder = "";

    public String buildOutputStringOfDivision(DivisionWithPeriodFinding integerDivision, int argDividend, int argDivisor) {
        //if dividend is zero:
        StringBuilder dashesSb = new StringBuilder();
        for (int i = 0; i < Integer.toString(argDivisor).length(); i++) {
            dashesSb.append("-");
        }
        final String zeroDividendString = "0|" + argDivisor + "\n" +
                " |" + dashesSb + "\n" +
                " |0";

        if (argDividend == 0) {
            return zeroDividendString;
        }
        integerDivision.longDivision(argDividend, argDivisor);
        integerDivision.findingPeriod(argDividend, argDivisor);
        StringBuilder resultSb = new StringBuilder();
        resultSb.append(firstLineBuild(integerDivision));
        resultSb.append("\n");
        resultSb.append(secondLineBuild(integerDivision));
        resultSb.append("\n");
        resultSb.append(thirdLineBuild(integerDivision));
        resultSb.append("\n");
        if (integerDivision.getDividend() != integerDivision.getDivisor()) {
            resultSb.append(intermediateActionsLineBuild(integerDivision));
        }
        resultSb.append(indivisibleRemainderLineBuild(integerDivision));

        return resultSb.toString();

    }

    private String firstLineBuild(DivisionWithPeriodFinding div) {
        //building line #1
        if (div.getDividend() < div.getDivisor()) {
            beforeVerticalPipeLineLength = Integer.toString(div.getDividend()).length() + 1 +
                    ((Integer.toString(div.getFirstSubtrahend()).length()) -
                            Integer.toString(div.getDividend()).length());
        } else {
            beforeVerticalPipeLineLength = Integer.toString(div.getDividend()).length() + 1;
        }

        List<String> firstStringList = new ArrayList<String>();
        StringBuilder firstLineSb = new StringBuilder();
        firstLineSb.append("_");
        if (div.isDividendIsNegative()) {
            firstLineSb.append("-");
        }
        firstLineSb.append(String.valueOf(div.getDividend()));
        int whitespacesAfterDividend = Integer.toString(div.getFirstSubtrahend()).length() -
                Integer.toString(div.getDividend()).length();
        for (int i = 0; i < whitespacesAfterDividend; i++) {
            firstLineSb.append(" ");
        }
        firstLineSb.append("|");
        if (div.isDivisorIsNegative()) {
            firstLineSb.append("-");
        }

        firstStringList.add(String.valueOf(div.getDivisor()));
        for (String s : firstStringList) {
            firstLineSb.append(s);
        }
        return firstLineSb.toString();
    }

    private String secondLineBuild(DivisionWithPeriodFinding div) {
        int dividend = div.getDividend();
        int divisor = div.getDivisor();
        StringBuilder secondLineSb = new StringBuilder();
        int firstSubDividend = div.getFirstSubdividend();
        int firstSubtrahend = div.getFirstSubtrahend();
        secondLineSb.append(" ");
        if (div.isDividendIsNegative()) {
            secondLineSb.append(" ");
        }
        int numberOfWhitespacesInSecondLine;

        if (Integer.toString(firstSubDividend).length() >
                Integer.toString(firstSubtrahend).length()) {
            secondLineSb.append(" ");
        }
        //building line when dividend less than divisor
        if (dividend < divisor) {
            if (!div.isTerminatedSequenceEmpty()) {
                secondLineSb.append(Integer.parseInt(String.valueOf(div.getTerminatedSequenceCharsArray()[0])) * divisor);
            } else {
                secondLineSb.append(Integer.parseInt(String.valueOf(div.getPeriodSequenceCharsArray()[0])) * divisor);
            }
        } else {
            secondLineSb.append(firstSubtrahend);
        }
        numberOfWhitespacesInSecondLine = beforeVerticalPipeLineLength - secondLineSb.length();
        if (div.isDividendIsNegative()) numberOfWhitespacesInSecondLine++;
        for (int i = 0; i < numberOfWhitespacesInSecondLine; i++) {
            secondLineSb.append(" ");
        }
        secondLineSb.append("|");
        int dividendLength = String.valueOf(dividend).length();
        int divisorLength = String.valueOf(divisor).length();
        int totalQuotientLength = 0;
        if (div.isDecimal()) {
            if (div.isPeriodDecimal()) {
                totalQuotientLength = div.getActualQuotientList().size() + 3;
            } else {
                totalQuotientLength = div.getActualQuotientList().size() + 1;
            }
        } else {
            totalQuotientLength = dividendLength - divisorLength;
        }
        if (Integer.toString(div.getDivisor()).length() > totalQuotientLength) {

            for (int i = 0; i < divisorLength; i++) {
                secondLineSb.append("-");
            }
        } else {
            for (int i = 0; i < totalQuotientLength; i++) {
                secondLineSb.append("-");
            }
        }
        if (div.isDivisorIsNegative() || div.isDividendIsNegative()) {
            secondLineSb.append("-");
        }
        return secondLineSb.toString();
    }

    private String thirdLineBuild(DivisionWithPeriodFinding div) {
        String periodString;
        String terminatedSequenceString;
        int firstSubtrahend = div.getFirstSubtrahend();
        int firstSubDividend = div.getFirstSubdividend();
        char[] periodSequenceCharsArray = div.getPeriodSequenceCharsArray();
        char[] terminatedSequenceCharsArray = div.getTerminatedSequenceCharsArray();
        StringBuilder periodSb = new StringBuilder();
        StringBuilder terminatedSequenceSb = new StringBuilder();
        StringBuilder thirdLineSb = new StringBuilder();
        int firstSubdividendLength = Integer.toString(firstSubDividend).length();
        int firstSubtrahendLength = Integer.toString(firstSubtrahend).length();


        thirdLineSb.append(" ");
        if (firstSubtrahendLength < firstSubdividendLength) {
            thirdLineSb.append(" ");
        }
        if (div.isDividendIsNegative()) {
            thirdLineSb.append(" ");
        }
        int numberOfWhitespacesInSecondLine;
        for (int i = 0; i < firstSubtrahendLength; i++) {
            thirdLineSb.append("-");
        }
        maxLengthOfBottomIfZero = thirdLineSb.length();
        numberOfWhitespacesInSecondLine = beforeVerticalPipeLineLength - thirdLineSb.length();
        if (div.isDividendIsNegative()) numberOfWhitespacesInSecondLine++;
        for (int i = 0; i < numberOfWhitespacesInSecondLine; i++) {
            thirdLineSb.append(" ");
        }
        thirdLineSb.append("|");
        if (div.isDividendIsNegative() ^ div.isDivisorIsNegative()) {
            thirdLineSb.append("-");
        }

        if (!div.isDecimal()) {
            thirdLineSb.append(div.getActualQuotientBeforeComma());
        } else {
            thirdLineSb.append(div.getActualQuotientBeforeComma());
            if (div.getIndivisibleRemainder() != 0) {
                thirdLineSb.append(".");
            }
            if (div.isPeriodDecimal()) {
                for (char c : terminatedSequenceCharsArray) {
                    terminatedSequenceSb.append(c);
                }
                terminatedSequenceString = terminatedSequenceSb.toString();
                if (!div.isTerminatedSequenceEmpty()) {
                    thirdLineSb.append(terminatedSequenceString);
                }
                thirdLineSb.append("(");

                for (char c : periodSequenceCharsArray) {
                    periodSb.append(String.valueOf(c));
                }
                periodString = periodSb.toString();
                thirdLineSb.append(periodString);
                thirdLineSb.append(")");
            } else {
                if (div.getDigitsAfterCommaCharsArray().length > 10) {
                    thirdLineSb.append(div.getTenDigitsAfterCommaArray());
                } else {
                    thirdLineSb.append(div.getDigitsAfterCommaCharsArray());
                }
            }
        }
        return thirdLineSb.toString();
    }

    private String intermediateActionsLineBuild(DivisionWithPeriodFinding div) {
        int currentSubDividend = div.getFirstSubdividend();
        int currentSubtrahend = div.getFirstSubtrahend();
        int currentRemainder = currentSubDividend - currentSubtrahend;
        int lengthOfDividendInOutput = div.getDividendList().size() + 1;
        int numberOfActions;
        long quotientDigitsOnly;
        boolean isActionRelevant;


        String intermediateActionsLines;
        String res = "";

        String[] otherLinesBlocksArray = new String[div.getActualQuotientList().size()];
        char[] componentBlocksArray = new char[lengthOfDividendInOutput];
        Arrays.fill(componentBlocksArray, ' ');
        String justWhitespaces = new String(componentBlocksArray);

        if (div.isDecimal()) {
            quotientDigitsOnly = (Long.parseLong("" + div.getActualQuotientBeforeComma() + div.getActualQuotientAfterComma()));
        } else {
            quotientDigitsOnly = div.getActualQuotientBeforeComma();//
        }
        numberOfActions = (quotientDigitsOnly + "").length() - 1;

        int offset = Integer.toString(div.getFirstSubdividend()).length() - (Integer.toString(div.getFirstSubdividend() - div.getFirstSubtrahend())).length();

        for (int i = 0; i < numberOfActions; i++) {
            String summary;
            StringBuilder substringOneSb = new StringBuilder(justWhitespaces);
            List<Integer> dividendList = div.getDividendList();

            currentSubDividend = currentRemainder * 10 + dividendList.get(i + Integer.toString(div.getFirstSubdividend()).length());
            currentSubtrahend = (currentSubDividend / div.getDivisor()) * div.getDivisor();
            currentRemainder = currentSubDividend % div.getDivisor();

            if (currentSubDividend < div.getDivisor() || currentSubDividend / currentSubtrahend == 0) {
                isActionRelevant = false;

            } else {
                isActionRelevant = true;
            }
            String marker = "M";

            //construct substring #1
            substringOneSb.insert(offset, "_" + currentSubDividend + marker);
            //construct substring #2
            int delta = 0;

            StringBuilder substringTwoSb = new StringBuilder(justWhitespaces);
            delta = (Integer.toString(currentSubDividend).length()) -
                    (Integer.toString(currentSubtrahend).length());
            substringTwoSb.insert(offset + 1 + delta, "" + currentSubtrahend + marker);
            //construct substring #3
            StringBuilder substringThreeSb = new StringBuilder(justWhitespaces);
            StringBuilder dashes = new StringBuilder();
            for (int j = 0; j < Integer.toString(currentSubtrahend).length(); j++) {
                dashes.append("-");
            }
            substringThreeSb.insert(offset + 1 + delta, "" + dashes + marker);
            if (isActionRelevant) {
                offset += Integer.toString(currentSubDividend).length() - Integer.toString(currentRemainder).length();
            }
            if (currentSubDividend - currentSubtrahend == 0) {
                offset++;
            }
            lastRemainder = String.valueOf(currentRemainder);
            //fitting to normal size
            String[] strings;
            String subSOne = substringOneSb.toString();
            strings = subSOne.split("M", 2);
            subSOne = strings[0];
            String subSTwo = substringTwoSb.toString();
            strings = subSTwo.split("M", 2);
            subSTwo = strings[0];
            String subThree = substringThreeSb.toString();
            strings = subThree.split("M", 2);
            subThree = strings[0];

            maxLengthOfBottom = subThree.length();

            if (div.isDividendIsNegative()) {
                summary = " " + subSOne + "\n" + " " + subSTwo + "\n" + " " + subThree;
            } else {
                summary = subSOne + "\n" + subSTwo + "\n" + subThree;
            }
            otherLinesBlocksArray[i] = summary;
            if (isActionRelevant) {
                res += otherLinesBlocksArray[i] + "\n";
            }
        }
        intermediateActionsLines = res;
        return intermediateActionsLines;
    }

    private String indivisibleRemainderLineBuild(DivisionWithPeriodFinding div) {
        StringBuilder indivisibleRemainderSb = new StringBuilder();
        String resultString;

        if (div.getDividend() != div.getDivisor()) {
            int bottomOffset = maxLengthOfBottom - lastRemainder.length();
            if (div.isDividendIsNegative()) bottomOffset++;
            for (int i = 0; i < bottomOffset; i++) {
                indivisibleRemainderSb.append(" ");
            }
            indivisibleRemainderSb.append(lastRemainder);
        } else {
            int bottomIfZeroOffset = maxLengthOfBottomIfZero - 1;

            for (int i = 0; i < bottomIfZeroOffset; i++) {
                indivisibleRemainderSb.append(" ");
            }
            indivisibleRemainderSb.append("0");
        }
        resultString = indivisibleRemainderSb.toString();
        return resultString;

    }
}
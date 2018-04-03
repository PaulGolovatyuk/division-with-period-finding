package view;

import logic.IntegerDivision;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowResult {

    public String buildOutputStringOfDivision(IntegerDivision integerDivision, int argDividend, int argDivisor) {

        //if dividend is zero:
        final String zeroDividendString = "0";
        if (argDividend == 0) {
            return zeroDividendString;
        }

        integerDivision.longDivision(argDividend, argDivisor);
        String result;
        StringBuilder firstLineSb = new StringBuilder();

        //building line #1
        String firstLine;
        List<String> firstStringList = new ArrayList<String>();
        firstStringList.add("_");
        if (integerDivision.isDividendIsNegative()) {
            firstStringList.add("-");
        }
        firstStringList.add(String.valueOf(integerDivision.getDividend()));
        firstStringList.add("|");
        if (integerDivision.isDivisorIsNegative()) {
            firstStringList.add("-");
        }
        firstStringList.add(String.valueOf(integerDivision.getDivisor()));
        for (String s : firstStringList) {
            firstLineSb.append(s);
        }

        //building line #2
        String secondLine;
        StringBuilder secondLineSb = new StringBuilder();
        int firstSubDividend = integerDivision.getFirstSubdividend();
        int firstSubtrahend = integerDivision.getFirstSubtrahend();
        secondLineSb.append(" ");
        if (integerDivision.isDividendIsNegative()) {
            secondLineSb.append(" ");
        }
        int numberOfWhitespacesInSecondLine;
        boolean firstSubtrahendLessThanSubDividend = false;
        if (Integer.toString(firstSubDividend).length() >
                Integer.toString(firstSubtrahend).length()) {
            secondLineSb.append(" ");
            firstSubtrahendLessThanSubDividend = true;
        }

        secondLineSb.append(firstSubtrahend);
        numberOfWhitespacesInSecondLine = integerDivision.getDividendList().size() -
                Integer.toString(firstSubtrahend).length();
        for (int i = 0; i < numberOfWhitespacesInSecondLine; i++) {
            secondLineSb.append(" ");
        }
        if (firstSubtrahendLessThanSubDividend) {
            secondLineSb.delete(secondLineSb.length() - 1, secondLineSb.length());
        }
        secondLineSb.append("|");
        int quotientLength = integerDivision.getActualQuotientList().size();
        for (int i = 0; i < quotientLength; i++) {
            secondLineSb.append("-");
        }
        if (integerDivision.isDivisorIsNegative() && Integer.toString(integerDivision.getDivisor()).length() + 1 >
                quotientLength) {
            secondLineSb.append("-");
        }

        //building line #3

        String thirdLine;
        StringBuilder thirdLineSb = new StringBuilder();
        thirdLineSb.append(" ");
        if (Integer.toString(firstSubtrahend).length() <
                Integer.toString(firstSubDividend).length()) {
            thirdLineSb.append(" ");
        }
        if (integerDivision.isDividendIsNegative()) {
            thirdLineSb.append(" ");
        }
        for (int i = 0; i < Integer.toString(firstSubtrahend).length(); i++) {
            thirdLineSb.append("-");
        }
        for (int i = 0; i < numberOfWhitespacesInSecondLine; i++) {
            thirdLineSb.append(" ");
        }
        if (firstSubtrahendLessThanSubDividend) {
            thirdLineSb.delete(thirdLineSb.length() - 1, thirdLineSb.length());
        }
        thirdLineSb.append("|");
        if (integerDivision.isDividendIsNegative() ^ integerDivision.isDivisorIsNegative()) {
            thirdLineSb.append("-");
        }
        thirdLineSb.append(integerDivision.getActualQuotient());


//        //building intermediate actions lines
        String intermediateActionsLines;
        int lengthOfDividendInOutput = integerDivision.getDividendList().size() + 1;
        String res = "";
        String[] otherLinesBlocksArray = new String[integerDivision.getActualQuotientList().size()];
        char[] componentBlocksArray = new char[lengthOfDividendInOutput];
        Arrays.fill(componentBlocksArray, ' ');
        String justWhitespaces = new String(componentBlocksArray);

        int currentSubDividend = firstSubDividend;
        int currentSubtrahend = firstSubtrahend;
        int currentRemainder = currentSubDividend - currentSubtrahend;
        int currentSubDividendLength = Integer.toString(currentSubDividend).length();

        boolean notEmpty;
        boolean breakthrough = false;
        int additionOffset = 0;
        List<Integer> dividentList = integerDivision.getDividendList();
        if (Integer.toString(currentRemainder).length() < Integer.toString(currentSubtrahend).length()) {
            additionOffset++;
        }
        for (int i = 0; i < otherLinesBlocksArray.length - 1; i++) {
            String summary;
            StringBuilder substringOneSb = new StringBuilder(justWhitespaces);


            if (i > 0 && currentRemainder > 0 && Integer.toString(currentRemainder).length() ==
                    Integer.toString(currentSubtrahend).length()) {
                additionOffset = 0;
            }

            additionOffset += Integer.toString(currentSubtrahend).length()
                    - (Integer.toString(currentSubtrahend).length()
                    - (Integer.toString(currentSubDividend).length()
                    - Integer.toString(currentSubtrahend).length()));

            if (currentRemainder == 0) {
                additionOffset++;
            }


            currentSubDividend = currentRemainder * 10 + dividentList.get(i + currentSubDividendLength);
            currentSubtrahend = (currentSubDividend / integerDivision.getDivisor()) * integerDivision.getDivisor();
            currentRemainder = currentSubDividend % integerDivision.getDivisor();

            if (breakthrough && additionOffset != 0) {
                additionOffset--;
            }
            if (currentSubDividend / integerDivision.getDivisor() == 0 && additionOffset != 0) {
                additionOffset--;
            }

            if (currentSubDividend < integerDivision.getDivisor() || currentSubDividend / currentSubtrahend == 0) {
                notEmpty = false;

            } else {
                notEmpty = true;

                //construct substring #1
                substringOneSb.insert(i + additionOffset, "_" + currentSubDividend);
            }

            //construct substring #2
            StringBuilder substringTwoSb = new StringBuilder(justWhitespaces);
            substringTwoSb.insert(i + 1 + additionOffset, "" + currentSubtrahend);

            //construct substring #3
            StringBuilder substringThreeSb = new StringBuilder(justWhitespaces);
            StringBuilder dashes = new StringBuilder();
            for (int j = 0; j < Integer.toString(currentSubtrahend).length(); j++) {
                dashes.append("-");
            }
            if (Integer.toString(currentSubDividend).length() >
                    Integer.toString(currentSubtrahend).length()) {
                substringThreeSb.insert(i + 3, "" + dashes);
            } else {
                substringThreeSb.insert(i + 1 + additionOffset, "" + dashes);
            }
            //fitting to required length
            String subSOne = substringOneSb.substring(0, lengthOfDividendInOutput);
            String subSTwo = substringTwoSb.substring(0, lengthOfDividendInOutput);
            String subThree = substringThreeSb.substring(0, lengthOfDividendInOutput);

            if (integerDivision.isDividendIsNegative()) {
                summary = " " + subSOne + "\n" + " " + subSTwo + "\n" + " " + subThree;
            } else {
                summary = subSOne + "\n" + subSTwo + "\n" + subThree;
            }
            otherLinesBlocksArray[i] = summary;
            if (notEmpty) {
                res += otherLinesBlocksArray[i] + "\n";
            } else {
                breakthrough = true;
            }
        }
        intermediateActionsLines = res;


        // building last line
        int indivRemainder = integerDivision.getIndivisibleRemainder();
        int indivRemainderLength = integerDivision.getIndivisibleRemainderLength();
        String indivisibleRemainderString;
        char[] indivisibleRemainderStringArray = new char[lengthOfDividendInOutput];
        Arrays.fill(indivisibleRemainderStringArray, ' ');
        indivisibleRemainderString = new String(indivisibleRemainderStringArray);
        StringBuilder indivisibleRemainderBuilder = new StringBuilder(indivisibleRemainderString);
        if (integerDivision.isDividendIsNegative()) {
            indivisibleRemainderBuilder.insert(lengthOfDividendInOutput + 1 -
                    indivRemainderLength, indivRemainder);
        } else {
            indivisibleRemainderBuilder.insert(lengthOfDividendInOutput -
                    indivRemainderLength, indivRemainder);
        }

        firstLine = firstLineSb.toString();
        secondLine = secondLineSb.toString();
        thirdLine = thirdLineSb.toString();
        if (integerDivision.isDividendIsNegative()) {
            indivisibleRemainderString = indivisibleRemainderBuilder.toString().substring(0, lengthOfDividendInOutput + 1);

        } else {
            indivisibleRemainderString = indivisibleRemainderBuilder.toString().substring(0, lengthOfDividendInOutput);
        }

        result = firstLine + "\n" + secondLine + "\n" + thirdLine + "\n" + intermediateActionsLines + indivisibleRemainderString;
        return result;
    }
}
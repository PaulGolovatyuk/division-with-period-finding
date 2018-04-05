package view;

import logic.DivisionWithPeriodFinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowResult {

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
        StringBuilder resultSb = new StringBuilder();
        resultSb.append(firstLineBuild(integerDivision, argDividend, argDivisor));
        resultSb.append("\n");
        resultSb.append(secondLineBuild(integerDivision, argDividend, argDivisor));
        resultSb.append("\n");
        resultSb.append(thirdLineBuild(integerDivision, argDividend, argDivisor));
        resultSb.append("\n");
        resultSb.append(intermidediateActionsLineBuild(integerDivision, argDividend, argDivisor));
        resultSb.append(indivisibleRemainderLineBuild(integerDivision, argDividend, argDivisor));

        return resultSb.toString();

    }




    private String firstLineBuild(DivisionWithPeriodFinding div, int argDividend, int argDivisor) {
        //building line #1
        String firstLine;
        List<String> firstStringList = new ArrayList<String>();
        StringBuilder firstLineSb = new StringBuilder();
        firstStringList.add("_");
        if (div.isDividendIsNegative()) {
            firstStringList.add("-");
        }
        firstStringList.add(String.valueOf(div.getDividend()));
        firstStringList.add("|");
        if (div.isDivisorIsNegative()) {
            firstStringList.add("-");
        }
        firstStringList.add(String.valueOf(div.getDivisor()));
        for (String s : firstStringList) {
            firstLineSb.append(s);
        }
        return firstLineSb.toString();
    }
    private String secondLineBuild(DivisionWithPeriodFinding div, int argDividend, int argDivisor) {
        String secondLine;
        StringBuilder secondLineSb = new StringBuilder();
        int firstSubDividend = div.getFirstSubdividend();
        int firstSubtrahend = div.getFirstSubtrahend();
        secondLineSb.append(" ");
        if (div.isDividendIsNegative()) {
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
        numberOfWhitespacesInSecondLine = div.getDividendList().size() -
                Integer.toString(firstSubtrahend).length();
        for (int i = 0; i < numberOfWhitespacesInSecondLine; i++) {
            secondLineSb.append(" ");
        }
        if (firstSubtrahendLessThanSubDividend) {
            secondLineSb.delete(secondLineSb.length() - 1, secondLineSb.length());
        }
        secondLineSb.append("|");
        int quotientLength = div.getActualQuotientList().size();
        for (int i = 0; i < quotientLength; i++) {
            secondLineSb.append("-");
        }
        if (div.isDivisorIsNegative() && Integer.toString(div.getDivisor()).length() + 1 >
                quotientLength) {
            secondLineSb.append("-");
        }
        return secondLineSb.toString();
    }

    private String thirdLineBuild(DivisionWithPeriodFinding div, int argDividend, int argDivisor){
        String thirdLine;
        int firstSubtrahend = div.getFirstSubtrahend();
        int firstSubDividend = div.getFirstSubdividend();
        StringBuilder thirdLineSb = new StringBuilder();
        thirdLineSb.append(" ");

        if (Integer.toString(firstSubtrahend).length() <
                Integer.toString(firstSubDividend).length()) {
            thirdLineSb.append(" ");
        }
        if (div.isDividendIsNegative()) {
            thirdLineSb.append(" ");
        }
        int numberOfWhitespacesInSecondLine;
        boolean firstSubtrahendLessThanSubDividend = false;
        if (Integer.toString(firstSubDividend).length() >
                Integer.toString(firstSubtrahend).length()) {
            firstSubtrahendLessThanSubDividend = true;
        }

        for (int i = 0; i < Integer.toString(firstSubtrahend).length(); i++) {
            thirdLineSb.append("-");
        }
        numberOfWhitespacesInSecondLine = div.getDividendList().size() -
                Integer.toString(firstSubtrahend).length();
        for (int i = 0; i < numberOfWhitespacesInSecondLine; i++) {
            thirdLineSb.append(" ");
        }
        if (firstSubtrahendLessThanSubDividend) {
            thirdLineSb.delete(thirdLineSb.length() - 1, thirdLineSb.length());
        }
        thirdLineSb.append("|");
        if (div.isDividendIsNegative() ^ div.isDivisorIsNegative()) {
            thirdLineSb.append("-");
        }
        thirdLineSb.append(div.getActualQuotient());
        return thirdLineSb.toString();
    }
    private String intermidediateActionsLineBuild(DivisionWithPeriodFinding div, int argDividend, int argDivisor){
                String intermediateActionsLines;
        int lengthOfDividendInOutput = div.getDividendList().size() + 1;
        String res = "";
        String[] otherLinesBlocksArray = new String[div.getActualQuotientList().size()];
        char[] componentBlocksArray = new char[lengthOfDividendInOutput];
        Arrays.fill(componentBlocksArray, ' ');
        String justWhitespaces = new String(componentBlocksArray);

        int currentSubDividend = div.getFirstSubdividend();
        int currentSubtrahend = div.getFirstSubtrahend();
        int currentRemainder = currentSubDividend - currentSubtrahend;
        int currentSubDividendLength = Integer.toString(currentSubDividend).length();

        boolean notEmpty;
        boolean breakthrough = false;
        int additionOffset = 0;

        if (Integer.toString(currentRemainder).length() < Integer.toString(currentSubtrahend).length()) {
            additionOffset++;
        }
        for (int i = 0; i < otherLinesBlocksArray.length - 1; i++) {
            String summary;
            StringBuilder substringOneSb = new StringBuilder(justWhitespaces);
            List<Integer> dividentList = div.getDividendList();


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
            currentSubtrahend = (currentSubDividend / div.getDivisor()) * div.getDivisor();
            currentRemainder = currentSubDividend % div.getDivisor();

            if (breakthrough && additionOffset != 0) {
                additionOffset--;
            }
            if (currentSubDividend / div.getDivisor() == 0 && additionOffset != 0) {
                additionOffset--;
            }

            if (currentSubDividend < div.getDivisor() || currentSubDividend / currentSubtrahend == 0) {
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

            if (div.isDividendIsNegative()) {
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
        return intermediateActionsLines;
    }

    private String indivisibleRemainderLineBuild(DivisionWithPeriodFinding div, int argDividend, int argDivisor){

        int lengthOfDividendInOutput = div.getDividendList().size() + 1;
        int indivRemainder = div.getIndivisibleRemainder();
        int indivRemainderLength = div.getIndivisibleRemainderLength();
        String indivisibleRemainderString;
        char[] indivisibleRemainderStringArray = new char[lengthOfDividendInOutput];
        Arrays.fill(indivisibleRemainderStringArray, ' ');
        indivisibleRemainderString = new String(indivisibleRemainderStringArray);
        StringBuilder indivisibleRemainderBuilder = new StringBuilder(indivisibleRemainderString);
        if (div.isDividendIsNegative()) {
            indivisibleRemainderBuilder.insert(lengthOfDividendInOutput + 1 -
                    indivRemainderLength, indivRemainder);
        } else {
            indivisibleRemainderBuilder.insert(lengthOfDividendInOutput -
                    indivRemainderLength, indivRemainder);
        }
        if (div.isDividendIsNegative()) {
            indivisibleRemainderString = indivisibleRemainderBuilder.toString().substring(0, lengthOfDividendInOutput + 1);

        } else {
            indivisibleRemainderString = indivisibleRemainderBuilder.toString().substring(0, lengthOfDividendInOutput);
        }
        return indivisibleRemainderString;
    }
}
package view;

import logic.IntegerDivision;

import java.util.ArrayList;
import java.util.List;

public class ShowResult {

    public String resultBuilder(IntegerDivision integerDivision, int argDivident, int argDivisor) {
        integerDivision.longDivision(argDivident, argDivisor);
        String result;
        StringBuilder firstStringSb = new StringBuilder();

        //building line #1

        String firstLine;
        List<String> firstStringList = new ArrayList<String>();
        firstStringList.add("_");
        if (integerDivision.isDividendIsNegative()) {
            firstStringList.add("-");
        }
        firstStringList.add(String.valueOf(integerDivision.getDividend()));
        firstStringList.add("|");
        if (integerDivision.isDivisorIsNegative()||integerDivision.isDividendIsNegative()){
            firstStringList.add("-");
        }
        firstStringList.add(String.valueOf(integerDivision.getDivisor()));
        for (String s : firstStringList) {
            firstStringSb.append(s);
        }

        //building line #2

        String secondLine;
        StringBuilder secondLineSb = new StringBuilder();
        List<String> secondLineList = new ArrayList<String>();
        secondLineList.add(" ");

        if (integerDivision.isDividendIsNegative()){
            secondLineSb.append(" ");
        }
        int numberOfWhitespacesInSecondLine;
        if (integerDivision.getSubdividendList().get(0).toString().length() >
                integerDivision.getSubtrahendList().get(0).toString().length()) {
            secondLineSb.append(" ");
        }
        secondLineList.add(integerDivision.getSubtrahendList().get(0).toString());
        for (String s : secondLineList) {
            secondLineSb.append(s);
        }
        numberOfWhitespacesInSecondLine = integerDivision.getDividendList().size() -
                integerDivision.getSubtrahendList().get(0).toString().length();
        for (int i = 0; i < numberOfWhitespacesInSecondLine; i++) {
            secondLineSb.append(" ");
        }
        secondLineSb.append("|");
        for (int i = 0; i < integerDivision.getActualQuotientList().size(); i++) {
            secondLineSb.append("-");
        }
        if (integerDivision.isDivisorIsNegative()&&Integer.toString(integerDivision.getDivisor()).length()+1>
                integerDivision.getActualQuotientList().size()){
            secondLineSb.append("-");
        }

        //building line #3
        String otherLines = "";
        String thirdLine;
        StringBuilder thirdLineSb = new StringBuilder();
        thirdLineSb.append(" ");
        if (integerDivision.isDividendIsNegative()){
            thirdLineSb.append(" ");
        }
        for (int i = 0; i < integerDivision.getSubtrahendList().get(0).toString().length(); i++) {
            thirdLineSb.append("-");
        }
        for (int i = 0; i < numberOfWhitespacesInSecondLine; i++) {
            thirdLineSb.append(" ");
        }
        thirdLineSb.append("|");
        if (integerDivision.isDividendIsNegative()^integerDivision.isDivisorIsNegative()){
            thirdLineSb.append("-");
        }
        thirdLineSb.append(integerDivision.getActualQuotient());


//        //building otherLines
        String[] strings = new String[integerDivision.getActualQuotientList().size()];//5
        String res = "";
        int lengthOfDividentInOutput = integerDivision.getDividendList().size() + 1;
        char[] chars = new char[lengthOfDividentInOutput];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = ' ';
        }

        StringBuilder whitespacesSb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            whitespacesSb.append(String.valueOf(chars[i]));
        }
        String justWhitespaces = whitespacesSb.toString();

        int currentSubDividend = integerDivision.getSubdividendList().get(0);
        int currentSubtrahend = integerDivision.getSubtrahendList().get(0);
        int currentRemainder = currentSubDividend - currentSubtrahend;
        int currentSubDividendLength = Integer.toString(currentSubDividend).length();
        boolean notEmpty = false;
        for (int i = 0; i < strings.length - 1; i++) {
            String summary = "";
            String subStringOne = justWhitespaces;
            StringBuilder substringOneSb = new StringBuilder(subStringOne);
            int additionOffset = Integer.toString(currentSubtrahend).length() -
                    (Integer.toString(currentSubDividend-currentSubtrahend).length());
            currentSubDividend = currentRemainder * 10 + integerDivision.getDividendList().get(i + currentSubDividendLength);
            currentSubtrahend = (currentSubDividend / integerDivision.getDivisor()) * integerDivision.getDivisor();
            currentRemainder = currentSubDividend % integerDivision.getDivisor();

            if (currentSubDividend < integerDivision.getDivisor() || currentSubDividend / currentSubtrahend == 0) {
                notEmpty = false;

            } else {
                notEmpty = true;
                //construct substring #1
                substringOneSb.insert(i + additionOffset , "_" + currentSubDividend);
            }

            //construct substring #2
            StringBuilder substringTwoSb = new StringBuilder(subStringOne);
//            if (Integer.toString(currentSubDividend).length()>
//                    Integer.toString(currentSubtrahend).length()){
//                substringTwoSb.insert(i + 3, "" + currentSubtrahend);
//            }else {
                substringTwoSb.insert(i + 1+ additionOffset, "" + currentSubtrahend);


            //construct substring #3
            StringBuilder substringThreeSb = new StringBuilder(subStringOne);
            StringBuilder dashes = new StringBuilder();

            for (int j = 0; j < Integer.toString(currentSubtrahend).length(); j++) {
                dashes.append("-");
            }
            if (Integer.toString(currentSubDividend).length()>
                    Integer.toString(currentSubtrahend).length()){
                substringThreeSb.insert(i + 3, "" + dashes.toString());
            }else {
                substringThreeSb.insert(i + 1+additionOffset, "" + dashes.toString());
            }
            String subSOne = substringOneSb.substring(0, integerDivision.getDividendList().size() + 1);
            String subSTwo = substringTwoSb.substring(0, integerDivision.getDividendList().size() + 1);
            ;
            String subThree = substringThreeSb.substring(0, integerDivision.getDividendList().size() + 1);
            ;
            if (integerDivision.isDividendIsNegative()){
                summary = " "+subSOne + "\n"+" " + subSTwo + "\n" +" "+ subThree;
            }else {
                summary = subSOne + "\n" + subSTwo + "\n" + subThree;
            }
            strings[i] = summary;
            if (notEmpty) {
                res += strings[i] + "\n";
            }
        }

        otherLines = res;


        // building last string
        String lastString = "";
        String indivisibleRemainderString = "";
        char[] chars1 = new char[lengthOfDividentInOutput];
        for (int i = 0; i < chars.length; i++) {
            chars1[i] = ' ';
        }
        for (char c : chars1) {
            indivisibleRemainderString += String.valueOf(c);
        }
        StringBuilder indivisibleRemainderBuilder = new StringBuilder(indivisibleRemainderString);
        if (integerDivision.isDividendIsNegative()){
            indivisibleRemainderBuilder.insert(lengthOfDividentInOutput+1 -
                    integerDivision.getIndivisibleRemainderLength(), integerDivision.getIndivisibleRemainder());
        }else {
            indivisibleRemainderBuilder.insert(lengthOfDividentInOutput -
                    integerDivision.getIndivisibleRemainderLength(), integerDivision.getIndivisibleRemainder());
        }

        firstLine = firstStringSb.toString();
        secondLine = secondLineSb.toString();
        thirdLine = thirdLineSb.toString();
        if (integerDivision.isDividendIsNegative()){
            lastString = indivisibleRemainderBuilder.toString().substring(0, lengthOfDividentInOutput+1);

        }else {
            lastString = indivisibleRemainderBuilder.toString().substring(0, lengthOfDividentInOutput);
        }

        result = firstLine + "\n" + secondLine + "\n" + thirdLine + "\n" + otherLines + lastString;
        return result;
    }
}
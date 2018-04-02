package view;

import logic.IntegerDivision;

import java.util.ArrayList;
import java.util.List;

public class ShowResult {

    public String resultBuilder(IntegerDivision integerDivision, int argDividend, int argDivisor) {

        //if dividend is zero:
        StringBuilder dashesSb = new StringBuilder();
        for (int i = 0; i <Integer.toString(argDivisor).length() ; i++) {
            dashesSb.append("-");
        }
        final String ifDividendIsZero =     "0|"+argDivisor+"\n"+
                                            " |"+dashesSb.toString()+"\n"+
                                            " |0";
        if (argDividend==0){
            return ifDividendIsZero;
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
        if (integerDivision.isDivisorIsNegative()){
            firstStringList.add("-");
        }
        firstStringList.add(String.valueOf(integerDivision.getDivisor()));
        for (String s : firstStringList) {
            firstLineSb.append(s);
        }

        //building line #2
        String secondLine;
        StringBuilder secondLineSb = new StringBuilder();
        List<String> secondLineList = new ArrayList<String>();
        int firstSubDividend = integerDivision.getSubDividendList().get(0);
        int firstSubtrahend = integerDivision.getSubtrahendList().get(0);
        secondLineList.add(" ");
        if (integerDivision.isDividendIsNegative()){
            secondLineSb.append(" ");
        }
        int numberOfWhitespacesInSecondLine;
        boolean firstSubtrahendLessThanSubDividend = false;
        if (Integer.toString(firstSubDividend).length() >
                Integer.toString(firstSubtrahend).length()) {
            secondLineSb.append(" ");
            firstSubtrahendLessThanSubDividend = true;
        }
        secondLineList.add(Integer.toString(firstSubtrahend));
        for (String s : secondLineList) {
            secondLineSb.append(s);
        }
        numberOfWhitespacesInSecondLine = integerDivision.getDividendList().size()-
                Integer.toString(firstSubtrahend).length();
        for (int i = 0; i < numberOfWhitespacesInSecondLine; i++) {
            secondLineSb.append(" ");
        }
        if (firstSubtrahendLessThanSubDividend){
            secondLineSb.delete(secondLineSb.length()-1, secondLineSb.length());
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
        String otherLines;
        String thirdLine;
        StringBuilder thirdLineSb = new StringBuilder();
        thirdLineSb.append(" ");
        if (Integer.toString(firstSubtrahend).length()<
                Integer.toString(firstSubDividend).length()){
            thirdLineSb.append(" ");
        }
        if (integerDivision.isDividendIsNegative()){
            thirdLineSb.append(" ");
        }
        for (int i = 0; i < Integer.toString(firstSubtrahend).length(); i++) {
            thirdLineSb.append("-");
        }
        for (int i = 0; i < numberOfWhitespacesInSecondLine; i++) {
            thirdLineSb.append(" ");
        }
        if (firstSubtrahendLessThanSubDividend){
            thirdLineSb.delete(thirdLineSb.length()-1,thirdLineSb.length());
        }
        thirdLineSb.append("|");
        if (integerDivision.isDividendIsNegative()^integerDivision.isDivisorIsNegative()){
            thirdLineSb.append("-");
        }
        thirdLineSb.append(integerDivision.getActualQuotient());


//        //building other lines
        int lengthOfDividendInOutput = integerDivision.getDividendList().size() + 1;
        String res = "";
        String [] otherLinesBlocksArray = new String[integerDivision.getActualQuotientList().size()];
        char[] componentBlocksArray = new char[lengthOfDividendInOutput];
        StringBuilder whitespacesSb = new StringBuilder();
        for (int i = 0; i < componentBlocksArray.length; i++) {
            componentBlocksArray[i] = ' ';
        }
        for (char aChar : componentBlocksArray) {
            whitespacesSb.append(String.valueOf(aChar));
        }
        String justWhitespaces = whitespacesSb.toString();

        int currentSubDividend = firstSubDividend;
        int currentSubtrahend = firstSubtrahend;
        int currentRemainder = currentSubDividend - currentSubtrahend;
        int currentSubDividendLength = Integer.toString(currentSubDividend).length();

        boolean notEmpty;
        boolean breakthrough = false;
        int additionOffset = 0;
        if (Integer.toString(currentRemainder).length()<Integer.toString(currentSubtrahend).length()) {
            additionOffset++;
        }
        for (int i = 0; i < otherLinesBlocksArray.length - 1; i++) {
            String summary;
            StringBuilder substringOneSb = new StringBuilder(justWhitespaces);


            if (i>0&&currentRemainder>0&&Integer.toString(currentRemainder).length()==
                    Integer.toString(currentSubtrahend).length()){
                additionOffset = 0;
            }

            additionOffset += Integer.toString(currentSubtrahend).length()
                    - (Integer.toString(currentSubtrahend).length()
                    -(Integer.toString(currentSubDividend).length()
                    -Integer.toString(currentSubtrahend).length()));

            if (currentRemainder==0){
                additionOffset++;
            }

            currentSubDividend = currentRemainder * 10 + integerDivision.getDividendList().get(i + currentSubDividendLength);
            currentSubtrahend = (currentSubDividend / integerDivision.getDivisor()) * integerDivision.getDivisor();
            currentRemainder = currentSubDividend % integerDivision.getDivisor();

            if (breakthrough&&additionOffset!=0){
                additionOffset--;
            }
            if  (currentSubDividend/integerDivision.getDivisor()==0&&additionOffset!=0){
                additionOffset--;
            }

            if (currentSubDividend < integerDivision.getDivisor() || currentSubDividend / currentSubtrahend == 0) {
                notEmpty = false;

            } else {
                notEmpty = true;

                //construct substring #1
                substringOneSb.insert(i + additionOffset , "_" + currentSubDividend);
            }

            //construct substring #2
            StringBuilder substringTwoSb = new StringBuilder(justWhitespaces);
            substringTwoSb.insert(i + 1+ additionOffset, "" + currentSubtrahend);

            //construct substring #3
            StringBuilder substringThreeSb = new StringBuilder(justWhitespaces);
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
            //fitting to required length
            String subSOne = substringOneSb.substring(0, lengthOfDividendInOutput);
            String subSTwo = substringTwoSb.substring(0, lengthOfDividendInOutput);
            String subThree = substringThreeSb.substring(0, lengthOfDividendInOutput);

            if (integerDivision.isDividendIsNegative()){
                summary = " "+subSOne + "\n"+" " + subSTwo + "\n" +" "+ subThree;
            }else {
                summary = subSOne + "\n" + subSTwo + "\n" + subThree;
            }
            otherLinesBlocksArray[i] = summary;
            if (notEmpty) {
                res += otherLinesBlocksArray[i] + "\n";
            }else{
                breakthrough = true;
            }
        }
        otherLines = res;


        // building last line
        int indivRemainder = integerDivision.getIndivisibleRemainder();
        int indivRemainderLength = integerDivision.getIndivisibleRemainderLength();
        String lastString;
        String indivisibleRemainderString = "";
        char[] lastLineCharsArray = new char[lengthOfDividendInOutput];
        for (int i = 0; i < componentBlocksArray.length; i++) {
            lastLineCharsArray[i] = ' ';
        }
        for (char c : lastLineCharsArray) {
            indivisibleRemainderString += String.valueOf(c);
        }
        StringBuilder indivisibleRemainderBuilder = new StringBuilder(indivisibleRemainderString);
        if (integerDivision.isDividendIsNegative()){
            indivisibleRemainderBuilder.insert(lengthOfDividendInOutput+1 -
                    indivRemainderLength, indivRemainder);
        }else {
            indivisibleRemainderBuilder.insert(lengthOfDividendInOutput -
                    indivRemainderLength, indivRemainder);
        }

        firstLine = firstLineSb.toString();
        secondLine = secondLineSb.toString();
        thirdLine = thirdLineSb.toString();
        if (integerDivision.isDividendIsNegative()){
            lastString = indivisibleRemainderBuilder.toString().substring(0, lengthOfDividendInOutput+1);

        }else {
            lastString = indivisibleRemainderBuilder.toString().substring(0, lengthOfDividendInOutput);
        }

        result = firstLine + "\n" + secondLine + "\n" + thirdLine + "\n" + otherLines + lastString;
        return result;
    }
}
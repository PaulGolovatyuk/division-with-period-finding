package view;

import logic.IntegerDivision;

import java.util.ArrayList;
import java.util.List;

public class ShowResult {
    private IntegerDivision integerDivision = new IntegerDivision(78945, 4);

    public String resultBuilder() {
        String result;
        StringBuilder firstStringSb = new StringBuilder();
        integerDivision.init();
        integerDivision.longDivision();

        //building string #1
        String first;
        List<String> firstStringList = new ArrayList<String>();
        firstStringList.add("_");
        firstStringList.add(String.valueOf(integerDivision.getDividend()));
        firstStringList.add("|");
        firstStringList.add(String.valueOf(integerDivision.getDivisor()));
        for (String s : firstStringList) {
            firstStringSb.append(s);
        }


        //building string #2
        StringBuilder secondStringSb = new StringBuilder();
        String second;
        List<String> secondStringList = new ArrayList<String>();

        secondStringList.add(" ");
        int numberOfWhitespacesSecondString;
        if (integerDivision.getSubdividendList().get(0).toString().length() >
                integerDivision.getSubtrahendList().get(0).toString().length()) {
            secondStringSb.append(" ");
        }
        secondStringList.add(integerDivision.getSubtrahendList().get(0).toString());
        for (String s : secondStringList) {
            secondStringSb.append(s);
        }
        numberOfWhitespacesSecondString = integerDivision.getDividendList().size() -
                integerDivision.getSubtrahendList().get(0).toString().length();
        for (int i = 0; i < numberOfWhitespacesSecondString; i++) {
            secondStringSb.append(" ");
        }
        secondStringSb.append("|");
        for (int i = 0; i < integerDivision.getActualQuotientList().size(); i++) {
            secondStringSb.append("-");
        }

        //building string #3
        String other = "";
        StringBuilder sbThree = new StringBuilder();
        String third;
        sbThree.append(" ");
        for (int i = 0; i < integerDivision.getSubtrahendList().get(0).toString().length(); i++) {
            sbThree.append("-");
        }
        for (int i = 0; i < numberOfWhitespacesSecondString; i++) {
            sbThree.append(" ");
        }
        sbThree.append("|");
        sbThree.append(integerDivision.getActualQuotient());


//        //building other strings
        String[] strings = new String[integerDivision.getActualQuotientList().size()];//5
        String res = "";
        char[] chars = new char[integerDivision.getDividendList().size() + 1];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = ' ';
        }

        StringBuilder whitespacesSb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            whitespacesSb.append(String.valueOf(chars[i]));
        }
        String justWhitespaces = whitespacesSb.toString();

        for (int i = 0; i < strings.length - 1; i++) {
            String summary = "";
            String subStringOne = justWhitespaces;
            //construct substring #1
            StringBuilder substringOneSb = new StringBuilder(subStringOne);
            substringOneSb.insert(i, "_" + integerDivision.getSubDividendListToPrint().get(i).toString());
            //construct substring #2
            StringBuilder substringTwoSb = new StringBuilder(subStringOne);
            substringTwoSb.insert(i + 1, "" + integerDivision.getActualQuotientList().get(i + 1) * integerDivision.getDivisor());
            //construct substring #3
            StringBuilder substringThreeSb = new StringBuilder(subStringOne);
            StringBuilder dashes = new StringBuilder();
            for (int j = 0; j < integerDivision.getSubDividendListToPrint().get(i).toString().length(); j++) {
                dashes.append("-");

            }
            substringThreeSb.insert(i + 1, "" + dashes.toString());
            summary = "" + substringOneSb + "\n" + substringTwoSb + "\n" + substringThreeSb;
            strings[i] = summary;
        }
        for (int i = 0; i < strings.length - 1; i++) {
            res += strings[i] + "\n";
        }
        other = res;


        // building last string
        String lastString = "";
        String indivisibleRemainderString = "";
        char[] chars1 = new char[integerDivision.getDividendList().size() + 1];
        for (int i = 0; i < chars.length; i++) {
            chars1[i] = ' ';
        }
        for (char c : chars1) {
            indivisibleRemainderString += String.valueOf(c);
        }
        StringBuilder indivisibleRemainderBuilder = new StringBuilder(indivisibleRemainderString);
        indivisibleRemainderBuilder.insert(indivisibleRemainderString.length() -
                integerDivision.getIndivisibleRemainderLength(), integerDivision.getIndivisibleRemainder());

        first = firstStringSb.toString();
        second = secondStringSb.toString();
        third = sbThree.toString();
        lastString = indivisibleRemainderBuilder.toString();

        result = first + "\n" + second + "\n" + third + "\n" + other + lastString;
        return result;
    }
}
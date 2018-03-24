package view;

import logic.IntegerDivision;

import java.util.ArrayList;
import java.util.List;

public class ShowResult {
    private IntegerDivision integerDivision = new IntegerDivision(78945, 46);


    public String resultBuilder() {
        String result;
        StringBuilder sbOne = new StringBuilder();
        integerDivision.init();
        integerDivision.longDivision();
        
        //building string #1
        String first;
        List<String> firstString = new ArrayList<String>();
        firstString.add("_");
        firstString.add(String.valueOf(integerDivision.getDividend()));
        firstString.add("|");
        firstString.add(String.valueOf(integerDivision.getDivisor()));
        for (String s : firstString) {
            sbOne.append(s);
        }
        first = sbOne.toString();


        //building string #2
        StringBuilder sbTwo = new StringBuilder();
        String second;
        List<String> secondString = new ArrayList<String>();

        secondString.add(" ");
        int numberOfWhitespacesSecondString;
        if (integerDivision.getSubdividendList().get(0).toString().length() >
                integerDivision.getSubtrahendList().get(0).toString().length()) {
            sbTwo.append(" ");
        }
        secondString.add(integerDivision.getSubtrahendList().get(0).toString());
        for (String s : secondString) {
            sbTwo.append(s);
        }
        numberOfWhitespacesSecondString = integerDivision.getDividendList().size() -
                integerDivision.getSubtrahendList().get(0).toString().length();
        for (int i = 0; i < numberOfWhitespacesSecondString; i++) {
            sbTwo.append(" ");
        }
        sbTwo.append("|");
        for (int i = 0; i < integerDivision.getActualQuotientList().size(); i++) {
            sbTwo.append("-");
        }


        //building string #3
        String other = "";
        StringBuilder sbThree = new StringBuilder();
        String third;
        List<String> thirdString = new ArrayList<String>();
        sbThree.append(" ");
        for (int i = 0; i < integerDivision.getSubtrahendList().get(0).toString().length(); i++) {
            sbThree.append("-");
        }
        for (int i = 0; i < numberOfWhitespacesSecondString; i++) {
            sbThree.append(" ");
        }
        sbThree.append("|");
        sbThree.append(integerDivision.getActualQuotient());

        third = sbThree.toString();

        second = sbTwo.toString();

//        //building other strings
        String[] strings = new String[integerDivision.getActualQuotientList().size()];//5
        StringBuilder sb = new StringBuilder();
        String res = "";
        char[] chars = new char[integerDivision.getDividendList().size() + 1];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = ' ';
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(String.valueOf(chars[i]));
        }
        String justWhitespaces = stringBuilder.toString();

        for (int i = 0; i < strings.length - 1; i++) {
            String summary = "";
            String subStringOne = justWhitespaces;
            StringBuilder stringBuilder0 = new StringBuilder(subStringOne);

            stringBuilder0.insert(i, "_" + integerDivision.getSubDividendListToPrint().get(i).toString());

            String subStringTwo = justWhitespaces;
            StringBuilder stringBuilder1 = new StringBuilder(subStringOne);
            stringBuilder1.insert(i + 1, "" + integerDivision.getActualQuotientList().get(i + 1) * integerDivision.getDivisor());

            String subStringThree = justWhitespaces;
            StringBuilder stringBuilder2 = new StringBuilder(subStringOne);
            StringBuilder dashes = new StringBuilder();
            for (int j = 0; j < integerDivision.getSubDividendListToPrint().get(i).toString().length(); j++) {
                dashes.append("-");

            }
            stringBuilder2.insert(i + 1, "" + dashes.toString());

            summary = "" + stringBuilder0 + "\n" + stringBuilder1 + "\n" + stringBuilder2;

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

        lastString = indivisibleRemainderBuilder.toString();

        result = first + "\n" + second + "\n" + third + "\n" + other + lastString;
        return result;
    }
}
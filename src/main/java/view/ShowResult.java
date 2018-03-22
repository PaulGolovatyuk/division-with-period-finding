package view;

import logic.IntegerDivision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowResult {
    private IntegerDivision integerDivision = new IntegerDivision(78945, 48);


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
        char [] arr = new char[integerDivision.getDividendList().size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =  ' ';
        }
        for (int i = 0; i < integerDivision.getActualQuotientList().size(); i++) {
            
        }




        result = first+"\n"+second+"\n"+third;
        return result;
    }

    public void show(){
       integerDivision.longDivision();
    }
    public List<String> fromIntegerListToStringList(List<Integer> integers){
        List<String> resultList = new ArrayList<String>();
        for (int i = 0; i <integers.size()-1 ; i++) {
            resultList.add(integers.get(i).toString());
        }
        return resultList;
    }
}

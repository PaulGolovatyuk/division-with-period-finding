package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerDivision {
    private Integer dividend;
    private Integer divisor;
    private Integer quotient;


    public IntegerDivision(Integer dividend, Integer divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    public List<Integer> fromIntToList(Integer i) {
        List<Integer> integers = new ArrayList<Integer>(2);
        char[] intCharArray = i.toString().toCharArray();
        for (int j = 0; j < intCharArray.length; j++) {
            integers.add(Integer.parseInt(String.valueOf(intCharArray[j])));
        }
        return integers;
    }
//
//    public int fromListToInt(List<Integer> integers) {
//        int result = 0;
//        for (Integer integer : integers) {
//            result = 10 * result + integer;
//        }
//        return result;
//    }

    public int  longDivision(){
        int result;
        int remainder = 0;
        int actualQuotient = dividend/divisor;
        int subDividend = 0;
        int partOfQuotient;
        int actualIndivisible = dividend%divisor;

        StringBuilder sb = new StringBuilder();

        List<Integer> dividendList = fromIntToList(dividend);

        for (int i = 0; i < dividendList.size(); ) {
            if (dividendList.get(i)==0&&subDividend==0){
                if (i==dividendList.size()-1) {
                    sb.append("0");
                    break;
                }else {
                    sb.append("0");
                    ++i;
                    subDividend = dividendList.get(i);
                }
            }
            while (subDividend<divisor) {
                subDividend = subDividend * 10 + dividendList.get(i);
                if (subDividend<divisor) {
                    i++;
                }
            }

            partOfQuotient = subDividend/divisor;
            sb.append(partOfQuotient);
            remainder = subDividend - partOfQuotient*divisor;

            i++;

            subDividend = remainder;

        }
        result = Integer.parseInt(sb.toString());
        return result;
    }

}



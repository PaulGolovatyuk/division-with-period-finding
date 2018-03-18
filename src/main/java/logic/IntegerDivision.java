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

    public int fromListToInt(List<Integer> integers) {
        int result = 0;
        for (Integer integer : integers) {
            result = 10 * result + integer;
        }
        return result;
    }

//    public Integer quotientBuilder() {
//        List<Integer> dividendList = new ArrayList<Integer>();
//        List<Integer> quitientList = new ArrayList<Integer>();
//        List<Integer> subDividendList = new ArrayList<Integer>();
//        Integer subDividendInt = null;
//        Integer indivisibleRemainder = 0;
//        Integer quitientInt = null;
//
//
//        dividendList = fromIntToList(dividend);
//        for (int i = 0; i <dividendList.size()-1 ;) {
//            int remainder = 0;
//            if (subDividendInt==null) {
//                subDividendInt = dividendList.get(i);
//            }
//
//            if (subDividendInt/divisor!=0&&subDividendInt<10&&subDividendInt>6){
//                subDividendList.add(0, dividendList.get(i));
//                subDividendInt = fromListToInt(subDividendList);
//                remainder = subDividendInt%divisor;
//                quitientList.add(subDividendInt/divisor);
//                i++;
//            }
//
//
//            else {
//                if (subDividendList.isEmpty()) {
//                    subDividendList.add(0, dividendList.get(i));
//                    subDividendList.add(1, dividendList.get(i + 1));
//                    subDividendInt = fromListToInt(subDividendList);
//                }
//                remainder = subDividendInt%divisor;
//                quitientList.add(subDividendInt/divisor);
//                quitientInt = fromListToInt(quitientList);
//                if (remainder==0&&i<dividendList.size()-2){
//                }
//
//                subDividendList.clear();
//                i++;
//                subDividendList.add(0, remainder);
//                subDividendList.add(1, dividendList.get(i+1));
//                subDividendInt = fromListToInt(subDividendList);
//                if (dividendList.get(dividendList.size() - 1) ==0){
//
//                    quitientInt *=10;
//                }
//                if (subDividendInt<divisor){
//                    indivisibleRemainder = subDividendInt;
//                    break;
//                }
//            }
//        }
//
//
//        return quitientInt; //just for exam
//    }
}



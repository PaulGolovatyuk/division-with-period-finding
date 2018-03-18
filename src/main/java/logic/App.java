package logic;

import java.util.List;

public class App {
    public static void main(String[] args) {

        IntegerDivision integerDivision = new IntegerDivision(66, 6);

//        System.out.println(integerDivision.fromIntToList(56));
//        List<Integer> list = integerDivision.fromIntToList(798);
//
//        System.out.println(integerDivision.fromListToInt(list));

        System.out.println(integerDivision.quotientBuilder());

    }
}

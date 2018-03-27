package logic;

public class Demo {
    public static void main(String[] args) {
        IntegerDivision integerDivision = new IntegerDivision();
        integerDivision.longDivision(25025, 25);
        System.out.println(integerDivision.getDividendList());
        System.out.println(integerDivision.getSubdividendList());
        System.out.println(integerDivision.getSubDividendListToPrint());

        System.out.println();
        System.out.println(integerDivision.getSubtrahendList());
 //       System.out.println(integerDivision.getSubtrahendListToPrint());
    }
}

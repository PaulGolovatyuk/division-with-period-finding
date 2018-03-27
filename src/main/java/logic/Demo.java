package logic;

public class Demo {
    public static void main(String[] args) {
        IntegerDivision integerDivision = new IntegerDivision();
        integerDivision.init();
        integerDivision.longDivision(25000,  5);

        System.out.println("subDividendList "+integerDivision.getSubdividendList());
        System.out.println();
        System.out.println("subtrahendList "+ integerDivision.getSubtrahendList());
        System.out.println();

        System.out.println("subdividendListToPrint "+integerDivision.getSubDividendListToPrint());
        System.out.println();
//        System.out.println("subtrahendListToPrint" +integerDivision.getSu);
//
//        String s = "123455";
//        String newS = s.substring(0, 3);
//        System.out.println(newS);
//        int g = -2;
//        int j = g/2;
//        System.out.println(j);
    }
}

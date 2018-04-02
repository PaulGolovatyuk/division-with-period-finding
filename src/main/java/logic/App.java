package logic;

import view.ShowResult;


public class App {
    public static void main(String[] args) {
        IntegerDivision division = new IntegerDivision();
        ShowResult showResult  = new ShowResult();
        System.out.println(showResult.resultBuilder(division, 1034, 15));
        System.out.println("-------------------");
        System.out.println(showResult.resultBuilder(division, 500000, 2));
        System.out.println("-------------------");
        System.out.println(showResult.resultBuilder(division, 500000, 3));
        System.out.println("-------------------");
        System.out.println(showResult.resultBuilder(division, 15, 15));
        System.out.println("-------------------");
        System.out.println(showResult.resultBuilder(division, 1474, 3));
        System.out.println("-------------------");
        System.out.println(showResult.resultBuilder(division, 78459, 4));
        System.out.println("-------------------");
        System.out.println(showResult.resultBuilder(division, 234, 3));
        System.out.println("-------------------");
        System.out.println(showResult.resultBuilder(division, 6563, 32));
        System.out.println("-------------------");
        System.out.println(showResult.resultBuilder(division, 22, 7));
        System.out.println("-------------------");
        System.out.println(showResult.resultBuilder(division, 1234567, 98));
    }
}

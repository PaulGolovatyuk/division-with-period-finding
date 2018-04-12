package logic;

import view.ShowResult;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        DivisionWithPeriodFinding divisionWithPeriodFinding = new DivisionWithPeriodFinding();
        ShowResult showResult = new ShowResult();
      System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 78459, 4));
        System.out.println("-------------------");
        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 7, 12));
        System.out.println("-------------------");
        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 500000, 6));
        System.out.println("-------------------");
       System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 500000, 3));
        System.out.println("-------------------");
        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 25, 25));
      System.out.println("-------------------");
        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 25, 39));//todo solve problem
        System.out.println("-------------------");
        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 78459, 4));
        System.out.println("-------------------");
        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 234, 3));///todo solve problem
        System.out.println("-------------------");
        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 6563, 32));
        System.out.println("-------------------");
        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 22, 7));//todo fix
        System.out.println("-------------------");
        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 1234567, 98));
    }
}

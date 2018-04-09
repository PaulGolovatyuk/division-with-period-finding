package logic;

import view.ShowResult;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        DivisionWithPeriodFinding divisionWithPeriodFinding = new DivisionWithPeriodFinding();
        ShowResult showResult = new ShowResult();
        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 25, 39));
//        System.out.println("-------------------");
//        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 500000, 6));
//        System.out.println(divisionWithPeriodFinding.findingPeriod(1000, 3));
//        System.out.println("length is "+divisionWithPeriodFinding.getLengthofRepeatedSequence());
//        System.out.println("first digit if period is " + divisionWithPeriodFinding.getStartOfRepeatedSequence());
//        System.out.println("first appearance index is " + divisionWithPeriodFinding.getFirstAppearanceIndex());
//        System.out.println("period is "+ Arrays.toString(divisionWithPeriodFinding.getPeriodSequenceCharsArray()));
//        System.out.println("terminated sequence "+ Arrays.toString(divisionWithPeriodFinding.getTerminatedSequenceCharsArray()));
//        System.out.println("is terminated sequence empty "+divisionWithPeriodFinding.isTerminatedSequenceEmpty);
//        System.out.println("-------------------");
//       System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 500000, 3));
//        System.out.println("-------------------");
//        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 15, 15));
//        System.out.println("-------------------");
//        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 25, 39));
//        System.out.println("-------------------");
//        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 78459, 4));
//        System.out.println("-------------------");
//        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 234, 3));
//        System.out.println("-------------------");
//        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 6563, 32));
//        System.out.println("-------------------");
//        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 22, 7));
//        System.out.println("-------------------");
//        System.out.println(showResult.buildOutputStringOfDivision(divisionWithPeriodFinding, 1234567, 98));
    }
}

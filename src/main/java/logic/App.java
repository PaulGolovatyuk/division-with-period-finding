package logic;

import view.ShowResult;


public class App {
    public static void main(String[] args) {
        IntegerDivision  integerDivision = new IntegerDivision();
        ShowResult showResult = new ShowResult();
        System.out.println(showResult.resultBuilder(integerDivision, 654, 15));

    }
}

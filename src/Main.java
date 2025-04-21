import calculator.ArithmeticCalculator;
import inputhandler.InputHandler;
import operator.Operator;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calc = new ArithmeticCalculator();
        InputHandler inputHandler = new InputHandler();

        boolean repeat = false;
        double result = 0.0;

        do {
            double number1 = inputHandler.getNumber();
            double number2 = inputHandler.getNumber();
            Operator operator = inputHandler.getOperator();

            try {
                result = calc.evaluateExpression(number1, number2, operator);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            repeat = !inputHandler.wantToTerminate();
        } while(repeat);

        checkHistoryFunctions(calc);
    }

    private static void checkHistoryFunctions(ArithmeticCalculator calc) {
        printHistory(calc.getHistory());

        calc.removeOldestHistory();
        printHistory(calc.getHistory());

        double exclusiveLowerBound = 2.0;
        printHistory(calc.getHistoryGreaterThan(exclusiveLowerBound));
    }

    private static void printHistory(List<Double> history) {
        System.out.println("Printing current history");
        System.out.println(history);
    }
}
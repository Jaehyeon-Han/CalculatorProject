import calculator.ArithmeticCalculator;
import inputhandler.InputHandler;
import operator.DoubleBinaryOperator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArithmeticCalculator calc = new ArithmeticCalculator();
        InputHandler inputHandler = new InputHandler();

        do {
            double number1 = inputHandler.getNumber();
            double number2 = inputHandler.getNumber();
            DoubleBinaryOperator doubleBinaryOperator = inputHandler.getDoubleBinaryOperator();

            System.out.println("Result: " + calc.evaluateExpression(number1, number2, doubleBinaryOperator));
        } while (!inputHandler.checkForExit());

        checkHistoryFunctions(calc);
    }

    private static void checkHistoryFunctions(ArithmeticCalculator calc) {
        printHistory("Printing current history", calc.getHistory());

        calc.removeOldestHistory();
        printHistory("Printing history after removing first", calc.getHistory());

        double exclusiveLowerBound = 5.0;
        printHistory("Printing history greater than " + exclusiveLowerBound, calc.getHistoryGreaterThan(exclusiveLowerBound));
    }

    private static void printHistory(String message, List<Double> history) {
        System.out.println(message);
        System.out.println(history);
    }
}
import calculator.ArithmeticCalculator;
import inputhandler.InputHandler;
import operator.BinaryOperator;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArithmeticCalculator calc = new ArithmeticCalculator();
        InputHandler inputHandler = new InputHandler();

        do {
            double number1 = inputHandler.getNumber();
            double number2 = inputHandler.getNumber();
            BinaryOperator binaryOperator = inputHandler.getOperator();

            System.out.println("Result: " + calc.evaluateExpression(number1, number2, binaryOperator));
        } while (!inputHandler.wantToTerminate());

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
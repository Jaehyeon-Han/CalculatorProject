import calculator.ArithmeticCalculator;
import operator.Operator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean repeat = false;
        double result = 0.0;

        ArithmeticCalculator calc = new ArithmeticCalculator();

        do {
            System.out.println("Enter number: ");
            int number1 = Integer.parseInt(sc.nextLine());
            System.out.println("Enter number: ");
            int number2 = Integer.parseInt(sc.nextLine());
            System.out.println("Enter operator: ");
            char operator = sc.nextLine().charAt(0);

            try {
                result = calc.evaluateExpression(number1, number2, Operator.fromChar(operator));
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println("Enter \"exit\" to stop");
            repeat = !sc.nextLine().equals("exit");
        } while(repeat);

        System.out.println("Printing current history");
        System.out.println(calc.getHistory());

        calc.removeOldestHistory();
        System.out.println("Printing history after deleting first");
        System.out.println(calc.getHistory());

        double exclusiveLowerBound = 2.0;
        System.out.println("Printing history greater than " + exclusiveLowerBound);
        System.out.println(calc.getHistoryGreaterThan(exclusiveLowerBound));
    }
}
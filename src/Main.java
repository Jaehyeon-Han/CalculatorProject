import calculator.Calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean repeat = false;
        double result = 0.0;

        Calculator calc = new Calculator();

        do {
            System.out.println("Enter number: ");
            int number1 = Integer.parseInt(sc.nextLine());
            System.out.println("Enter number: ");
            int number2 = Integer.parseInt(sc.nextLine());
            System.out.println("Enter operator: ");
            char operator = sc.nextLine().charAt(0);

            try {
                result = calc.evaluateExpression(number1, number2, operator);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println("Enter \"exit\" to terminate");
            repeat = !sc.nextLine().equals("exit");
        } while (repeat);

        Deque<Double> history = calc.getHistory();
        for (Double num : history) {
            System.out.println(num);
        }

        Deque<Double> emptyHistory = new ArrayDeque<>();
        calc.setHistory(emptyHistory);
        System.out.println("No result expected");
        for (Double num : calc.getHistory()) {
            System.out.println(num); // Should be empty
        }
    }
}
package inputhandler;

import operator.DoubleBinaryOperator;

import java.io.InputStream;
import java.util.Scanner;

public class InputHandler {
    private final Scanner sc;

    public InputHandler(InputStream is) {
        sc = new Scanner(is);
    }

    public InputHandler() {
        sc = new Scanner(System.in);
    }

    public double getNumber()  {
        while(true) {
            System.out.println("Enter number: ");
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public DoubleBinaryOperator getDoubleBinaryOperator() {
        String input;

        while(true) {
            System.out.println("Enter operator: ");
            try {
                input = sc.nextLine();
                return DoubleBinaryOperator.fromChar(input.charAt(0));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Empty input is not allowed.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid operator");
            }
        }
    }

    public boolean checkForExit() {
        System.out.println("Enter \"exit\" to terminate");
        String input = sc.nextLine();
        return input.equals("exit");
    }
}

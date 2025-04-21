package inputhandler;

import operator.BinaryOperator;

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

    // 테스트 불가능??
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

    public BinaryOperator getOperator() {
        String input;

        while(true) {
            System.out.println("Enter operator: ");
            try {
                input = sc.nextLine();
                return BinaryOperator.fromChar(input.charAt(0));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Empty input is not allowed.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid operator");
            }
        }
    }

    public boolean wantToTerminate() {
        System.out.println("Enter \"exit\" to terminate");
        String input = sc.nextLine();
        return input.equals("exit");
    }
}

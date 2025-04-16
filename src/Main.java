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
            System.out.println("Enter operand: ");
            char operand = sc.nextLine().charAt(0);

            try {
                result = calc.evaluateExpression(number1, number2, operand);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println("Enter \"exit\" to stop");
            repeat = !sc.nextLine().equals("exit");
        } while(repeat);
    }
}
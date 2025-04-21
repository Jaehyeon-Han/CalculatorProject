import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean repeat = false;

        do {
            System.out.println("Enter number: ");
            int number1 = Integer.parseInt(sc.nextLine());
            System.out.println("Enter number: ");
            int number2 = Integer.parseInt(sc.nextLine());
            System.out.println("Enter operator: ");
            char operator = sc.nextLine().charAt(0);

            int result = 0;
            try {
                switch(operator) {
                    case '+': result = number1 + number2; break;
                    case '-': result = number1 - number2; break;
                    case '/': result = number1 / number2; break;
                    case '*': result = number1 * number2; break;
                    default: throw new IllegalArgumentException("Unknown operator");
                }
            } catch (ArithmeticException e) {
                System.err.println("can't divide by 0");
            }
            catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }

            System.out.println("Result: " + result);
            System.out.println("Enter \"exit\" to terminate");
            repeat = !sc.nextLine().equals("exit");
        } while(repeat);
    }
}
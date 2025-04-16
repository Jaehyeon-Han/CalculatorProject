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
            System.out.println("Enter operand: ");
            char operand = sc.nextLine().charAt(0);

            double result = 0.0;
            try {
                switch(operand) {
                    case '+': result = number1 + number2; break;
                    case '-': result = number1 - number2; break;
                    case '/': result = (double) number1 / number2; break;
                    case '*': result = number1 * number2; break;
                    default: throw new Exception("Unknown operand");
                }
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println("Enter \"exit\" to stop");
            repeat = !sc.nextLine().equals("exit");
        } while(repeat);
    }
}
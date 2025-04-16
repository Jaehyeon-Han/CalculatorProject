import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number1 = Integer.parseInt(sc.nextLine());
        System.out.println("Enter number: ");
        int number2 = Integer.parseInt(sc.nextLine());
        System.out.println("Enter operand: ");
        char operand = sc.nextLine().charAt(0);

        int result = 0;
        try {
            switch(operand) {
                case '+': result = number1 + number2; break;
                case '-': result = number1 - number2; break;
                case '/': result = number1 / number2; break;
                case '*': result = number1 * number2; break;
                default: throw new Exception("Unknown operand");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println(result);

    }
}
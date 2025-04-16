import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class Calculator {
    private Deque<Double> history = new ArrayDeque<>();

    public double evaluateExpression(int num1, int num2, char operand) {
        double result = 0.0;

        switch (operand) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '/':
                result = (double) num1 / num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            default:
                throw new RuntimeException("Unknown operand");
        }

        history.offer(result);
        return result;
    }

    public Optional<Double> removeOldestHistory() {
        Double oldestHistory = history.pollFirst();
        return Optional.ofNullable(oldestHistory);
    }
}

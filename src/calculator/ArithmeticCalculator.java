package calculator;

import operator.Operator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

public class ArithmeticCalculator {
    private Deque<Double> history = new ArrayDeque<>();

    public double evaluateExpression(int num1, int num2, Operator operator) {
        double result = 0.0;

        switch (operator) {
            case PLUS:
                result = num1 + num2;
                break;
            case MINUS:
                result = num1 - num2;
                break;
            case DIV:
                result = (double) num1 / num2;
                break;
            case MUL:
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

    public List<Double> getHistory() {
        return history.stream().toList();
    }
}

package calculator;

import operator.BinaryOperator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

public class ArithmeticCalculator {
    private final Deque<Double> history = new ArrayDeque<>();

    public <T extends Number> double evaluateExpression(T number1, T number2, BinaryOperator binaryOperator) {
        double num1 = number1.doubleValue();
        double num2 = number2.doubleValue();
        double result = binaryOperator.apply(num1, num2);

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

    public List<Double> getHistoryGreaterThan(double exclusiveLowerBound) {
        return history.stream()
                .filter(Double::isFinite)
                .filter(n -> n > exclusiveLowerBound)
                .toList();
    }
}

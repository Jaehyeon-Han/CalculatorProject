package test;

import calculator.ArithmeticCalculator;
import operator.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticCalculatorTest {
    private ArithmeticCalculator calc;

    @BeforeEach
    void init() {
        calc = new ArithmeticCalculator();
    }

    @Test
    void evaluateExpression() {
        // +
        double plusResult = calc.evaluateExpression(1, 2, Operator.fromChar('+'));
        assertEquals(3, plusResult);

        // -
        double minusResult1 = calc.evaluateExpression(1, 2, Operator.fromChar('-'));
        double minusResult2 = calc.evaluateExpression(3, 2, Operator.fromChar('-'));

        assertEquals(-1, minusResult1);
        assertEquals(1, minusResult2);

        // *
        double multiplyResult1 = calc.evaluateExpression(2, 5, Operator.fromChar('*'));
        double multiplyResult2 = calc.evaluateExpression(3, -9, Operator.fromChar('*'));

        assertEquals(10, multiplyResult1);
        assertEquals(-27, multiplyResult2);

        // /
        double divisionResult1 = calc.evaluateExpression(1, 2, Operator.fromChar('/'));
        double divisionResult2 = calc.evaluateExpression(100, 0, Operator.fromChar('/'));
        double divisionResult3 = calc.evaluateExpression(0, 0, Operator.fromChar('/'));

        assertEquals(0.5, divisionResult1);
        assertTrue(Double.isInfinite(divisionResult2));
        assertTrue(Double.isNaN(divisionResult3));

        // Unknown operand
        assertThrows(RuntimeException.class, () -> calc.evaluateExpression(1, 2, Operator.fromChar('^')));
    }

    @Test
    void removeOldestHistory() {
        calc.evaluateExpression(0, 1, Operator.fromChar('+'));
        calc.evaluateExpression(0, 2, Operator.fromChar('+'));
        calc.evaluateExpression(0, 3, Operator.fromChar('+'));

        assertEquals(List.of(1.0, 2.0, 3.0), calc.getHistory());

        calc.removeOldestHistory();
        assertEquals(List.of(2.0, 3.0), calc.getHistory());
    }
}
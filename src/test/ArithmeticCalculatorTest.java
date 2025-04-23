package test;

import calculator.ArithmeticCalculator;
import operator.DoubleBinaryOperator;
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
        double plusResult = calc.evaluateExpression(1, 2, DoubleBinaryOperator.fromChar('+'));
        assertEquals(3, plusResult);

        // -
        double minusResult1 = calc.evaluateExpression(1, 2, DoubleBinaryOperator.fromChar('-'));
        double minusResult2 = calc.evaluateExpression(3, 2, DoubleBinaryOperator.fromChar('-'));

        assertEquals(-1, minusResult1);
        assertEquals(1, minusResult2);

        // *
        double multiplyResult1 = calc.evaluateExpression(2, 5, DoubleBinaryOperator.fromChar('*'));
        double multiplyResult2 = calc.evaluateExpression(3, -9, DoubleBinaryOperator.fromChar('*'));

        assertEquals(10, multiplyResult1);
        assertEquals(-27, multiplyResult2);

        // /
        double divisionResult1 = calc.evaluateExpression(1, 2, DoubleBinaryOperator.fromChar('/'));
        double divisionResult2 = calc.evaluateExpression(100, 0, DoubleBinaryOperator.fromChar('/'));
        double divisionResult3 = calc.evaluateExpression(0, 0, DoubleBinaryOperator.fromChar('/'));

        assertEquals(0.5, divisionResult1);
        assertTrue(Double.isInfinite(divisionResult2));
        assertTrue(Double.isNaN(divisionResult3));

        // Unknown operand
        assertThrows(RuntimeException.class, () -> calc.evaluateExpression(1, 2, DoubleBinaryOperator.fromChar('^')));
    }

    @Test
    void doubleInputEvaluation() {
        double plusResult = calc.evaluateExpression(1.3, 2.5, DoubleBinaryOperator.fromChar('+'));
        assertEquals(3.8, plusResult);
    }

    @Test
    void removeOldestHistory() {
        calc.evaluateExpression(0, 1, DoubleBinaryOperator.fromChar('+'));
        calc.evaluateExpression(0, 2, DoubleBinaryOperator.fromChar('+'));
        calc.evaluateExpression(0, 3, DoubleBinaryOperator.fromChar('+'));

        assertEquals(List.of(1.0, 2.0, 3.0), calc.getHistory());

        calc.removeOldestHistory();
        assertEquals(List.of(2.0, 3.0), calc.getHistory());
    }

    @Test
    void getHistoryGreaterThan() {
        calc.evaluateExpression(0, 1, DoubleBinaryOperator.fromChar('+'));
        calc.evaluateExpression(0, 2, DoubleBinaryOperator.fromChar('+'));
        calc.evaluateExpression(0, 3, DoubleBinaryOperator.fromChar('+'));

        assertEquals(List.of(2.0, 3.0), calc.getHistoryGreaterThan(1.5));
    }
}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calc;

    @BeforeEach
    void init() {
        calc = new Calculator();
    }

    @Test
    void evaluateExpression() {
        // +
        double plusResult = calc.evaluateExpression(1, 2, '+');
        assertEquals(3, plusResult);

        // -
        double minusResult1 = calc.evaluateExpression(1, 2, '-');
        double minusResult2 = calc.evaluateExpression(3, 2, '-');

        assertEquals(-1, minusResult1);
        assertEquals(1, minusResult2);

        // *
        double multiplyResult1 = calc.evaluateExpression(2, 5, '*');
        double multiplyResult2 = calc.evaluateExpression(3, -9, '*');

        assertEquals(10, multiplyResult1);
        assertEquals(-27, multiplyResult2);

        // /
        double divisionResult1 = calc.evaluateExpression(1, 2, '/');
        double divisionResult2 = calc.evaluateExpression(100, 0, '/');
        double divisionResult3 = calc.evaluateExpression(0, 0, '/');

        assertEquals(0.5, divisionResult1);
        assertTrue(Double.isInfinite(divisionResult2));
        assertTrue(Double.isNaN(divisionResult3));

        // Unknown operand
        assertThrows(RuntimeException.class, () -> calc.evaluateExpression(1, 2, '^'));
    }

    @Test
    void removeOldestHistory() {
    }
}
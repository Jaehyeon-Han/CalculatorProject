package test;

import operator.DoubleBinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoubleBinaryOperatorTest {
    DoubleBinaryOperator plus = DoubleBinaryOperator.fromChar('+');
    DoubleBinaryOperator minus = DoubleBinaryOperator.fromChar('-');
    DoubleBinaryOperator mul = DoubleBinaryOperator.fromChar('*');
    DoubleBinaryOperator div = DoubleBinaryOperator.fromChar('/');

    @Test
    void fromChar() {
        assertEquals(DoubleBinaryOperator.PLUS, plus);
        assertEquals(DoubleBinaryOperator.MINUS, minus);
        assertEquals(DoubleBinaryOperator.MUL, mul);
        assertEquals(DoubleBinaryOperator.DIV, div);
        assertThrows(IllegalArgumentException.class, () -> {
            DoubleBinaryOperator.fromChar('&');
        });
    }

    @Test
    void apply() {
        assertEquals(3.0, plus.apply(1, 2));
        assertEquals(-2.3, minus.apply(2, 4.3));
        assertEquals(4.8, mul.apply(2.4, 2));
        assertTrue(Math.abs(3.3 - div.apply(9.9, 3)) < 0.001);
        assertEquals(Double.POSITIVE_INFINITY, div.apply(2, 0));
    }
}
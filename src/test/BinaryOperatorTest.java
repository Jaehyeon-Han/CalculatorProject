package test;

import operator.BinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryOperatorTest {
    BinaryOperator plus = BinaryOperator.fromChar('+');
    BinaryOperator minus = BinaryOperator.fromChar('-');
    BinaryOperator mul = BinaryOperator.fromChar('*');
    BinaryOperator div = BinaryOperator.fromChar('/');

    @Test
    void fromChar() {
        assertEquals(BinaryOperator.PLUS, plus);
        assertEquals(BinaryOperator.MINUS, minus);
        assertEquals(BinaryOperator.MUL, mul);
        assertEquals(BinaryOperator.DIV, div);
        assertThrows(IllegalArgumentException.class, () -> {
            BinaryOperator.fromChar('&');
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
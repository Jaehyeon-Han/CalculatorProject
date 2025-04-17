package test;

import operator.Operator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class OperatorTest {
    @Test
    void fromChar() {
        Operator plus = Operator.fromChar('+');
        Operator minus = Operator.fromChar('-');
        Operator mul = Operator.fromChar('*');
        Operator div = Operator.fromChar('/');

        assertEquals(Operator.PLUS, plus);
        assertEquals(Operator.MINUS, minus);
        assertEquals(Operator.MUL, mul);
        assertEquals(Operator.DIV, div);
    }
}
package operator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public enum BinaryOperator {
    PLUS((n1, n2) -> n1 + n2),
    MINUS((n1, n2) -> n1 - n2),
    MUL((n1, n2) -> n1 * n2),
    DIV((n1, n2) -> n1 / n2);

    private final DoubleBinaryOperator functionToApply;

    BinaryOperator(DoubleBinaryOperator functionToApply) {
        this.functionToApply = functionToApply;
    }

    private static Map<Character, BinaryOperator> map = new HashMap<>();

    static {
        map.put('+', PLUS);
        map.put('-', MINUS);
        map.put('*', MUL);
        map.put('/', DIV);
    }

    public static BinaryOperator fromChar(char operatorChar) {
        BinaryOperator operator = map.get(operatorChar);
        if(operator == null) {
            throw new IllegalArgumentException();
        }

        return operator;
    }

    public double apply(double n1, double n2) {
        return this.functionToApply.applyAsDouble(n1, n2);
    }
}

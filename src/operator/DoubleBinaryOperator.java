package operator;

import java.util.HashMap;
import java.util.Map;

public enum DoubleBinaryOperator {
    PLUS((n1, n2) -> n1 + n2),
    MINUS((n1, n2) -> n1 - n2),
    MUL((n1, n2) -> n1 * n2),
    DIV((n1, n2) -> n1 / n2);

    private final java.util.function.DoubleBinaryOperator functionToApply;

    DoubleBinaryOperator(java.util.function.DoubleBinaryOperator functionToApply) {
        this.functionToApply = functionToApply;
    }

    private static final Map<Character, DoubleBinaryOperator> charOperatorMap = new HashMap<>();

    static {
        charOperatorMap.put('+', PLUS);
        charOperatorMap.put('-', MINUS);
        charOperatorMap.put('*', MUL);
        charOperatorMap.put('/', DIV);
    }

    public static DoubleBinaryOperator fromChar(char operatorChar) {
        DoubleBinaryOperator operator = charOperatorMap.get(operatorChar);
        if(operator == null) {
            throw new IllegalArgumentException();
        }

        return operator;
    }

    public double apply(double n1, double n2) {
        return this.functionToApply.applyAsDouble(n1, n2);
    }
}

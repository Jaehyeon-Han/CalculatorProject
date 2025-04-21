package operator;

import java.util.HashMap;
import java.util.Map;

public enum Operator {
    PLUS,
    MINUS,
    MUL,
    DIV;

    private static Map<Character, Operator> map = new HashMap<>();

    static {
        map.put('+', PLUS);
        map.put('-', MINUS);
        map.put('*', MUL);
        map.put('/', DIV);
    }

    public static Operator fromChar(char operatorChar) {
        Operator operator = map.get(operatorChar);
        if(operator == null) {
            throw new IllegalArgumentException();
        }

        return operator;
    }
}

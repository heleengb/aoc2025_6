package software.ulpgc.aoc.model;

import java.util.List;

public enum MathOperation {
    ADD, MULTIPLY;

    public long apply(List<Long> numbers) {
        if (this == MULTIPLY) {
            return numbers.stream().reduce(1L, (a, b) -> a * b);
        }
        return numbers.stream().reduce(0L, Long::sum);
    }

    public static MathOperation fromSymbol(String symbol) {
        return "*".equals(symbol) ? MULTIPLY : ADD;
    }
}
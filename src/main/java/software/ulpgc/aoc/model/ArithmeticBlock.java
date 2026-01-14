package software.ulpgc.aoc.model;

import java.util.List;

public class ArithmeticBlock {
    private final List<Long> numbers;
    private final MathOperation operation;

    public ArithmeticBlock(List<Long> numbers, MathOperation operation) {
        this.numbers = numbers;
        this.operation = operation;
    }

    public long compute() {
        return operation.apply(numbers);
    }
}
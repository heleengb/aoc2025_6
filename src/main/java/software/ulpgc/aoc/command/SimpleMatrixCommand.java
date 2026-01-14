package software.ulpgc.aoc.command;

import software.ulpgc.aoc.model.ArithmeticBlock;
import software.ulpgc.aoc.model.MathOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Parte 1: Matriz de numeros y la última fila son operadores
public class SimpleMatrixCommand implements CalculationCommand {

    @Override
    public long execute(List<String> rawData) {
        if (rawData.isEmpty()) return 0;

        List<String> numberLines = rawData.subList(0, rawData.size() - 1);
        String[] operators = rawData.get(rawData.size() - 1).split("\\s+");
        int width = operators.length;

        // Parseamos la matriz
        List<List<Long>> grid = numberLines.stream()
                .map(line -> Arrays.stream(line.trim().split("\\s+"))
                        .map(Long::parseLong)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        // Transponemos y calculamos
        return IntStream.range(0, width)
                .mapToObj(colIndex -> {
                    List<Long> colNumbers = grid.stream()
                            .map(row -> row.get(colIndex))
                            .collect(Collectors.toList());

                    return new ArithmeticBlock(colNumbers, MathOperation.fromSymbol(operators[colIndex]));
                })
                .mapToLong(ArithmeticBlock::compute)
                .sum();
    }
}
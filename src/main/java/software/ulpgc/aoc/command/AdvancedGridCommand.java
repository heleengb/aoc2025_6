package software.ulpgc.aoc.command;

import software.ulpgc.aoc.model.ArithmeticBlock;
import software.ulpgc.aoc.model.MathOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Estrategia Parte 2: Escaneo vertical (detectando huecos)
public class AdvancedGridCommand implements CalculationCommand {

    @Override
    public long execute(List<String> rawData) {
        return parseBlocks(rawData).stream()
                .mapToLong(ArithmeticBlock::compute)
                .sum();
    }

    private List<ArithmeticBlock> parseBlocks(List<String> rows) {
        List<ArithmeticBlock> blocks = new ArrayList<>();
        int width = rows.get(0).length();
        int height = rows.size();

        List<Long> currentNumbers = new ArrayList<>();
        MathOperation currentOp = MathOperation.ADD; // Default

        // Recorremos columnas de izquierda a derecha
        for (int col = 0; col < width; col++) {
            final int c = col;

            // Extraemos dígitos verticales
            String verticalNumStr = IntStream.range(0, height - 1)
                    .mapToObj(r -> rows.get(r).length() > c ? rows.get(r).charAt(c) : ' ')
                    .filter(Character::isDigit)
                    .map(String::valueOf)
                    .collect(Collectors.joining());

            // Detectamos operador en la base
            String lastLine = rows.get(height - 1);
            char opChar = (c < lastLine.length()) ? lastLine.charAt(c) : ' ';

            boolean hasNumber = !verticalNumStr.isEmpty();

            if (hasNumber) currentNumbers.add(Long.parseLong(verticalNumStr));
            if (opChar == '+' || opChar == '*') currentOp = MathOperation.fromSymbol(String.valueOf(opChar));

            // Si detectamos columna vacía, cerramos el bloque
            boolean isEmptyCol = !hasNumber && opChar == ' ';
            if (isEmptyCol && !currentNumbers.isEmpty()) {
                blocks.add(new ArithmeticBlock(new ArrayList<>(currentNumbers), currentOp));
                currentNumbers.clear();
                currentOp = MathOperation.ADD; // Reset
            }
        }

        // Añadir sobrante
        if (!currentNumbers.isEmpty()) {
            blocks.add(new ArithmeticBlock(currentNumbers, currentOp));
        }

        return blocks;
    }
}
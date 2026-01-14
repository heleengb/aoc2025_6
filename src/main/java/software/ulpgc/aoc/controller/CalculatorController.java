package software.ulpgc.aoc.controller;

import software.ulpgc.aoc.command.AdvancedGridCommand;
import software.ulpgc.aoc.command.SimpleMatrixCommand;

import java.util.List;

public class CalculatorController {

    // Procesa usando la lógica de la parte 1
    public long processSimpleMatrix(List<String> data) {
        return new SimpleMatrixCommand().execute(data);
    }

    // Procesa usando la lógica de la parte 2
    public long processComplexGrid(List<String> data) {
        return new AdvancedGridCommand().execute(data);
    }
}
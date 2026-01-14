package software.ulpgc.aoc;

import software.ulpgc.aoc.controller.CalculatorController;
import software.ulpgc.aoc.io.FileInputReader;
import software.ulpgc.aoc.view.ConsoleResultPrinter;

import java.nio.file.Path;

public class Main {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "calculo.txt");

    public static void main(String[] args) {
        try {
            // IO
            var data = new FileInputReader(INPUT_PATH).readLines();

            // CONTROLLER
            long result = new CalculatorController().processSimpleMatrix(data);

            // VIEW
            new ConsoleResultPrinter().show("Resultado parte 1 (Matriz Simple)", result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
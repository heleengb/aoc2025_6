package software.ulpgc.aoc.command;

import java.util.List;

public interface CalculationCommand {
    long execute(List<String> rawData);
}
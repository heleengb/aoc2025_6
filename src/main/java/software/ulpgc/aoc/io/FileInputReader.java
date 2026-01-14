package software.ulpgc.aoc.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileInputReader implements InputReader {
    private final Path path;

    public FileInputReader(Path path) {
        this.path = path;
    }

    @Override
    public List<String> readLines() throws IOException {
        return Files.readAllLines(path);
    }
}
package adventofcode.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Main {
    private static final Path PATH = Paths.get("src/main/java/adventofcode/day7/input.txt");
    private static final Logger LOGGER = Logger.getLogger(adventofcode.day6.Main.class.getName());

    public static void main(String[] args) {
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH.toString()))) {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
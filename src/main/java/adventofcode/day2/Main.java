package adventofcode.day2;

import java.util.logging.Logger;
import java.io.BufferedReader;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.FileReader;

public class Main {
    private static final Path PATH = Paths.get("src/main/java/adventofcode/day2/input.txt");
    private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );

    public static void main(String[] args) {

        partOne();
        partTwo();

    }
    public static void partOne(){
        int totalScore = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH.toString()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(!line.isEmpty()){
                    for (char character : line.toCharArray()) {
                        if (character == 'A') {
                            if (line.toCharArray()[2] == 'X'){
                                totalScore += 4;
                            }
                            if (line.toCharArray()[2] == 'Y'){
                                totalScore += 8;
                            }
                            if (line.toCharArray()[2] == 'Z'){
                                totalScore += 3;
                            }
                        }
                        if (character == 'B') {
                            if (line.toCharArray()[2] == 'X'){
                                totalScore += 1;
                            }
                            if (line.toCharArray()[2] == 'Y'){
                                totalScore += 5;
                            }
                            if (line.toCharArray()[2] == 'Z'){
                                totalScore += 9;
                            }
                        }
                        if (character == 'C') {
                            if (line.toCharArray()[2] == 'X'){
                                totalScore += 7;
                            }
                            if (line.toCharArray()[2] == 'Y'){
                                totalScore += 2;
                            }
                            if (line.toCharArray()[2] == 'Z'){
                                totalScore += 6;
                            }
                        }
                    }
                } else { LOGGER.info("Check input.txt for invalid characters."); }
            }
            LOGGER.info("\nYour total score would be: " + totalScore + "\n");
        } catch (Exception e){ LOGGER.info(e.toString()); }
    }
    public static void partTwo(){
        int totalScore = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH.toString()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(!line.isEmpty()){
                    for (char character : line.toCharArray()) {
                        if (character == 'A') {
                            if (line.toCharArray()[2] == 'X'){
                                totalScore += 3;
                            }
                            if (line.toCharArray()[2] == 'Y'){
                                totalScore += 4;
                            }
                            if (line.toCharArray()[2] == 'Z'){
                                totalScore += 8;
                            }
                        }
                        if (character == 'B') {
                            if (line.toCharArray()[2] == 'X'){
                                totalScore += 1;
                            }
                            if (line.toCharArray()[2] == 'Y'){
                                totalScore += 5;
                            }
                            if (line.toCharArray()[2] == 'Z'){
                                totalScore += 9;
                            }
                        }
                        if (character == 'C') {
                            if (line.toCharArray()[2] == 'X'){
                                totalScore += 2;
                            }
                            if (line.toCharArray()[2] == 'Y'){
                                totalScore += 6;
                            }
                            if (line.toCharArray()[2] == 'Z'){
                                totalScore += 7;
                            }
                        }
                    }
                } else { LOGGER.info("Check input.txt for invalid characters."); }
            }
            LOGGER.info("\nYour total score would be: " + totalScore + "\n");
        } catch (Exception e){ LOGGER.info(e.toString()); }
    }
}
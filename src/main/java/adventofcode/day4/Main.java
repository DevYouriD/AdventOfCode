package adventofcode.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;

public class Main {
    private static final Path PATH = Paths.get("src/main/java/adventofcode/day4/input.txt");
    private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );
    private static final List<String> characterList = new ArrayList<>();
    private static final List<String> partialList = new ArrayList<>();
    private static final List<String> finalList = new ArrayList<>();
    private static int counterPart1 = 0;
    private static int counterPart2 = 0;

    public static void main(String[] args) {

        doStuff();

    }

    public static void doStuff(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH.toString()))) {
            String baseChar = "";
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                for (char character : line.toCharArray()) {
                    if(Character.isDigit(character)){
                        baseChar += character;
                    }else {
                        partialList.add(baseChar);
                        baseChar = "";
                    }
                }
                characterList.add(baseChar);
                baseChar = "";

                finalList.addAll(partialList);
                finalList.addAll(characterList);

                characterList.clear();
                partialList.clear();

                assignValuesPartOne(finalList);
                assignValuesPartTwo(finalList);
            }
            LOGGER.info("\nThe amount contained within other pairs = " + counterPart1 + "\n");
            LOGGER.info("\nThe amount overlapping with other pairs = " + counterPart2);
        } catch (Exception e) { LOGGER.info(e.toString()); }
    }
    public static void assignValuesPartOne(List<String> finalList){
        int first = Integer.parseInt(finalList.get(0).toString());
        int second = Integer.parseInt(finalList.get(1).toString());
        int third = Integer.parseInt(finalList.get(2).toString());
        int fourth = Integer.parseInt(finalList.get(3).toString());

        if(first <= third && second >= fourth
                || third <= first && fourth >= second){
            counterPart1 += 1;
        }
    }
    public static void assignValuesPartTwo(List<String> finalList){
        int first = Integer.parseInt(finalList.get(0).toString());
        int second = Integer.parseInt(finalList.get(1).toString());
        int third = Integer.parseInt(finalList.get(2).toString());
        int fourth = Integer.parseInt(finalList.get(3).toString());

        if(first >= third && first <= fourth
                || second >= third && second <= fourth
                || third >= first && third <= second
                || fourth >= first && fourth <= second){
            counterPart2 += 1;
        }
        finalList.clear();
    }
}
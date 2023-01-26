package adventofcode.day3;

import java.util.logging.Logger;
import java.io.BufferedReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private static final Path PATH = Paths.get("src/main/java/adventofcode/day3/input.txt");
    private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );
    private static final List<Character> characterList = new ArrayList<>();
    private static int sumOfPriorityValues = 0;

    public static void main(String[] args) {

        partOne();
        partTwo();

    }
    public static void partOne(){
        sumOfPriorityValues = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH.toString()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    for (char character : line.toCharArray()) {
                        characterList.add(character);
                    }

                    // Divide and conquer
                    int middle = characterList.size() / 2;
                    List<Character> compartmentOne = new ArrayList<>(characterList.subList(0, middle));
                    List<Character> compartmentTwo = new ArrayList<>(characterList.subList(middle, characterList.size()));
                    compartmentOne.retainAll(compartmentTwo);

                    // Boil down
                    while(compartmentOne.size() > 1){
                        compartmentOne.remove(compartmentOne.size()-1);
                    }

                    // Assign values
                    String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    char input = compartmentOne.get(0);
                    int indexVal = letters.indexOf(input) + 1;
                    sumOfPriorityValues += indexVal;
                    characterList.clear();
                } else { LOGGER.info("Check input.txt for invalid characters."); }
            }
        } catch (Exception e) { LOGGER.info(e.toString()); }
        LOGGER.info("\nThe total sum of item priority types is: " + sumOfPriorityValues + "\n");
    }
    public static void partTwo(){
        List<Character> subList1 = new ArrayList<>();
        List<Character> subList2 = new ArrayList<>();
        List<Character> subList3 = new ArrayList<>();
        sumOfPriorityValues = 0;
        int counter = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH.toString()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    if(counter < 2){
                        for (char character : line.toCharArray()) {
                            characterList.add(character);
                        }
                        if(counter == 0){
                            subList1.addAll(characterList);
                            characterList.clear();
                        }
                        if(counter == 1){
                            subList2.addAll(characterList);
                            characterList.clear();
                        }
                        counter += 1;
                    } else {
                        for (char character : line.toCharArray()) {
                            characterList.add(character);
                        }
                        subList3.addAll(characterList);

                        // Filtering
                        Set<Character> uniqueNums = new HashSet<>(subList1);
                        uniqueNums.retainAll(subList2);
                        uniqueNums.retainAll(subList3);

                        // Assign values
                        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                        char input = uniqueNums.iterator().next();
                        int indexVal = letters.indexOf(input) + 1;
                        sumOfPriorityValues += indexVal;

                        // Reset
                        characterList.clear();
                        uniqueNums.clear();
                        subList1.clear();
                        subList2.clear();
                        subList3.clear();
                        counter = 0;
                    }
                } else { LOGGER.info("Check input.txt for invalid characters."); }
            }
        } catch (Exception e) { LOGGER.info(e.toString()); }
        LOGGER.info("\nThe total sum of badge priority types is: " + sumOfPriorityValues + "\n");
    }
}
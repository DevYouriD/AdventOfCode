package adventofcode.day5;

import java.sql.SQLOutput;
import java.util.*;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.nio.file.Paths;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Main {
    private static final Path PATH = Paths.get("src/main/java/adventofcode/day5/input.txt");
    private static final Logger LOGGER = Logger.getLogger(adventofcode.day5.Main.class.getName());
        private static final List<Integer> commandList = new ArrayList<>();

    public static void main(String[] args) {

        partOne();
        partTwo();

    }

    public static void partOne() {
        List<ArrayList<String>> listOfArrayLists = new ArrayList<>();
        listOfArrayLists.add(new ArrayList<>(List.of("D", "H", "N", "Q", "T", "W", "V", "B")));
        listOfArrayLists.add(new ArrayList<>(List.of("D", "W", "B")));
        listOfArrayLists.add(new ArrayList<>(List.of("T", "S", "Q", "W", "J", "C")));
        listOfArrayLists.add(new ArrayList<>(List.of("F", "J", "R", "N", "Z", "T", "P")));
        listOfArrayLists.add(new ArrayList<>(List.of("G", "P", "V", "J", "M", "S", "T")));
        listOfArrayLists.add(new ArrayList<>(List.of("B", "W", "F", "T", "N")));
        listOfArrayLists.add(new ArrayList<>(List.of("B", "L", "D", "Q", "F", "H", "V", "N")));
        listOfArrayLists.add(new ArrayList<>(List.of("H", "P", "F", "R")));
        listOfArrayLists.add(new ArrayList<>(List.of("Z", "S", "M", "B", "L", "N", "P", "H")));

        Pattern pattern = Pattern.compile("\\d+");

        ArrayList<String> from = new ArrayList<>();
        ArrayList<String> to = new ArrayList<>();
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH.toString()))) {
            while ((line = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);

                while(matcher.find()){
                    commandList.add(Integer.parseInt(matcher.group()));
                }

                // AMOUNT
                int amount = commandList.get(0);

                // FROM
                for (int i = 1; i <= 9; i++) {
                    if(commandList.get(1) == i){
                        from = listOfArrayLists.get(i - 1);
                        listOfArrayLists.set(i - 1, from);
                    }
                }

                // TO
                for (int i = 1; i <= 9; i++) {
                    if(commandList.get(2) == i){
                        to = listOfArrayLists.get(i - 1);
                        listOfArrayLists.set(i - 1, to);
                    }
                }

                // MOVING FUNCTIONALITY
                for (int i = 1; i <= amount; i++) {
                    to.add(from.get(from.size() - i));
                }
                from.subList(from.size() - amount, from.size()).clear();
                commandList.clear();
            }
            // PRINT LAST ELEMENT OF EACH LIST
            System.out.println("\nPart one:");
            for (ArrayList<String> innerList : listOfArrayLists) {
                int lastIndex = innerList.size() - 1;
                System.out.println(innerList.get(lastIndex));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void partTwo() {
        List<ArrayList<String>> listOfArrayLists = new ArrayList<>();
        listOfArrayLists.add(new ArrayList<>(List.of("D", "H", "N", "Q", "T", "W", "V", "B")));
        listOfArrayLists.add(new ArrayList<>(List.of("D", "W", "B")));
        listOfArrayLists.add(new ArrayList<>(List.of("T", "S", "Q", "W", "J", "C")));
        listOfArrayLists.add(new ArrayList<>(List.of("F", "J", "R", "N", "Z", "T", "P")));
        listOfArrayLists.add(new ArrayList<>(List.of("G", "P", "V", "J", "M", "S", "T")));
        listOfArrayLists.add(new ArrayList<>(List.of("B", "W", "F", "T", "N")));
        listOfArrayLists.add(new ArrayList<>(List.of("B", "L", "D", "Q", "F", "H", "V", "N")));
        listOfArrayLists.add(new ArrayList<>(List.of("H", "P", "F", "R")));
        listOfArrayLists.add(new ArrayList<>(List.of("Z", "S", "M", "B", "L", "N", "P", "H")));

        Pattern pattern = Pattern.compile("\\d+");

        ArrayList<String> from = new ArrayList<>();
        ArrayList<String> to = new ArrayList<>();
        Integer startingIndex = null;
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH.toString()))) {
            while ((line = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);

                while(matcher.find()){
                    commandList.add(Integer.parseInt(matcher.group()));
                }

                // AMOUNT
                int amount = commandList.get(0);

                // FROM
                for (int i = 1; i <= 9; i++) {
                    if(commandList.get(1) == i){
                        from = listOfArrayLists.get(i - 1);
                        listOfArrayLists.set(i - 1, from);
                    }
                }

                // TO
                for (int i = 1; i <= 9; i++) {
                    if(commandList.get(2) == i){
                        to = listOfArrayLists.get(i - 1);
                        listOfArrayLists.set(i - 1, to);
                    }
                }

                // MOVING FUNCTIONALITY
                if (amount > 1){
                    startingIndex = from.size() - amount;
                    to.addAll(from.subList(startingIndex, from.size()));
                }
                else {
                    for (int i = 1; i <= amount; i++) {
                        to.add(from.get(from.size() - i));
                    }
                }
                from.subList(from.size() - amount, from.size()).clear();
                commandList.clear();
            }
            // PRINT LAST ELEMENT OF EACH LIST
            System.out.println("\n Part two:");
            for (ArrayList<String> innerList : listOfArrayLists) {
                int lastIndex = innerList.size() - 1;
                System.out.println(innerList.get(lastIndex));
            }
        } catch (Exception e) {
            LOGGER.info(e.toString());
        }
    }
}
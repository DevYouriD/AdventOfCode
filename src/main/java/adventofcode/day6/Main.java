package adventofcode.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class Main {
    private static final Path PATH = Paths.get("src/main/java/adventofcode/day6/input.txt");
    private static final Logger LOGGER = Logger.getLogger(adventofcode.day6.Main.class.getName());

    public static void main(String[] args) {

        //partOne();
        partTwo();

    }

    public static void partOne(){
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH.toString()))) {
            while ((line = bufferedReader.readLine()) != null) {
                int count = 0;
                for (int i = 0; i <= line.length() - 4; i++) {
                    String substring = line.substring(i, i + 4);
                    if (isUnique(substring)) {
                        System.out.println(i + 4);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void partTwo(){
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH.toString()))) {
            while ((line = bufferedReader.readLine()) != null) {
                int count = 0;
                int size = 14;
                for (int i = 0; i <= line.length() - size; i++) {
                    String substring = line.substring(i, i + size);
                    if (isUnique(substring)) {
                        System.out.println(i + size);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static boolean isUnique(String substring) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < substring.length(); i++) {
            if (!set.add(substring.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
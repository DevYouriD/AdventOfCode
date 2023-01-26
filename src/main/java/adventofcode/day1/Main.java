package adventofcode.day1;

import java.util.logging.Logger;
import java.io.BufferedReader;
import java.util.Collections;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );

    public static void main(String[] args) {

        Path path = Paths.get("src/main/java/adventofcode/day1/input.txt");
        List<Integer> elfCalorieSumList = new ArrayList<>();
        int elfCalorieSum = 0;
        int topThreeCount = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toString()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(!line.isEmpty()){
                    elfCalorieSum += Integer.parseInt(line);
                } else {
                    elfCalorieSumList.add(elfCalorieSum);
                    elfCalorieSum = 0;
                }
            }

            Collections.sort(elfCalorieSumList);
            Collections.reverse(elfCalorieSumList);
            topThreeCount += elfCalorieSumList.get(0);
            topThreeCount += elfCalorieSumList.get(1);
            topThreeCount += elfCalorieSumList.get(2);

            LOGGER.info("\nMost amount of calories carried by an elf: " + elfCalorieSumList.get(0) + "\n");
            LOGGER.info("\nTop three amounts of calories carried in total: " + topThreeCount + "\n");
        } catch (Exception e){ LOGGER.info(e.toString()); }
    }
}
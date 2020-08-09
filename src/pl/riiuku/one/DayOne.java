package pl.riiuku.one;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class DayOne {

    public static void main(String[] args) throws IOException {
        getData();
    }


    private static void getData() throws IOException {
        int sum = Files.lines(Paths.get("src/pl/riiuku/one/dane.txt"))
                .mapToInt(Integer::parseInt)
                .map(number -> {
                    int mass = 0;
                    int value = number;
                    do {
                        value = (int) (Math.floor(new Integer(value).doubleValue()/3) - 2);
                        mass += Math.max(value, 0);
                    } while (value >= 0);

                    return mass;
                        }
                )
                .sum();
        System.out.println(sum);
    }
}

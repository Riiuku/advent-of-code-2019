package pl.riiuku.two;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class DayTwo {

    public static void main(String[] args) throws IOException {
        calculate();
    }

    private static void calculate() throws IOException {
        for (int j = 0; j < 100; j++) {
            for (int k = 0; k < 100; k++) {
                BufferedReader br = new BufferedReader(new FileReader(new File("src/pl/riiuku/two/dane.txt")));
                String line;
                int[] numbers = null;
                while ((line = br.readLine()) != null) {
                    numbers = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
                }
                br.close();

                numbers[1] = j;
                numbers[2] = k;

                for (int i = 0; i < numbers.length; i += 4) {
                    int[] set =  Arrays.copyOfRange(numbers, i, i+4);
                    if (set[0] == 1)  {
                        numbers[set[3]] = numbers[set[1]] + numbers[set[2]];
                    }

                    if (set[0] == 2) {
                        numbers[set[3]] = numbers[set[1]] * numbers[set[2]];
                    }


                    if (set[0] == 99) {
                        break;
                    }
                }

                if (numbers[0] == 19690720) {
                    System.out.println(j + " " + k);
                    System.out.println(100*j + k);
                    break;
                }
            }
        }

    }
}

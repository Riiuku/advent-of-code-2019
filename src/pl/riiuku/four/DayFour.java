package pl.riiuku.four;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class DayFour {

    public static void main(String[] args) throws IOException {
        calculate();
    }

    private static void calculate() throws IOException {
        Set<Integer> values = new HashSet<>();

        for (int i = 256310; i <= 732736; i++) {
            values.add(i);
        }

        Set<Integer> clearedValues = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            values.stream()
                    .filter(value -> value.toString().contains(finalI + "" + finalI))
                    .forEach(value -> {
                        char[] val = value.toString().toCharArray();
                        int biggest = 0;
                        boolean addable = false;
                        for (char ch : val) {
                            if (biggest <= Character.getNumericValue(ch)) {
                                biggest = Character.getNumericValue(ch);
                                addable = true;
                            } else {
                                addable = false;
                                break;
                            }
                        }

                        if (addable) {

                            clearedValues.add(value);
                        }
                    });
        }


        long sum = clearedValues.stream().filter(value -> {
            char[] sets = value.toString().toCharArray();
            List<Integer> result = new ArrayList<>();

            for (char set : sets) {
                int count = 0;
                for (char c : sets) {
                    if (set == c)
                        count++;
                }
                result.add(count);
            }
            return result.contains(2);
        }).count();
        System.out.println(sum);
    }
}

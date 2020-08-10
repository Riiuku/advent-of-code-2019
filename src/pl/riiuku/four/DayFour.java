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


    //    It is a six-digit number.
//    The value is within the range given in your puzzle input.
//    Two adjacent digits are the same (like 22 in 122345).
//    Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).
//    256310-732736
//    [0] = 2 3 4 5 6 7
//    [1] = 3 4 5
//    [2] = 2 3 4 5 6
//    [3] = 3 4 5 6 7
//    [4] = 1 2 3
//    [5] = 0 1 2 3 4 5 6
    private static void calculate() throws IOException {
        Set<Integer> values = new HashSet<>();

//        for (int i = 2; i <= 7; i++) {
//            for (int j = 3; j <= 5; j++) {
//                for (int k = 2; k <= 6; k++) {
//                    for (int l = 3; l <= 7; l++) {
//                        for (int m = 1; m <= 3; m++) {
//                            for (int n = 0; n <= 6; n++) {
//                                if (i <= j && j <= k && k <= l && l <= m && m <= n)
//                                    values.add(i + "" + j + "" + k + "" + l + "" + m + "" + n);
//                            }
//                        }
//                    }
//                }
//            }
//        }

        for (int i = 256310; i <= 732736; i++) {
            values.add(i);
        }

        Set<Integer> get = new HashSet<>();

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

                            get.add(value);
                        }
                    });
        }


        Set<Integer> lastOne = new HashSet<>();

        get.forEach(value -> {
            char[] sets = value.toString().toCharArray();
            List<Integer> result = new ArrayList<>();

            for (char set : sets) {
                int count = 0;
                for (char c : sets) {
                    if(set == c)
                        count ++;
                }
                result.add(count);
            }

            if(result.contains(2)) {
                lastOne.add(value);
            }
        });
        System.out.println(lastOne.size());
    }
}

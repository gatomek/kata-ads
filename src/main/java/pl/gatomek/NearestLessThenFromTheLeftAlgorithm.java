package pl.gatomek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NearestLessThenFromTheLeftAlgorithm {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE, 2, 6, 4, 7, 5, 3));
        List<Integer> result = new ArrayList<>(list);
        Collections.fill(result, 0);

        for (int i = 1; i < list.size(); i++) {
            int curr = list.get(i);

            int index = i - 1;
            int prev = list.get(index);
            if (prev < curr) {
                result.set(i, index);
            } else {
                while (true) {
                    index = result.get(index);
                    prev = list.get(index);
                    if (prev < curr) {
                        result.set(i, index);
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%11s", i);
            System.out.print(" | ");
        }
        System.out.println();
        for (Integer i : list) {
            System.out.printf("%11s", i);
            System.out.print(" | ");
        }
        System.out.println();
        for (Integer r : result) {
            System.out.printf("%11s", r);
            System.out.print(" | ");
        }
        System.out.println();
    }
}
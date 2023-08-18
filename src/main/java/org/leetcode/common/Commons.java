package org.leetcode.common;

import java.util.HashMap;
import java.util.Map;

final public class Commons {
    public static int[] reverseArray(int[] numbers, int L, int R) {
        while (L < R) {
            int temp = numbers[L];
            numbers[L] = numbers[R];
            numbers[R] = temp;

            L++;
            R--;
        }

        return numbers;
    }

    public static int[] swap(int[] numbers, int L, int R) {
        final int temp = numbers[L];
        numbers[L] = numbers[R];
        numbers[R] = temp;
        return numbers;
    }

    public static Map<Integer, Integer> frequencyMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                continue;
            }
            map.put(num, 1);
        }
        return map;
    }
}

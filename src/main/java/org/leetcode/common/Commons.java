package org.leetcode.common;

import java.util.HashMap;
import java.util.Map;

final public class Commons {
    public static int[] reverseArray(int[] numbers, int sIndex, int eIndex) {
        while (sIndex < eIndex) {
            int temp = numbers[sIndex];
            numbers[sIndex] = numbers[eIndex];
            numbers[eIndex] = temp;

            sIndex++;
            eIndex--;
        }

        return numbers;
    }

    public static int[] swap(int[] numbers, int r, int l) {
        final int temp = numbers[r];
        numbers[r] = numbers[l];
        numbers[l] = temp;
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

package org.leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * #Array #HashTable #TwoPointers #BinarySearch #Sorting
 *
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 *
 *
 * https://www.youtube.com/watch?v=dP8CAXKISX0
 * use hashmap and count number of frequency
 */
public class L350_IntersectionOfTwoArraysII {

    @Test
    public void intersectionOfTwoArrayIITest() {
        String result = toString(intersectionII(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        System.out.println(result);


        result = toString(intersectionII(new int[]{1, 2, 2, 2, 3, 4}, new int[]{2, 2, 3, 5}));
        System.out.println(result);
    }


    /**
     * Input: nums1 = [1,2,2,2,3,4], nums2 = [2,2,3,5]
     * Output: [2,2,3]
     */
    public int[] intersectionII(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = frequencyMap(nums1);
        Map<Integer, Integer> map2 = frequencyMap(nums2);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> map: map1.entrySet()) {

            if (map2.containsKey(map.getKey())) {
                // get min count
                int min = Math.min(map1.get(map.getKey()), map2.get(map.getKey()));
                while (min > 0) {
                    result.add(map.getKey());
                    min--;
                }
            }

        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private static Map<Integer, Integer> frequencyMap(int[] nums) {
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

    String toString(int[] a) {
        return Arrays.toString(a);
    }

}

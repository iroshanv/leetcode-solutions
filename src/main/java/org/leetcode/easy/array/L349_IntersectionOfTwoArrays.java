package org.leetcode.easy.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * #Array #HashTable #TwoPointers #BinarySearch #Sorting
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * https://www.youtube.com/watch?v=dP8CAXKISX0 => Kevin
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique & you may return the result in any order.
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *
 *
 */
public class L349_IntersectionOfTwoArrays {

    //TODO: implement using binary search


    @Test
    public void intersectionOfTwoArrayTest() {
        // output [2]
        String result = toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        System.out.println(result);
    }

    /**
     *
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // nums1
        HashSet<Integer> map1 = new HashSet<>();
        for (int num : nums1) {
            map1.add(num);
        }

        // check num2 contains num1
        HashSet<Integer> map2 = new HashSet<>();
        for(int num : nums2) {
            if (map1.contains(num)) {
                map2.add(num);
            }
        }

        int[] result = new int[map2.size()];
        int index = 0;
        for(int i : map2) {
            result[index++] = i;
        }

        return result;
    }

    String toString(int[] a) {
        return Arrays.toString(a);
    }

}

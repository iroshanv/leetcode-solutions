package org.leetcode.array;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * #Array #BitManipulation
 *
 * https://leetcode.com/problems/single-number/
 * https://www.youtube.com/watch?v=eXl0HBm2RrA => NeetCode using XOR
 *
 *
 * Given a non-empty array of integers nums, `every element appears twice` except for one.
 * Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * <p>
 * Input: nums = [1]
 * Output: 1
 *

 *

 *
 */
class L136_SingleNumber {

    @Test
    public void singleNumber_xor() {
        System.out.println(singleNumber_xor(new int[]{1, 1, 2, 1, 4}));
    }

    /**
     * 4, 1, 2, 1, 2
     *
     * 1 ^ 1 = 0
     * 1 ^ 0 = 1
     * 0 ^ 0 = 0
     *
     * binary representation
     * 4 => 1 0 0
     * 1 => 0 0 1
     * 2 => 0 1 0
     * 1 => 0 0 1
     * 2 => 0 1 0
     *
     * we can perform this in any order
     */
    public int singleNumber_xor(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;
    }

    @Test
    public void singleNumber_hashMap() {
        // 1
        System.out.println(singleNumber_hashMap(new int[]{2, 2, 1}));

        // 4
        System.out.println(singleNumber_hashMap(new int[]{1, 1, 2, 1, 4}));
    }

    public int singleNumber_hashMap(int[] nums) {
        if (nums.length == 1) return nums[0];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.put(nums[i], count + 1);
                continue;
            }
            map.put((nums[i]), 1);
        }

        return map.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(1))
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
    }

    @Test
    public void singleNumber_sortedArray() {
        // 4
        System.out.println(singleNumber_sortedArray(new int[]{1, 1, 4, 2, 2}));

        // 1
        System.out.println(singleNumber_sortedArray(new int[]{2, 2, 1}));

        // 4
        System.out.println(singleNumber_sortedArray(new int[]{4, 1, 2, 2, 1}));

    }


    /**
     * https://leetcode.com/problems/single-number/solutions/3264959/well-expalined-code-in-java/?languageTags=java
     *
     * input: 4,1,2,1,2
     * sort 1 1 2 2 4
     */
    public int singleNumber_sortedArray(int[] nums) {
        Arrays.sort(nums);
        int arrLen = nums.length;

        if(arrLen == 1){
            return nums[0];
        }

        for(int i = 0; i < arrLen - 1; i += 2){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[arrLen -1];
    }
}

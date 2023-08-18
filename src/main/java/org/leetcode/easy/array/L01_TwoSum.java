package org.leetcode.easy.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * #Array #HashTable
 *
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 *                0 1  2  3
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * 
 *
 *
 * https://leetcode.com/problems/two-sum/
 * https://www.youtube.com/watch?v=BoHO04xVeU0
 * https://www.youtube.com/watch?v=KLlXCFG5TnA => NeetCode
 * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0001-Two-Sum/Animation/Animation.gif
 */
public class L01_TwoSum {

    @Test
    @DisplayName("hash-map")
    public void two_sum_hash_map() {

        //[1,2]
        String result_2 = Arrays.toString(twoSum_hashMap(new int[]{3, 2, 4}, 6));
        System.out.println(result_2);

        //[1,3]
        String result_0 = Arrays.toString(twoSum_hashMap(new int[]{2, 1, 5, 3}, 4));
        System.out.println(result_0);

        //[0,1]
        String result_1 = Arrays.toString(twoSum_hashMap(new int[]{2, 7, 11, 15}, 9));
        System.out.println(result_1);

        //[0,1]
        String result_3 = Arrays.toString(twoSum_hashMap(new int[]{3, 3}, 6));
        System.out.println(result_3);

        //[2,3]
        String result_4 = Arrays.toString(twoSum_hashMap(new int[]{3, 5, 1, 4, -8}, 5));
        System.out.println(result_4);

        //[1,4]
        String result_5 = Arrays.toString(twoSum_hashMap(new int[]{3, 4, 9, 6, 4}, 8));
        System.out.println(result_5);

        //[1,5]
        String result_6 = Arrays.toString(twoSum_hashMap(new int[]{4, -2, 5, 0, 6, 3, 2, 7}, 1));
        System.out.println(result_6);
    }

    /**
     *
     * target = 4
     * index: 0 1 2 3
     * value: 2 1 5 3
     *          *   *
     *
     *
     * use compensation (only number we can use to end up with target)
     *   4 - 2 = 2   =>  2 + 2 = 4 // cannot use same index
     *   4 - 1 = 3   =>  1 + 3 = 4
     *   4 - 5 = -1  =>  5 + -1 = 4
     *   4 - 3 = 1   =>  -3 + 1 = -2
     *
     */
    public static int[] twoSum_hashMap(int[] nums, int target) {
        // value:index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}

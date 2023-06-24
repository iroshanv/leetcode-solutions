package org.leetcode.array;


import org.junit.jupiter.api.Test;

/**
 * #Array #TwoPointers #BinarySearch
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * https://www.youtube.com/watch?v=cQ1Oz4ckceM
 * https://www.youtube.com/watch?v=sAQT4ZrUfWo
 *
 *
 *
 * Given a 1-indexed array of integers numbers that is already `sorted` in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 *
 *
 * Input: 1 3 4 5 7 10 11
 * target = 9
 * use L=0 R=len-1 pointer
 *
 * 1 + 11 = 12 > 9
 * 1 + 7  = 8 < 9
 * 3 + 7  = 10 > 9
 * 3 + 5  = 8 < 9
 * 4 + 5 = 9 bingo!
 *
 */
public class L167_TwoSumII {

    @Test
    public void twoSumII_Test() {
        int[] ints = twoSum(new int[]{1, 3, 4, 5, 7, 10, 11}, 9);
        System.out.println("debug-point");
    }

    public static int[] twoSum(int[] numbers, int target) {

        int L = 0;
        int R = numbers.length-1;

        while (L <= R) {
            int sum = numbers[L] + numbers[R];

            if (sum > target) {
                R -= 1;
            } else if (sum < target) {
                L += 1;
            } else {
                return new int[]{L+1, R+1};
            }
        }

//        return new int[];
        return new int[] {L+1, R+1};
    }

}

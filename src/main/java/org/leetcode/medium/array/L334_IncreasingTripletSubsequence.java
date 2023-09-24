package org.leetcode.medium.array;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence
 * https://leetcode.com/problems/increasing-triplet-subsequence/solutions/4044808/easy-optimal-solution-single-iterate-approach-o-n-o-1-space-java-solution/?envType=study-plan-v2&envId=leetcode-75
 * https://www.youtube.com/watch?v=yEFlGWOVH8g
 *
 *
 * Example 3:
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 *
 * #Array #Greedy
 */
public class L334_IncreasingTripletSubsequence {

    @Test
    public void increasingTripletTest() {
        System.out.println( increasingTriplet(new int[]{20,100,10,12,5,13}) );   // true
        System.out.println( increasingTriplet(new int[]{5,4,3,2,1}) );   // false
        System.out.println( increasingTriplet(new int[]{2,1,5,0,4,6}) ); // true
        System.out.println( increasingTriplet(new int[]{1,2,3,4,5,6}) ); // true
    }

    public boolean increasingTriplet(int[] nums) {

        if (nums.length < 3) return false;

        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;

        for (int in = 0; in < nums.length; in++) {

            if (nums[in] <= i){
                i = nums[in];
            }else if (nums[in] <= j){
                j = nums[in];
            }else {
                return true;
            }

        }
        return false;
    }
}

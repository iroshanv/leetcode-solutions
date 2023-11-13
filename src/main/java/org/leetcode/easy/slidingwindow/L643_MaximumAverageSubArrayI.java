package org.leetcode.easy.slidingwindow;

/**
 * <a href="https://leetcode.com/problems/maximum-average-subarray-i/description" />
 * <a href="https://www.youtube.com/watch?v=56TxHMG0qhQ" />
 * #SlidingWindow #Array
 */
public class L643_MaximumAverageSubArrayI {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{5}, 1));
        System.out.println(findMaxAverage(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(findMaxAverage(new int[]{-1}, 1));


        System.out.println(findMaxAverageBruteForce(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
        System.out.println(findMaxAverageBruteForce(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(findMaxAverageBruteForce(new int[]{5}, 1));
        System.out.println(findMaxAverageBruteForce(new int[]{-1}, 1));
    }


    public static double findMaxAverage(int[] nums, int k) {
        int max = 0;

        for (int i = 0; i < k; i++) {
            max += nums[i];
        }

        // when single array is passed
        int newMax = max;
        for (int i = k; i < nums.length; i++) {
            max = max + nums[i] - nums[i-k];
            newMax = Math.max(max, newMax);
        }

        return (double) newMax/k;
    }

    public static double findMaxAverageBruteForce(int[] nums, int k) {

        int L = 0;
        int R = k;
        double maxAvg = Integer.MIN_VALUE;

        while (R <= nums.length)
        {
            double newMax=0;
            for (int i = L; i < R; i++) {
                newMax = newMax + nums[i] ;
            }

            newMax = (newMax / k);
            if (( newMax > maxAvg)){
                maxAvg = newMax;
            }
            R++;
            L++;
        }

        return maxAvg;
    }
}

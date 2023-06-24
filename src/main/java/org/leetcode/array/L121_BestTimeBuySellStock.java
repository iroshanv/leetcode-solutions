package org.leetcode.array;

import org.junit.jupiter.api.Test;

/**
 * #Array #DynamicProgramming
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Day:             1 2 3 4 5 6
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 *
 * We need to find out the maximum difference (which will be the maximum profit) between two numbers in the given array.
 * Also, the second number (selling price) must be larger than the first one (buying price).
 *
 *
 * https://www.youtube.com/watch?v=1pkOgXD63yU => NeetCode => using sliding window two pointers approach
 * https://www.youtube.com/watch?v=3RHCb8LY-X4 => NickWhite
 */
public class L121_BestTimeBuySellStock {

    @Test
    public void bestTimeBuySellStockTest() {
        //output: 5
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }


    /**
     * prices = [7,1,5,3,6,4]
     */
    public int maxProfit(int[] prices) {

        int min_val = Integer.MAX_VALUE;
        int max_profit = 0;

        for (int i = 0; i < prices.length; i++) {

            // best time to buy, when price is low
            if ( prices[i] < min_val ) {
                min_val = prices[i];
            }

            // best time to sell, when price is high
            else if( (prices[i] - min_val) > max_profit ) {
                max_profit = prices[i] - min_val;
            }
        }

        return max_profit;
    }
}

package org.leetcode.easy.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description
 */
public class L1431_KidsWithGreatestNumberOfCandies {


    @Test
    public void kidsWithCandiesTest() {
        System.out.println( kidsWithCandies(new int[]{2,3,5,1,3}, 3) );
        System.out.println( kidsWithCandies(new int[]{4,2,1,1,1}, 1) );
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();

        int maxCandy = 0;
        for (int candy: candies) {
            if (candy > maxCandy) {
                maxCandy = candy;
            }
        }

        for (int candy: candies) {
            if ((candy + extraCandies) >= maxCandy) {
                result.add(true);
            }else {
                result.add(false);
            }
        }

        // Improvement
        // for (int candy: candies) {
        //   result.add(((candy + extraCandies) >= maxCandy));
        // }

        return result;
    }
}

package org.leetcode.easy.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/can-place-flowers
 * https://www.youtube.com/watch?v=ZGxqqjljpUI
 */
public class L605_CanPlaceFlowers {


    @Test
    public void canPlaceFlowersTest() {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2));       //  false
        System.out.println(canPlaceFlowers(new int[]{0,1,0}, 1));       // true
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1}, 1));   // true
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1}, 2));   // false;
    }


    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        List<Integer> flowerBedList = Arrays.stream(flowerbed).boxed().collect(Collectors.toList());
        flowerBedList.add(0, 0);
        flowerBedList.add(flowerbed.length + 1, 0);

        for (int i = 1; i < flowerBedList.size() - 1; i++) {
            if (flowerBedList.get(i - 1) == 0 && flowerBedList.get(i) == 0 && flowerBedList.get(i + 1) == 0) {
                flowerBedList.set(i, 1);
                n--;
            }
        }

        return n <= 0;
    }
}

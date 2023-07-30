package org.leetcode.topinterview150;

import org.junit.jupiter.api.Test;

/**
 *
 * https://leetcode.com/problems/merge-sorted-array/description
 * https://www.youtube.com/watch?v=P1Ic85RarKY
 * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0088-Merge-Sorted-Array/Animation/Animation.gif
 *
 * Given two sorted integer arrays `nums and nums2`, merge `nums2 into nums1` as on `sorted` array
 *
 * Note:
 *  The number of elements initialized in `nums1 and nums2 are m and n` respectively
 *  You may assume that `nums1` has enough space (m + n) to hold additional elements from` nums2`
 *
 * Input: nums1 = [1,2,3,0,0, 0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 *                             _ _   _
 */
public class L88_MergeSortedArray {

    @Test
    public void mergeSortedArrayTest() {

        // tc 1
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        merge(nums1, 3, nums2, 3);


        // tc 2
        nums1 = new int[]{1};
        nums2 = new int[]{};

        merge(nums1, 1, nums2,0);


        // tc 3 => The arrays we are merging are [] and [1].
        nums1 = new int[]{0};
        nums2 = new int[]{1};

        merge(nums1, 0, nums2,1);


        // tc 4
        nums1 = new int[]{2,2,3,0,0,0};
        nums2 = new int[]{1,5,6};

        merge(nums1,3, nums2,3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // last index
        int last = (m + n) - 1;

        while ( m > 0 && n > 0 ) {
            if ( nums1[m-1] > nums2[n-1] ) {
                nums1[last] = nums1[m-1];
                m--;
            } else {
                nums1[last] = nums2[n-1];
                n--;
            }
            last--;
        }

        // fill num1 with leftover nums2 element, see tc-3
        while (n > 0) {
            nums1[last] = nums2[n-1];
            n--;
            last--;
        }

        System.out.println("hey");
    }
}

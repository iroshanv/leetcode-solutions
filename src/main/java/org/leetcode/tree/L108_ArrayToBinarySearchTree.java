package org.leetcode.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.leetcode.common.TreeNode;

/**
 * #Array #DivideAndConquer #Tree #BinarySearchTree #BinaryTree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * https://www.youtube.com/watch?v=12omz-VAyRk
 *
 *
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree
 *
 *
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 *
 */
public class L108_ArrayToBinarySearchTree {

    @Test
    @DisplayName("convert sorted array to binary search tree")
    public void convert_sorted_array_to_binary_search_tree() {
        TreeNode treeNode_1 = sortedArrayToBST(new int[]{1,2,3,4,5,6,7});
        TreeNode treeNode_2 = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        TreeNode treeNode_3 = sortedArrayToBST(new int[]{1,3});
    }


    /**
     *         4
     *       /   \
     *      2     6
     *     / \   / \
     *    1   3 5   7
     *
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return constructTreeFromArray(nums, 0, nums.length - 1);
    }

    private static TreeNode constructTreeFromArray(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int midPoint = left + (right-left) / 2;
        TreeNode node = new TreeNode(nums[midPoint]);
        node.left = constructTreeFromArray(nums, left, midPoint-1);
        node.right = constructTreeFromArray(nums, midPoint+1, right);

        return node;
    }

}

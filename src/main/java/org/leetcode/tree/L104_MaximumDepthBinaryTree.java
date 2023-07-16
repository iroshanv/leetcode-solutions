package org.leetcode.tree;

import org.junit.jupiter.api.Test;
import org.leetcode.common.TreeNode;

/**
 * #Tree #DFS #BFS #BinaryTree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * https://www.youtube.com/watch?v=hTM3phVI6YQ => NeetCode
 * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0104-Maximum-Depth-Of-Binary-Tree/Animation/Animation1.gif
 *
 * Using BFS
 * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0104-Maximum-Depth-Of-Binary-Tree/Animation/Animation2.gif
 *
 *
 * Given the root of a binary tree, return its maximum depth.
 */
public class L104_MaximumDepthBinaryTree {

    /**
     *         3               1 + max(l, r) = 1
     *       /   \             1 + max(1, 2) = 3
     *   (1)9     20(1 + 1)
     *           / \
     *       (1)15   7(1)
     */
    @Test
    public void maximum_depth_binary_tree() {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        System.out.println("max depth of binary tree is = " + maxDepth(treeNode));
    }


    // Time Complexity = O(n) since we are traversing entire tree
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }



}

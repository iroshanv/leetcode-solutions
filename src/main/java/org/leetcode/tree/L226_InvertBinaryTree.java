package org.leetcode.tree;

import org.junit.jupiter.api.Test;
import org.leetcode.common.TreeNode;

/**
 * #Tree #DFS #BFS #BinaryTree
 *
 * https://leetcode.com/problems/invert-binary-tree
 * https://www.youtube.com/watch?v=fKgZiCXb6zs
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 *
 * Input
 *               1
 *             /   \
 *            /     \
 *           2       3
 *          / \     / \
 *         4   5   6   7
 *
 * Output
 *               1
 *             /   \
 *            /     \
 *           3       2
 *          / \     / \
 *         7   6   5   4
 */
public class L226_InvertBinaryTree {

    @Test
    public void invertBinaryTreeTest() {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        invertTree(root);

    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        // binary tree traversal
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);


        //swap
        root.right = left;
        root.left = right;

        return root;
    }
}

package org.leetcode.easy.tree;


import org.junit.jupiter.api.Test;
import org.leetcode.common.TreeNode;

/**
 * #Tree #DFS #BFS #BinaryTree
 *
 * https://leetcode.com/problems/symmetric-tree/
 * https://www.youtube.com/watch?v=Mao9uzxwvmc
 *
 *
 * Given the root of a binary tree, check whether
 * it is a mirror of itself (i.e., symmetric around its center).
 *
 */
public class L101_SymmetricTree {

    @Test
    public void symmetricTreeTest() {
        TreeNode node = new TreeNode(5, new TreeNode(3), new TreeNode(3));
        boolean symmetric = isSymmetric(node);
        System.out.println("is tree symmetric: " + symmetric);

//        node = new TreeNode(5,
//                new TreeNode(3, new TreeNode(4), new TreeNode(2)),
//                new TreeNode(3,  new TreeNode(2), new TreeNode(4)));
//        isSymmetric(node);
    }


    /**
     * symmetric
     *         5
     *        / \
     *       3   3
     *      / \ / \
     *     4  2 2  4
     *
     * Not symmetric
     *         5
     *        / \
     *       3   3
     *        \   \
     *         4   4
     *
     * similar to L100 - same tree
     */
    private static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }
}

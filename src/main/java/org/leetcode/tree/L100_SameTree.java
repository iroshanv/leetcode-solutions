package org.leetcode.tree;


import org.junit.jupiter.api.Test;
import org.leetcode.common.TreeNode;

/**
 * #DFS, #BFS, #Tree, #BinaryTree
 *
 * https://www.youtube.com/watch?v=vRbbcKXCxOw
 * https://leetcode.com/problems/same-tree/description/
 *
 *  Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 *
 *
 * time complexity O(p+q)
 */
public class L100_SameTree {

    @Test
    public void sameTree_Test() {
        TreeNode A = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode B = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        boolean sameTree = isSameTree(A, B);
        System.out.println("is tree same: " + sameTree);
    }

    /**
     *    1            1
     *   / \          / \
     *  2   3        2   3
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;

            return ((p.val == q.val)
                   && isSameTree(p.left, q.left)
                   &&  isSameTree(p.right, q.right) );
    }
}

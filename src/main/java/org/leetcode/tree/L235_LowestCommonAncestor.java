package org.leetcode.tree;


import org.junit.jupiter.api.Test;
import org.leetcode.common.TreeNode;

/**
 * #Tree, #DFS, #BinarySearchTree, #BinaryTree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 *
 * https://www.youtube.com/watch?v=6POfA8fruxI
 * https://www.youtube.com/watch?v=gs2LMfuOR9k&t => good explanation from NeetCode
 *
 * Given a binary search tree (BST),
 * find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 *

 */
public class L235_LowestCommonAncestor {

    @Test
    public void lowestCommonAncestorTest()
    {
        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(9);
        TreeNode treeNode = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));

        TreeNode result = lowestCommonAncestor(treeNode, p, q); // 8

        System.out.println("debug");
    }


    /**
     *
     *
     *        6
     *      /   \
     *     2     8
     *    /\     /\
     *   0  4   7  9
     *      /\
     *     3  5
     *
     * The LCA of nodes 2 and 8 is 6.
     *
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // traverse left
        if ( p.val < root.val && q.val < root.val ) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // traverse right
        if ( p.val > root.val && q.val > root.val ) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}

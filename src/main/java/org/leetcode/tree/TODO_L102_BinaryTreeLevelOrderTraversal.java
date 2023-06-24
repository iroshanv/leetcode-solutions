package org.leetcode.tree;


import org.junit.jupiter.api.Test;
import org.leetcode.common.TreeNode;

import java.util.List;

/**
 * #Tree #BFS #BinaryTree
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * https://www.youtube.com/watch?v=6ZnyEApgFYg => NeetCode
 *
 * Input:
 *      3
 *     / \
 *    9  20
 *       /\
 *     15  7
 *
 * output
 * [[3], [9,20], [15,7]]
 *
 *
 * Time Complexity O(n)
 */
public class TODO_L102_BinaryTreeLevelOrderTraversal {


    @Test
    public void levelOrder_Test() {
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20 , new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> lists = levelOrder(node);
        System.out.println(lists.toString());
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {



        return null;
    }
}

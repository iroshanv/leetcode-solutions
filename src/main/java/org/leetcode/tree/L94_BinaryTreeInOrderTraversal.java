package org.leetcode.tree;

import org.junit.jupiter.api.Test;
import org.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * #Stack #Tree #DFS #BinaryTree
 * https://leetcode.com/problems/binary-tree-inorder-traversal
 *
 * https://www.youtube.com/watch?v=WZwNoTm_9d8
 * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0094-Binary-Tree-Inorder-Traversal/Animation/Animation2.gif
 *
 * the inorder traversal algorithm visits nodes in the following order:
 * Traverse the left subtree
 * Visit the root node
 * Traverse the right subtree
 */
public class L94_BinaryTreeInOrderTraversal {

    @Test
    public void binary_tree_inOrder_traversal() {
        /**
         *         5
         *        / \
         *       3   8
         */
        TreeNode treeNode = new TreeNode(5, new TreeNode(3, null, null), new TreeNode(8, null, null));
        System.out.println(inorderTraversal(treeNode));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }


    private List<Integer> inorderTraversal_stack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return res;
        }

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // if curr is null
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}

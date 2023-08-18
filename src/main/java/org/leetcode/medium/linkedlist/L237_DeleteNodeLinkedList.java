package org.leetcode.medium.linkedlist;

import org.junit.jupiter.api.Test;
import org.leetcode.common.ListNode;

/**
 * #LinkedList
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 *
 * https://www.youtube.com/watch?v=urzP1YbgUnU
 * https://www.youtube.com/watch?v=ruat4x3OwQc => explained well
 * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0237-Delete-Node-in-a-Linked-List/Animation/Animation.gif
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 *
 * Explanation:
 * You are given the second node with value 5,
 * the linked list should become 4 -> 1 -> 9 after calling your function.
 *
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 *
 */
public class L237_DeleteNodeLinkedList {

    ListNode node = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));

    @Test
    public void deleteNodeLinkedListTest() {
        ListNode nodeToDelete = node.next.next; // node to delete is = 1
        deleteNode(nodeToDelete);

    }

    /**
     *   4 -> 5 -> 1 -> 9
     *   node to delete = 1
     */
    public void deleteNode(ListNode node) {
        // Since we know input node is not last node, so nextNode will not be null
        ListNode nextNode = node.next;

        // Step 2 copy the value
        node.val = nextNode.val;

        // Step 3 append next node
        node.next = nextNode.next;

        // remove nextNode
        nextNode.next = null;
    }
}

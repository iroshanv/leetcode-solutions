package org.leetcode.linkedlist;

import org.junit.jupiter.api.Test;
import org.leetcode.common.ListNode;

/**
 * #LinkedList #TwoPointers
 *
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * https://www.youtube.com/watch?v=wmpivqMlClI
 *
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 *
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4,
 * we return the second one.
 *
 */
public class L876_MiddleOfTheLinkedList {

    @Test
    public void middleNode_test() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode middleNode = middleNode(node);
        System.out.println("middle node is = " + middleNode.val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

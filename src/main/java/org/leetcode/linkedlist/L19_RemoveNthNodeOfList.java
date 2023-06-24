package org.leetcode.linkedlist;

import org.junit.jupiter.api.Test;
import org.leetcode.common.ListNode;

 /**
  * #LinkedList #TwoPointers
  *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Given the head of a linked list,
 * remove the nth node `from the end of the list` and return its head.
  *
 *                4 3 2 1 0
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,4,5]
 *
 * Explanation:
 * n = 2
 * 1 -> 2 -> 3 -> 4 -> 5
 * 1 -> 2 -> 3 ------> 5
 *
 * https://www.youtube.com/watch?v=XtYEEvrhemI
 * https://www.youtube.com/watch?v=XVuQxVej6y8 => NeetCode
 */
public class L19_RemoveNthNodeOfList {

    /**
     * approaches:
     *  1. reverse list and remove 2nd node. (not required)
     *
     */
    @Test
    public void removeNthFromEndTest() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = removeNthFromEnd(node, 2);
        System.out.println("debug-point");
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // position the node where we want to remove the node
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // position slow node before the node we want to remove
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
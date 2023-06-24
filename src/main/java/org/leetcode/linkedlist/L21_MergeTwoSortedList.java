package org.leetcode.linkedlist;

import org.junit.jupiter.api.Test;
import org.leetcode.common.ListNode;

/**
 * #LinkedList #Recursion
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 *
 * 1 -> 2 -> 4
 * 1 -> 3 -> 4
 * 1 -> 1 -> 2 -> 3 -> 4 -> 4
 *
 *
 * https://www.youtube.com/watch?v=KVf1Uuqfv8E
 * https://www.youtube.com/watch?v=XIdigk956u0
 */
public class L21_MergeTwoSortedList {

    @Test
    public void mergeTwoListsTest() {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        mergeTwoLists(l1, l2);

        l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        l2 = new ListNode(1, null);
        mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;

        }

        if (list1 != null) {
            curr.next = list1;
            list1 = list1.next;
        }

        if (list2 != null) {
            curr.next = list2;
            list2 = list2.next;
        }
        return dummy.next;
    }
}

package org.leetcode.easy.linkedlist;

import org.junit.jupiter.api.Test;
import org.leetcode.common.ListNode;

import java.util.List;

/**
 * #LinkedList #Recursion
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0206-Reverse-Linked-List/Animation/Animation.gif
 * https://www.youtube.com/watch?v=NhapasNIKuQ
 * https://www.youtube.com/watch?v=G0_I-ZF0S38 => NeetCode
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 *
 * Input:  1 -> 2 -> 3 -> 4 -> 5
 * output: 5 -> 4 -> 3 -> 2 -> 1
 *

 */
public class L206_ReverseLinkedList {

    @Test
    public void reverse_linked_list_test(){
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode reverseList = reverseList(listNode);

        System.out.println("debug-point");
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // tmp var
            ListNode nxt = curr.next;

            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}

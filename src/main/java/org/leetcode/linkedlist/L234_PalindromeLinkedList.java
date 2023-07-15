package org.leetcode.linkedlist;

import org.junit.jupiter.api.Test;
import org.leetcode.common.ListNode;

/**
 * #LinkedList #TwoPointers #Stack #Recursion
 *
 * https://leetcode.com/problems/palindrome-linked-list/
 * https://www.youtube.com/watch?v=wk4QsvwQwdQ
 * https://www.youtube.com/watch?v=yOzXms1J6Nk
 *
 * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0234-isPalindrome/Animation/solved01.gif
 * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0234-isPalindrome/Animation/solved02.gif
 *
 *
 * Given the head of a singly linked list, return true if it is a palindrome
 * or false otherwise.
 *
 * Input = 1 -> 2 -> 2 -> 1
 *
 * Explanation:
 * traverse till mid-point
 * reverse from mid-point
 * now
 *  right 1 -> 2
 *  left  1 -> 2
 *
 *
 */
public class L234_PalindromeLinkedList {

    @Test
    public void palindrome_linked_list_test(){
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        boolean isPalindrome = isPalindrome(listNode);

        System.out.println("is palindrome = " + isPalindrome);
    }

    public boolean isPalindrome(ListNode head) {
        ListNode left = head;
        ListNode right = head;

        // traverse to mid element
        while ( right != null && right.next != null ) {
            right = right.next.next;
            left = left.next;
        }

        right = left; // point to mid element
        right = reverse(right);
        left = head;

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

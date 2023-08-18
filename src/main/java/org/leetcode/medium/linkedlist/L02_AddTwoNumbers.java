package org.leetcode.medium.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.leetcode.common.ListNode;

/**
 *
 * #LinkedList #Math #Recursion
 * https://leetcode.com/problems/add-two-numbers
 *
 * https://www.youtube.com/watch?v=wgFPrzTjm7s
 * https://www.youtube.com/watch?v=aM4Iv7eEr2o
 * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0002-Add-Two-Numbers/Animation/Animation.gif
 *
 *  You are given two non-empty linked lists representing two non-negative integers.
 *  The digits are stored in reverse order, and each of their nodes contains a single digit.
 *  Add the two numbers and return the sum as a linked list.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4] ,note: input are stored in "reverse order"
 * Output: [7,0,8]
 *
 * 5 -> 6 -> 4
 * 2 -> 4 -> 3 -> 3
 * -------------------
 * 7 -> 0 -> 8 -> 3
 *
 */

public class L02_AddTwoNumbers {

    @Test
    @DisplayName("add two numbers in node using elementary math")
    public void addTwoNumber(){

        //
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbers(l1, l2);

        //
        l1 = new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(1, new ListNode(2)))));
        l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbers(l1, l2);


        // 342 + 465 = 807
        l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbers(l1, l2);


        // 942 + 964 = 1906
        l1 = new ListNode(2, new ListNode(4, new ListNode(9)));
        l2 = new ListNode(5, new ListNode(6, new ListNode(9)));
        addTwoNumbers(l1, l2);


        //
        l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9))));
        addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int rem = 0;

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (l1 != null || l2 != null) {
            // get value
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;
            rem = sum % 10;

            cur.next = new ListNode(rem);
            cur = cur.next;

            // traverse to next node
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
         }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

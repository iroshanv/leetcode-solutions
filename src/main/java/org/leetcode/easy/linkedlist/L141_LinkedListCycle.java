package org.leetcode.easy.linkedlist;

import org.junit.jupiter.api.Test;
import org.leetcode.common.ListNode;

import java.util.HashSet;

/**
 * #HashTable #LinkedList #TwoPointers
 *
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * https://www.youtube.com/watch?v=gBTe7lFR3vc => NeetCode
 * https://www.youtube.com/watch?v=6OrZ4wAy4uE => NickWhite
 * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0141-Linked-List-Cycle/Animation/Animation.gif
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list,
 * where the tail connects to the 1st node (0-indexed).
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 *
 * Note that pos is not passed as a parameter.
 */
public class L141_LinkedListCycle {


    @Test
    public void linkedListCycle() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        ListNode node = new ListNode(one.val, two);
        node.next.next = three;
        node.next.next.next = four;
        node.next.next.next.next = two;

        boolean isCycle = hasCycle(node);
        System.out.println("is cycle = " + isCycle);
    }

    /**
     *  1 --> 2 --> 3 --> 4
     *        |___________|
     *
     */
    public static boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {

            // fast.next can be null because we are doing fast.next.next
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

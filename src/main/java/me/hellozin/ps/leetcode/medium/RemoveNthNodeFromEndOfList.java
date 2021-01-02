package me.hellozin.ps.leetcode.medium;

import me.hellozin.ps.leetcode.model.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode candidate = head;
        ListNode node = head;

        if (head.next == null) {
            // length is 1
            return null;
        } else if (head.next.next == null) {
            // length is 2
            if (n == 1) {
                head.next = null;
                return head;
            }
        }

        for (int i = 0; i < n; i++) {
            node = node.next;
        }

        if (node == null) {
            return head.next;
        }

        while (node.next != null) {
            candidate = candidate.next;
            node = node.next;
        }

        candidate.next = candidate.next.next;

        return head;
    }

}




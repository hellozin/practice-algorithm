package me.hellozin.ps.leetcode.medium;

import me.hellozin.ps.leetcode.model.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null;
        ListNode head = null;
        boolean carry = false;

        while (l1 != null || l2 != null) {
            int sum = 0;
            sum += l1 == null ? 0 : l1.val;
            sum += l2 == null ? 0 : l2.val;

            if (carry) {
                sum++;
                carry = false;
            }

            if (sum >= 10) {
                sum -= 10;
                carry = true;
            }

            if (node == null) {
                node = new ListNode(sum);
                head = node;
            } else {
                node.next = new ListNode(sum);
                node = node.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry) {
            node.next = new ListNode(1);
        }
        return head;
    }

}
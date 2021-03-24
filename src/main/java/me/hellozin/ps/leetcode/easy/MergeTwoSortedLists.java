package me.hellozin.ps.leetcode.easy;

/*
* https://leetcode.com/problems/merge-two-sorted-lists/
* */

import java.util.List;
import me.hellozin.ps.leetcode.model.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head;

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode temp;
        if (l1.val < l2.val) {
            temp = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            temp = new ListNode(l2.val);
            l2 = l2.next;
        }
        head = temp;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode selected = new ListNode(l1.val);

                temp.next = selected;
                temp = selected;
                l1 = l1.next;
            } else {
                ListNode selected = new ListNode(l2.val);

                temp.next = selected;
                temp = selected;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            temp.next = l2;
        } else {
            temp.next = l1;
        }

        return head;
    }
}
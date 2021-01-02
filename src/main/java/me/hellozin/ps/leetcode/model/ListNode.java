package me.hellozin.ps.leetcode.model;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode buildList(int... nodeValues) {
        ListNode node = null;
        ListNode head = null;

        for (int nodeValue : nodeValues) {
            if (node == null) {
                node = new ListNode(nodeValue);
                head = node;
            } else {
                node.next = new ListNode(nodeValue);
                node = node.next;
            }
        }

        return head;
    }

    public void printListNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    @Override
    public int hashCode() {
        ListNode listNode = this;
        int hash = 17;

        while (listNode != null) {
            hash = 31 * hash + listNode.val;
            listNode = listNode.next;
        }

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListNode)) {
            return false;
        }

        ListNode listNode = (ListNode) obj;
        ListNode thisNode = this;

        while (listNode != null && thisNode != null) {
            if (thisNode.val != listNode.val) {
                return false;
            }
            listNode = listNode.next;
            thisNode = thisNode.next;
        }

        return listNode == null && thisNode == null;
    }

}

package me.hellozin.ps.programmers.hash;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildNode(0,9,1);
        ListNode l2 = ListNode.buildNode(0,1);
        ListNode result = addTwoNumbers(l1, l2);
        ListNode.printListNode(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode buildNode(int... nodeValues) {
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

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
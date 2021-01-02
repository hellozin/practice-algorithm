package me.hellozin.ps.leetcode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import me.hellozin.ps.leetcode.model.ListNode;
import org.junit.jupiter.api.Test;

class RemoveNthNodeFromEndOfListTest {

    private final RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();

    @Test
    public void test() {
        check(list(1, 2, 3, 4, 5), 2, list(1, 2, 3, 5));
        check(list(1, 2, 3), 3, list(2, 3));
        check(list(1), 1, null);
        check(list(1, 2), 1, list(1));
    }

    private void check(ListNode head, int n, ListNode expected) {
        ListNode actual = removeNthNodeFromEndOfList.removeNthFromEnd(head, n);
        assertEquals(expected, actual);
    }

    private ListNode list(int... nodeValues) {
        return ListNode.buildList(nodeValues);
    }

}
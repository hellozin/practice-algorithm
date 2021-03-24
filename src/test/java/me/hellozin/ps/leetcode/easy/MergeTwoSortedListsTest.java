package me.hellozin.ps.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import me.hellozin.ps.leetcode.model.ListNode;
import org.junit.jupiter.api.Test;

class MergeTwoSortedListsTest {

    private final MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

    @Test
    public void test() {
        check(list(1,2,4), list(1,3,4), list(1,1,2,3,4,4));
        check(list(), list(), list());
        check(list(), list(0), list(0));
    }

    private void check(ListNode l1, ListNode l2, ListNode expected) {
        assertEquals(expected, mergeTwoSortedLists.mergeTwoLists(l1, l2));
    }

    private ListNode list(int... nodeValues) {
        return ListNode.buildList(nodeValues);
    }

}
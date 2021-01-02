package me.hellozin.ps.leetcode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import me.hellozin.ps.leetcode.model.ListNode;
import org.junit.jupiter.api.Test;

class AddTwoNumbersTest {

    private final AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    @Test
    public void test() {
        check(
                list(2, 4, 3),
                list(5, 6, 4),
                list(7, 0, 8)
        );
        check(
                list(0),
                list(0),
                list(0)
        );
        check(
                list(9, 9, 9, 9, 9, 9, 9),
                list(9, 9, 9, 9),
                list(8, 9, 9, 9, 0, 0, 0, 1)
        );
    }

    private void check(ListNode l1, ListNode l2, ListNode expected) {
        ListNode actual = addTwoNumbers.addTwoNumbers(l1, l2);
        assertEquals(expected, actual);
    }

    private ListNode list(int... nodeValues) {
        return ListNode.buildList(nodeValues);
    }

}
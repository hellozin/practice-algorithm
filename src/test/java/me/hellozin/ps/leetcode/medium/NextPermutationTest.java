package me.hellozin.ps.leetcode.medium;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class NextPermutationTest {

    private final NextPermutation nextPermutation = new NextPermutation();

    @Test
    public void test() {
        check(new int[]{1, 2, 3}, new int[]{1, 3, 2});
        check(new int[]{3, 2, 1}, new int[]{1, 2, 3});
        check(new int[]{1, 1, 5}, new int[]{1, 5, 1});
        check(new int[]{1}, new int[]{1});
        check(new int[]{1, 3, 2}, new int[]{2, 1, 3});
        check(new int[]{2, 3, 1}, new int[]{3, 1, 2});
        check(new int[]{5, 1, 1}, new int[]{1, 1, 5});
    }

    private void check(int[] input, int[] expected) {
        nextPermutation.nextPermutation(input);
        assertArrayEquals(expected, input);
    }

}
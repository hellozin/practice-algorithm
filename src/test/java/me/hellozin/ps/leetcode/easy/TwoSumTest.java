package me.hellozin.ps.leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class TwoSumTest {

    private final TwoSum twoSum = new TwoSum();

    @Test
    public void test() {
//        check(new int[]{2,7,11,15}, 9, new int[]{0,1});
//        check(new int[]{3,2,4}, 6, new int[]{1,2});
//        check(new int[]{3,3}, 6, new int[]{0,1});
        check(new int[]{-3, 4, 3, 90}, 0, new int[]{0, 2});
    }

    private void check(int[] nums, int target, int[] expected) {
        assertArrayEquals(expected, twoSum.twoSum(nums, target));
    }

}
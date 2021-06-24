package me.hellozin.ps.leetcode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContainerWithMostWaterTest {

    private final ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

    @Test
    public void test() {
        check(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49);
        check(new int[]{1, 1}, 1);
        check(new int[]{4, 3, 2, 1, 4}, 16);
        check(new int[]{1, 2, 1}, 2);
    }

    private void check(int[] input, int expected) {
        int actual = containerWithMostWater.maxArea(input);
        assertEquals(expected, actual);
    }

}
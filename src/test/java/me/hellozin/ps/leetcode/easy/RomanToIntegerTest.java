package me.hellozin.ps.leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RomanToIntegerTest {

    private final RomanToInteger romanToInteger = new RomanToInteger();

    @Test
    public void test() {
        check("III", 3);
        check("IV", 4);
        check("IX", 9);
        check("LVIII", 58);
        check("MCMXCIV", 1994);
    }

    private void check(String input, int expected) {
        int actual = romanToInteger.romanToInt(input);
        assertEquals(expected, actual);
    }

}
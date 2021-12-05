package me.hellozin.ps.leetcode.easy;

import org.junit.jupiter.api.Test;

class RomanToIntegerTest {

    private final RomanToInteger romanToInteger = new RomanToInteger();

    @Test
    public void test() {
        System.out.println(romanToInteger.romanToInt("III"));
        System.out.println(romanToInteger.romanToInt("IV"));
        System.out.println(romanToInteger.romanToInt("IX"));
        System.out.println(romanToInteger.romanToInt("LVIII"));
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }

}
package me.hellozin.ps.leetcode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LongestPalindromicSubstringTest {

    private final LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

    @Test
    public void debug() {
        System.out.println(longestPalindromicSubstring.longestPalindrome("abcbaaa"));
    }

    @Test
    public void test() {
        check("babad", "aba");
        check("cbbd", "bb");
        check("a", "a");
        check("ac", "a");
        check("ababa", "ababa");
        check("caababa", "ababa");
        check("aaaa", "aaaa");
        check("aaaabbb", "aaaa");
        check("bbaaaabbb", "bbaaaabb");
    }

    private void check(String input, String expected) {
        String actual = longestPalindromicSubstring.longestPalindrome(input);
        assertEquals(expected, actual);
    }
}
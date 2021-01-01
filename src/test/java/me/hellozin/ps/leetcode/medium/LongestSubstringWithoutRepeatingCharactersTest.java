package me.hellozin.ps.leetcode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LongestSubstringWithoutRepeatingCharactersTest {

    private final LongestSubstringWithoutRepeatingCharacters longestSubstring = new LongestSubstringWithoutRepeatingCharacters();

    @Test
    public void test() {
        check("abcabcbb", 3);
        check("bbbbb", 1);
        check("pwwkew", 3);
        check("", 0);
    }

    private void check(String input, int expected) {
        assertEquals(expected, longestSubstring.lengthOfLongestSubstring(input));
    }

}
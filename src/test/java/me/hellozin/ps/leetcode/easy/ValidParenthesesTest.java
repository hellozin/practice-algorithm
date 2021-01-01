package me.hellozin.ps.leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ValidParenthesesTest {

    private final ValidParentheses validParentheses = new ValidParentheses();

    @Test
    public void test() {
        check("()", true);
        check("()[]{}", true);
        check("(]", false);
        check("([)]", false);
        check("{[]}", true);
    }

    private void check(String input, boolean expected) {
        assertEquals(expected, validParentheses.isValid(input));
    }

}
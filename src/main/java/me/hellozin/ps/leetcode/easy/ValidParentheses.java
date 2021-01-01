package me.hellozin.ps.leetcode.easy;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (closingParentheses(c)) {
                if (!stack.isEmpty()) {
                    if (pairMatch(stack.peek(), c)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    private boolean closingParentheses(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    private boolean pairMatch(char val1, char var2) {
        return val1 == '(' && var2 == ')'
                || val1 == '{' && var2 == '}'
                || val1 == '[' && var2 == ']';
    }

}

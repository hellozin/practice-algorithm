package me.hellozin.ps.leetcode.easy;

// https://leetcode.com/problems/roman-to-integer/

public class RomanToInteger {
    enum ROMAN {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        private final int value;

        ROMAN(int i) {
            this.value = i;
        }
    }
    public int romanToInt(String s) {
        int answer = 0;
        int prevValue = Integer.MIN_VALUE;

        for (int i = s.length() - 1; i >= 0; i--) {
            int value = getRomanValueAt(s, i);
            if (value < prevValue) {
                answer -= value;
            } else {
                answer += value;
            }
            prevValue = value;
        }
        return answer;
    }

    private int getRomanValueAt(String s, int i) {
        char c = s.charAt(i);
        return ROMAN.valueOf(String.valueOf(c)).value;
    }
}

package me.hellozin.ps.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String input = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(input));
    }

    public static int lengthOfLongestSubstring(String s) {
        Queue<Character> charSet = new LinkedList<>();
        int max = 0;
        for (int head = 0; head < s.length(); head++) {
            System.out.print("before > ");
            System.out.print(charSet);
            char c = s.charAt(head);
            if (charSet.contains(c)) {
                while (charSet.peek() != c) {
                    charSet.poll();
                }
                if (charSet.peek() == c) {
                    charSet.poll();
                    charSet.offer(c);
                }
            } else {
                charSet.offer(c);
            }
            int length = charSet.size();
            if (length > max) {
                max = length;
            }
            System.out.print(" after > ");
            System.out.print(charSet);
            System.out.println();
        }
        return max;
    }

}

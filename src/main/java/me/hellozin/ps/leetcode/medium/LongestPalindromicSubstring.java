package me.hellozin.ps.leetcode.medium;

/*
 * 아쉬운점
 * - 회문 중심문자가 한개인 경우, 두개인 경우 코드 중복
 * - 최장길이 회문이 2글자 반복인 경우("aa") 첫번째 회문 체크에서 찾아내지 않아
 * 마지막에 추가로 확인하는 과정 중복
 * */

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int length = s.length();
        int center = length / 2;

        int distance = 1;
        int direction = -1;
        String longestPalindrome = "";

        /*
         * 가장 긴 회문이 될 수 있는 중심부터 점점 짧은 회문의 중심으로 이동하며
         * 회문이 맞는지 확인
         * ex_) 인덱스가 1 2 3 4 5 이면 3 -> 2 -> 4
         *
         * 중심이 한문자일 수도 있고 두문자일 수도 있기 때문에 두가지 경우를 체크한다 ("aba", "abba")
         * 코드 중복은 아쉽지만 일단 이대로..
         * */

        /*
         * 중심이 두 문자인 회문 체크
         * */
        while (1 < center && center < length - 1) {
            /*
             * 중심 두문자가 같은지 확인하고
             * 중심에서 가까운 순서대로 앞, 뒤 한칸씩 문자가 일치하는지 확인
             * */
            if (s.charAt(center) == s.charAt(center - 1)) {
                for (int i = 1; i < Math.min(length - center, center); i++) {
                    char front = s.charAt(center - 1 + (-1 * i));
                    char back = s.charAt(center + i);

                    if (front != back) {
                        break;
                    }

                    /*
                     * 발견된 회문의 길이가 이전의 회문보다 길면 갱신
                     * */
                    int palindromeLength = i * 2 + 2;
                    if (longestPalindrome.length() < palindromeLength) {
                        longestPalindrome = s.substring(center - i - 1, center + i + 1);
                    }
                }
            }
            /*
             * 중심 이동
             * */
            center += (direction * distance);
            distance++;
            direction *= -1;
        }

        /*
         * 사용한 전역변수 초기화
         * */
        center = length / 2;
        distance = 1;
        direction = -1;

        /*
         * 중심이 한문자인 회문 체크
         * */
        while (0 < center && center < length - 1) {
            /*
             * 중심에서 가까운 순서대로 앞, 뒤 한칸씩 문자가 일치하는지 확인
             * */
            for (int i = 1; i < Math.min(length - center, center + 1); i++) {
                char front = s.charAt(center + (-1 * i));
                char back = s.charAt(center + i);

                if (front != back) {
                    break;
                }

                /*
                 * 발견된 회문의 길이가 이전의 회문보다 길면 갱신
                 * */
                int palindromeLength = i * 2 + 1;
                if (longestPalindrome.length() < palindromeLength) {
                    longestPalindrome = s.substring(center - i, center + i + 1);
                }
            }
            /*
             * 중심 이동
             * */
            center += (direction * distance);
            distance++;
            direction *= -1;
        }

        /*
         * 위에서 발견된 회문이 없으면 같은 문자가 반복되는 회문을 탐색
         * */
        char continuousChar = s.charAt(0);
        int startIndexOfContinuousChar = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != continuousChar) {
                if (longestPalindrome.length() < i - startIndexOfContinuousChar) {
                    longestPalindrome = s.substring(startIndexOfContinuousChar, i);
                }
                continuousChar = s.charAt(i);
                startIndexOfContinuousChar = i;
            }
        }
        if (longestPalindrome.length() < length - startIndexOfContinuousChar) {
            longestPalindrome = s.substring(startIndexOfContinuousChar, length);
        }

        return longestPalindrome;
    }

}

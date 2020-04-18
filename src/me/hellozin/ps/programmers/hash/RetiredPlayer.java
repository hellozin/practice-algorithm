package me.hellozin.ps.programmers.hash;

import java.util.Arrays;

/*
* 제목 : 완주하지 못한 선수
* 링크 : https://programmers.co.kr/learn/courses/30/lessons/42576
* */

public class RetiredPlayer {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String expected = "leo";
        String actual = solution(participant, completion);
        System.out.println("result : " + expected.equals(actual));
    }

    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[participant.length-1];
    }

}
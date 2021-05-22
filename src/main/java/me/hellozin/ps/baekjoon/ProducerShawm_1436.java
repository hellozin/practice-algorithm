package me.hellozin.ps.baekjoon;

import java.util.Scanner;

public class ProducerShawm_1436 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int matchCount = 0;
        final String MATCH_KEY = "666";

        int number = 665;
        while (matchCount < N) {
            number++;
            if (String.valueOf(number).contains(MATCH_KEY)) {
                matchCount++;
            }
        }

        System.out.println(number);
    }
}

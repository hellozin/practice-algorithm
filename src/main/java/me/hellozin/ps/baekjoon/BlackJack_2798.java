package me.hellozin.ps.baekjoon;

/*
 * 문제: 블랙잭
 * link: https://www.acmicpc.net/problem/2798
 * 18256KB / 236ms
 * */

import java.util.Scanner;

public class BlackJack_2798 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = scanner.nextInt();
        }

        System.out.println("Ans: " + bruteForceTrace(cards, N, M));
    }

    public static int bruteForceTrace(int[] cards, int N, int M) {
        int max = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum == M) {
                        return M;
                    }
                    if (sum > max && sum < M) {
                        max = sum;
                    }
                }
            }
        }
        return max;
    }
}

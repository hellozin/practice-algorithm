package me.hellozin.ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bulk_7568 {

    public static void main(String[] args) {
        int N = 0;
        int[] x = null;
        int[] y = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String firstLine = reader.readLine();
            N = Integer.parseInt(firstLine);

            x = new int[N];
            y = new int[N];

            for (int i = 0; i < N; i++) {
                String[] splitLine = reader.readLine().split(" ");
                x[i] = Integer.parseInt(splitLine[0]);
                y[i] = Integer.parseInt(splitLine[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] rank = new int[N];
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (x[i] < x[j] && y[i] < y[j]) {
                    rank[i]++;
                } else if (x[i] > x[j] && y[i] > y[j]) {
                    rank[j]++;
                }
            }
        }

        System.out.print(rank[0] + 1);
        for (int i = 1; i < N; i++) {
            System.out.print(" " + (rank[i] + 1));
        }
    }

}

package me.hellozin.ps;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String[] cmds = {"D 1", "D 1"};
        solution(5, 2, cmds);
    }

    private static void solution(int n, int k, String[] cmds) {
        int[] table = new int[n];
        int stack = 1;
        for (String cmd : cmds) {
            switch (cmd.charAt(0)) {
                case 'D':
                    int distance = Integer.parseInt(String.valueOf(cmd.charAt(2)));
                    int idx = 0;
                    while (distance > 0) {
                        if (table[k + idx] == 0) {
                            distance--;
                        }
                        idx++;
                    }
                    table[k + idx] = stack++;
                    Arrays.stream(table).forEach(System.out::print);
                    System.out.println();
            }
        }
    }

}

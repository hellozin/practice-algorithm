package me.hellozin.ps.baekjoon;

public class NandM4_15652 {

    static int N = 0;
    static int M = 0;

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int M = scanner.nextInt();

        N = 1;
        M = 1;

        int[] sequence = new int[M];
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            dfs(i, M, sequence, builder);
        }
        System.out.println(builder.toString());
    }

    private static void dfs(int num, int depth, int[] sequence, StringBuilder builder) {
        sequence[M - depth] = num;
        depth--;

        if (depth == 0) {
            // print sequence
            for (int seq : sequence) {
                builder.append(seq);
                builder.append(' ');
            }
            builder.append('\n');
        } else {
            for (int i = num; i <= N; i++) {
                dfs(i, depth, sequence, builder);
            }
        }
    }
}

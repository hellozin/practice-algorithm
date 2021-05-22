package me.hellozin.ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepaintingChessBoard_1018 {

    public static void main(String[] args) {
        int rowCount = 0;
        int colCount = 0;
        int[][] chessBoard = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] firstLine = reader.readLine().split(" ");
            rowCount = Integer.parseInt(firstLine[0]);
            colCount = Integer.parseInt(firstLine[1]);

            chessBoard = new int[rowCount][colCount];

            for (int i = 0; i < rowCount; i++) {
                char[] row = reader.readLine().toCharArray();
                for (int j = 0; j < colCount; j++) {
                    chessBoard[i][j] = row[j];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int minFaultCount = Integer.MAX_VALUE;
        int[] color = new int[]{66, 87};        // 66: B, 87: W

        for (int startRow = 0; startRow <= rowCount - 8; startRow++) {
            for (int startCol = 0; startCol <= colCount - 8; startCol++) {
                int colorIdx = 0;               // 확인할 색깔이 B인지 W인지 고르는 index
                int[] faultCount = new int[2];  // 첫블록이 B인 경우와 W인 경우를 동시에 저장하기 위해 배열 사용

                // 8 * 8 크기만큼 trace
                for (int row = startRow; row < startRow + 8; row++) {
                    colorIdx = colorIdx == 0 ? 1 : 0;   // 행의 첫 색깔은 이전 행의 마지막 색과 같아 한번더 switch
                    for (int col = startCol; col < startCol + 8; col++) {
                        if (chessBoard[row][col] != color[colorIdx]) {
                            faultCount[0]++;
                        } else {
                            faultCount[1]++;
                        }
                        colorIdx = colorIdx == 0 ? 1 : 0;
                    }
                }
                // 첫블록이 B인 경우와 W인 경우 중 작은 값 선택
                int currentMin = Math.min(faultCount[0], faultCount[1]);
                if (currentMin < minFaultCount) {
                    minFaultCount = currentMin;
                }
            }
        }

        System.out.println(minFaultCount);
    }
}

package Q1022_소용돌이_예쁘게_출력하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int r1, r2, c1, c2;
    private static int max, width, height, total, map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(stk.nextToken());
        c1 = Integer.parseInt(stk.nextToken());
        r2 = Integer.parseInt(stk.nextToken());
        c2 = Integer.parseInt(stk.nextToken());
        
        height = r2 - r1 + 1;
        width = c2 - c1 + 1;
        map = new int[height][width];
        total = height * width;

        // 소용돌이 휘감기
        int maxDepth = Math.max(Math.abs(r1), Math.max(Math.abs(r2), Math.max(Math.abs(c1), Math.abs(c2)))); // 가장 깊은 depth 찾기
        go(maxDepth);

        // 출력
        print();
    }

    private static void go(int maxDepth) {
        // 마지막을 시작으로 depth 0까지 소용돌이 진행하기
        // 좌, 상, 우, 하.
        // 좌: d-1번 이동
        // 상: d-1번 이동
        // 우: d-1번 이동
        // 하: d-2번 이동
        for (int i = maxDepth; i >= 0; i--) {
            if (total <= 0) {
                return;
            }

            int currVal = (i * 2 + 1) * (i * 2 + 1);
            int currRow = i;
            int currCol = i;
            put(map, currRow, currCol, currVal);

            // 좌
            int len = i * 2 + 1;
            for (int l = 1; l < len; l++) {
                currCol--;
                currVal--;
                put(map, currRow, currCol, currVal);
            }

            // 상
            for (int u = 1; u < len; u++) {
                currRow--;
                currVal--;
                put(map, currRow, currCol, currVal);
            }
            // 우
            for (int r = 1; r < len; r++) {
                currCol++;
                currVal--;
                put(map, currRow, currCol, currVal);
            }

            // 하
            for (int d = 2; d < len; d++) {
                currRow++;
                currVal--;
                put(map, currRow, currCol, currVal);
            }
        }

    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        String maxStr = String.valueOf(max);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sb.append(numToStr(map[i][j], maxStr)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static String numToStr(int num, String maxStr) {
        String ret = String.valueOf(num);
        return String.format("%" + maxStr.length() + "s", ret);
    }

    private static void put(int[][] map, int row, int col, int value) {
        if (row < r1 || row > r2 || col < c1 || col > c2) {
            return;
        }
        map[row - r1][col - c1] = value;
        max = Math.max(max, value);
        total--;
    }
}

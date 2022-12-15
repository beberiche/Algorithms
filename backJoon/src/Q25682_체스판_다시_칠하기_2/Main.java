package Q25682_체스판_다시_칠하기_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        char[] temp;
        for (int i = 0; i < N; i++) {
            temp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = temp[j];
            }
        }

        int[][] prefixSumB = prefixSum('B');
        int[][] prefixSumW = prefixSum('W');
        System.out.println(Math.min(calculate(prefixSumB), calculate(prefixSumW)));
    }

    private static int calculate(int[][] prefixSum) {
        int cnt = (int) 1e9;
        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = 1; j <= M - K + 1; j++) {
                int num = prefixSum[i + K - 1][j + K - 1] - prefixSum[i + K - 1][j - 1] - prefixSum[i - 1][j + K - 1] + prefixSum[i - 1][j - 1];
                cnt = Math.min(cnt, num);
            }
        }
        return cnt;
    }

    private static int[][] prefixSum(char st) {
        int[][] temp = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int curr = ((i + j) % 2 == 0) ? board[i][j] == st ? 0 : 1 : board[i][j] == st ? 1 : 0;
                temp[i + 1][j + 1] = temp[i + 1][j] + temp[i][j + 1] - temp[i][j] + curr;
            }
        }
        return temp;
    }
}

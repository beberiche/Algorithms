package Q17845_수강_과목;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int[][] dp = new int[K + 1][N + 1];

        for (int i = 1; i <= K; i++) {
            stk = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(stk.nextToken());
            int t = Integer.parseInt(stk.nextToken());

            for (int j = 0; j < t && j <= N; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            for (int j = t; j <= N; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - t] + val);
            }
        }
        System.out.println(dp[K][N]);
    }
}

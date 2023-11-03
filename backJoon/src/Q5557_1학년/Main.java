package Q5557_1학년;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        dp = new long[N][21];
        dp[0][Integer.parseInt(stk.nextToken())]++;
        for (int i = 1; i < N - 1; i++) {
            int num = Integer.parseInt(stk.nextToken());
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] != 0) {
                    if (j + num >= 0 && j + num <= 20) {
                        dp[i][j + num] += dp[i - 1][j];
                    }

                    if (j - num >= 0 && j - num <= 20) {
                        dp[i][j - num] += dp[i - 1][j];
                    }
                }
            }
        }

        System.out.println(dp[N - 2][Integer.parseInt(stk.nextToken())]);
    }
}

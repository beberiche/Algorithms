package Q10164_격자상의_경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static int[][] dp1, dp2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int O = Integer.parseInt(stk.nextToken());

        if (O == 0) {
            dp1 = new int[N][M];
            System.out.println(go(dp1));
            return;
        }
        O--;

        int r1 = O / M;
        int c1 = O % M;
        int r2 = N - r1;
        int c2 = M - c1;

        dp1 = new int[r1 + 1][c1 + 1];
        dp2 = new int[r2][c2];

        int ret1 = go(dp1);
        int ret2 = go(dp2);
        System.out.println(ret1 * ret2);
    }

    private static int go(int[][] dp) {

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}

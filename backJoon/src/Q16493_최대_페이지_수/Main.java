package Q16493_최대_페이지_수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[][] a = new int[M + 1][2];
        int[][] dp = new int[M + 1][301];
        for (int i = 1; i <= M; i++) {
            stk = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(stk.nextToken());
            a[i][1] = Integer.parseInt(stk.nextToken());
            dp[i][a[i][0]] = a[i][1];
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (j <= a[i][0]) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - a[i][0]] + a[i][1]);
            }
        }

        System.out.println(dp[M][N]);
    }
}

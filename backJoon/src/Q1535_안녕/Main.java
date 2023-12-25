package Q1535_안녕;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N + 1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }
        int[] b = new int[N + 1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            b[i] = Integer.parseInt(stk.nextToken());
        }

        int[][] dp = new int[N + 1][104];
        for (int i = 1; i <= N; i++) {
            int cost = a[i];
            int val = b[i];

            for (int j = 0; j < 100; j++) {
                if (j - cost < 0) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + val);
            }
        }

        System.out.println(dp[N][99]);

    }
}

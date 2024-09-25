package Q14916_거스름돈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[100000 + 1];
        int INF = (int) 1e9;
        Arrays.fill(dp, INF);

        dp[0] = 0;
        dp[2] = 1;
        dp[4] = 2;
        for (int i = 5; i <= N; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
        }
        dp[0] = INF;
        System.out.println(dp[N] == INF ? -1 : dp[N]);
    }
}


package Q22115_창영이와_커피;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        if (K == 0) {
            System.out.println(0);
            return;
        }

        int[][] dp = new int[N + 1][100004];
        Arrays.fill(dp[0], N+1);

        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(stk.nextToken());

            for (int j = 0; j < num; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            dp[i][num] = 1;

            for (int j = num + 1; j <= K; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - num] + 1);
            }
        }

        System.out.println(dp[N][K] == N+1 ? -1 : dp[N][K]);
    }
}

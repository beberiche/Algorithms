package Q15990_1_2_3_더하기_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] dp = new long[(int) 1e6 + 4][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        Arrays.fill(dp[3], 1);

        int MOD = (int) 1e9 + 9;
        for (int i = 4; i <= (int) 1e6; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append((dp[num][1] + dp[num][2] + dp[num][3]) % MOD).append("\n");
        }
        System.out.print(sb.toString());
    }
}

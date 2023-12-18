package Q4811_알약;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        long dp[][] = new long[31][31];

        for (int i = 1; i < 31; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= 30; i++) {
            for (int j = 0; j < 30; j++) {
                dp[i][j] = (j == 0) ? dp[i - 1][j + 1] : dp[i][j - 1] + dp[i - 1][j + 1];
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            System.out.println(dp[N][0]);
        }
    }
}

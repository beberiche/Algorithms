package Q2482_색상환;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[N+1][K+1];

        for(int i=1; i<dp.length; i++) dp[i][1] = i;

        for(int i=4; i<=N; i++) {
            for(int j=2; j<=K; j++) {
                dp[i][j] = (dp[i-2][j-1] + dp[i-1][j]) % (int) (1e9+3);
            }
        }
        System.out.println(dp[N][K]);
    }
}

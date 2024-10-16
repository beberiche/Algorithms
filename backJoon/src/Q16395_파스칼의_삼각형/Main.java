package Q16395_파스칼의_삼각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int[][] dp = new int[N + 1][K + 1];

        dp[1][1] = 1;
        for(int i=2; i<=N; i++) {
            for(int j=1; j<=K; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        System.out.println(dp[N][K]);
    }
}

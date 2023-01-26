package Q3282_0_1_Knapsack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
    static int[][] items;
    static int[] dp;
    static int N, K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        for(int t=1; t<=T; t++) {
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            K = Integer.parseInt(stk.nextToken());
            items = new int[N+1][2];
            dp = new int[K+1];
            for(int i=1; i<=N; i++) {
                stk = new StringTokenizer(br.readLine());
                items[i][0] = Integer.parseInt(stk.nextToken());
                items[i][1] = Integer.parseInt(stk.nextToken());
                for (int j = K; j >= 1; j--)
                    if (items[i][0] <= j) dp[j] = Math.max(dp[j], dp[j - items[i][0]] + items[i][1]);
            }
            System.out.printf("#%d %d", t, dp[K]);
        }
    }
}

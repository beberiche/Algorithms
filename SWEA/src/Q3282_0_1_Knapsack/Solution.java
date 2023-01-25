package Q3282_0_1_Knapsack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] items;
    static int[][] dp;
    static int N, K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        for(int t=1; t<=T; t++) {
            sb.append("#").append(t).append(" ");
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            K = Integer.parseInt(stk.nextToken());
            items = new int[N+1][2];
            for(int i=1; i<=N; i++) {
                stk = new StringTokenizer(br.readLine());
                items[i][0] = Integer.parseInt(stk.nextToken());
                items[i][1] = Integer.parseInt(stk.nextToken());
            }

            dp = new int[N+1][K+1];
            for(int i=0; i<=N; i++) {
                for(int j=0; j<=K; j++) {
                    if(i==0 || j==0) continue;
                    dp[i][j] = j-items[i][0] >= 0 ?Math.max(dp[i-1][j],dp[i-1][j-items[i][0]] + items[i][1]) : dp[i-1][j];
                }
            }
            sb.append(dp[N][K]).append("\n");
        }
        System.out.print(sb);
    }
}

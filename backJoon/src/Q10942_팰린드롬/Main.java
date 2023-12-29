package Q10942_팰린드롬;

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

        int[][] dp = new int[N + 1][N + 1];

        for (int cnt = 1; cnt <= N; cnt++) {
            for (int s = 1; s <= N - cnt + 1; s++) {
                int e = s + cnt - 1;
                if (s == e) dp[s][e] = 1;
                else if (cnt == 2 && a[s] == a[e]) {
                    dp[s][e] = 1;
                } else if (cnt > 2 && a[s] == a[e] && dp[s + 1][e - 1] == 1) {
                    dp[s][e] = 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            sb.append(dp[s][e]).append("\n");
        }
        System.out.print(sb.toString());
    }
}

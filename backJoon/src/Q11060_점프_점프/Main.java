package Q11060_점프_점프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];
        int[] a = new int[N];

        int MAX = (int) 1e9;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
            dp[i] = MAX;
        }

        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] == MAX) continue;
            for (int j = i + 1; j <= i + a[i]; j++) {
                if (j >= N) break;
                if (dp[j] > dp[i] + 1) {
                    dp[j] = dp[i] + 1;
                }
            }
        }
        System.out.println(dp[N - 1] == MAX ? -1 : dp[N - 1]);
    }
}

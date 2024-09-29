package Q1660_캡틴_이다솜;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int MAX = 125;
        int[] a = new int[MAX + 1];
        int[] sum = new int[MAX + 1];
        a[1] = sum[1] = 1;
        int len = -1;
        for (int i = 2; i <= MAX; i++) {
            a[i] = a[i - 1] + i;
            sum[i] = sum[i - 1] + a[i];
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, (int) 1e9);

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= MAX; j++) {
                if (sum[j] > i) break;
                dp[i] = Math.min(dp[i], dp[i - sum[j]] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}

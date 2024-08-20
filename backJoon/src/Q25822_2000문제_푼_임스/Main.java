package Q25822_2000문제_푼_임스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double d = Double.parseDouble(br.readLine());
        int coin = Math.min((int) (d / 0.99), 2);

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];

        int max = 0;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
            max = Math.max(max, a[i]);
        }

        int[][] dp = new int[N][coin + 1];
        dp[0][0] = a[0] > 0 ? 1 : 0;
        if (dp[0][0] == 0 && coin > 0) {
            dp[0][1] = 1;
        }

        for (int i = 1; i < N; i++) {
            boolean check = a[i] > 0;
            for (int j = check ? 0 : 1; j <= coin; j++) {
                dp[i][j] = check ? dp[i - 1][j] : dp[i - 1][j - 1];
                dp[i][j]++;
            }
        }

        int ret = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= coin; j++) {
                ret = Math.max(ret, dp[i][j]);
            }
        }

        System.out.println(ret + "\n" + max);
    }
}

package Q1912_연속합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[], dp[], ans;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
    }

    private static void solve() {
        dp = new int[N + 1];

        dp[0] = arr[0];
        ans = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            ans = Math.max(ans, dp[i]);
        }
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

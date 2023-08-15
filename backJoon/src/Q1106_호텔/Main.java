package Q1106_호텔;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int C, N, arr[][], dp[][], MAX = 1000*100, ans = 987654321;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        C = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());

        arr = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
        }
    }

    private static void solve() {
        dp = new int[N + 1][MAX+1];

        for (int i = 1; i <= N; i++) {
            int c = arr[i][0];
            int n = arr[i][1];
            for (int j = 0; j < c; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            for (int j = c; j <= MAX; j++) {
                dp[i][j] = Math.max(dp[i][j - c] + n, dp[i - 1][j]);
                if(dp[i][j]>=C&& ans > j) ans = j;
            }
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

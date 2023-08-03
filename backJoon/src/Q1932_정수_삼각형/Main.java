package Q1932_정수_삼각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[][], dp[][];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            StringTokenizer stk = new StringTokenizer(str);
            int idx= 0;
            while(stk.hasMoreTokens()) {
                arr[i][idx++] = Integer.parseInt(stk.nextToken());
            }
        }
    }

    private static void solve() {
        dp = new int[N][N];
        dp[0][0] = arr[0][0];

        for (int i = 1; i < N; i++) {
            dp[i][0] += arr[i][0]+dp[i - 1][0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
            }
        }
    }

    private static void output() {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(dp[N - 1][i], ans);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

package Q2624_동전_바꿔주기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int N, K, arr[][], dp[][];

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }

    private void output() {
        System.out.println(dp[K][N]);
    }

    private void solve() {
        for (int i = arr[1][0]; i <= arr[1][0] * arr[1][1] && i <= N; i += arr[1][0]) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= K; i++) {
            int num = arr[i][0];
            int cnt = arr[i][1];
            for (int j = 1; j <= cnt && num * j <= N; j++) {
                dp[i][num * j]++;
                for (int k = num * j + 1; k <= N; k++) {
                    dp[i][k] += dp[i - 1][k - num * j];
                }
            }

            for (int j = 1; j <= N; j++) {
                dp[i][j] += dp[i - 1][j];
            }
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[K + 1][2];
        dp = new int[K + 1][N + 1];
        for (int i = 1; i <= K; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
        }
    }
}

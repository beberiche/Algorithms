package Q2666_벽장문의_이동;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int a[], N, M, dp[][][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());

        M = Integer.parseInt(br.readLine());

        a = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int INF = (int) 1e9;
        dp = new int[M + 1][N + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int ans = go(x, y, 1);

        System.out.println(ans);
    }

    private static int go(int x, int y, int idx) {
        if (idx > M) {
            return 0;
        }

        if (dp[idx][x][y] != -1) return dp[idx][x][y];

        dp[idx][x][y] = 0;

        int d1 = Math.abs(a[idx] - x) + go(a[idx], y, idx + 1);
        int d2 = Math.abs(a[idx] - y) + go(x, a[idx], idx + 1);

        return dp[idx][x][y] = Math.min(d1, d2);
    }
}

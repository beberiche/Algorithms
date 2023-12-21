package Q16974_레벨_햄버거;

import java.util.Scanner;

public class Main {

    int N;
    long X, dp[][];
    long ans;

    public static void main(String[] args) {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }

    private void output() {
        System.out.println(ans);
    }

    private void solve() {
        dp = new long[N + 1][2];

        dp[0][0] = 0; // 빵
        dp[0][1] = 1; // 패티
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] * 2 + 2;
            dp[i][1] = dp[i - 1][1] * 2 + 1;
        }

        ans = go(N, X);
    }

    private long go(int N, long X) {
        if (N == 0) return 1;

        long b = dp[N - 1][0] + dp[N - 1][1];
        if (X == 1) {
            return 0;
        } else if (X == b + 1) {
            return dp[N - 1][1];
        } else if (X < b + 1) {
            return go(N - 1, X - 1);
        } else if (X == b + 2) {
            return dp[N - 1][1] + 1;
        } else if (X <= 2 * b + 2) {
            return dp[N - 1][1] + 1 + go(N - 1, X - (b + 2));
        } else {
            return dp[N - 1][1] * 2 + 1;
        }
    }


    private void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        X = sc.nextLong();
    }
}

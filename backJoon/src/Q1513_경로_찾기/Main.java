package Q1513_경로_찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int N, M, C, a[][], dp[][][][];
    final int MOD = (int) 1e6 + 7;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        int cnt = m.input();
        for (int i = 0; i <= cnt; i++) {
            int ret = m.solve(1, 1, i, 0);
            sb.append(ret).append(" ");
        }
        m.output();
    }

    private void output() {
        System.out.print(sb.toString());
    }

    private int solve(int r, int c, int cnt, int prev) {
        if (r > N || c > M || cnt < 0) return 0;
        if (r == N && c == M) {
            if (a[r][c] == 0 && cnt == 0) return 1;
            if (a[r][c] > prev && cnt == 1) return 1;
            return 0;
        }

        if (dp[r][c][cnt][prev] != -1) return dp[r][c][cnt][prev];

        dp[r][c][cnt][prev] = 0;
        if (a[r][c] == 0) {
            dp[r][c][cnt][prev] = solve(r + 1, c, cnt, prev) + solve(r, c + 1, cnt, prev);
        } else if (a[r][c] > prev) {
            dp[r][c][cnt][prev] = solve(r + 1, c, cnt - 1, a[r][c]) + solve(r, c + 1, cnt - 1, a[r][c]);
        }

        return dp[r][c][cnt][prev] %= MOD;
    }

    private int input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        a = new int[N + 1][M + 1];
        for (int i = 1; i <= C; i++) {
            stk = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            a[r][c] = i;
        }

        dp = new int[N + 1][M + 1][C + 1][C + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 0; k <= C; k++) {
                    for (int l = 0; l <= C; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        return C;
    }
}

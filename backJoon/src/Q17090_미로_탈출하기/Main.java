package Q17090_미로_탈출하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int N, M, dp[][];
    char map[][];

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }

    private void output() {
    }

    private void solve() {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans += dfs(i, j);
            }
        }
        System.out.println(ans);
    }

    private int dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= N || j >= M) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = 0;
        int nr, nc;

        nr = map[i][j] == 'U' ? i - 1 : map[i][j] == 'D' ? i + 1 : i;
        nc = map[i][j] == 'L' ? j - 1 : map[i][j] == 'R' ? j + 1 : j;

        return dp[i][j] = dfs(nr, nc);
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        dp = new int[N][M];
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                dp[i][j] = -1;
            }
        }
    }
}

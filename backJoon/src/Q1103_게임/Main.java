package Q1103_게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, dp[][];
    static String map[];
    static boolean visited[][];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        map = new String[N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }
    }

    private static int dfs(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= M || map[r].charAt(c) == 'H') {
            return 0;
        }

        if (visited[r][c]) {
            System.out.println(-1);
            System.exit(0);
        }

        if (dp[r][c] > 0) return dp[r][c];

        visited[r][c] = true;
        int move = map[r].charAt(c) - '0';
        int ret = 0;
        ret = Math.max(ret, dfs(r + move, c) + 1);
        ret = Math.max(ret, dfs(r - move, c) + 1);
        ret = Math.max(ret, dfs(r, c + move) + 1);
        ret = Math.max(ret, dfs(r, c - move) + 1);
        visited[r][c] = false;

        dp[r][c] = ret;
        return dp[r][c];
    }

    private static void solve() throws Exception {
        dp = new int[N][M];
        visited = new boolean[N][M];
        dfs(0, 0);
    }

    private static void output() {
        System.out.println(dp[0][0]);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

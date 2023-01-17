package Q1937_욕심쟁이_판다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] dp;
    static int n;
    static final int[] dr = new int[]{-1, 0, 1, 0};
    static final int[] dc = new int[]{0, -1, 0, 1};
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, DFS(i, j));
            }
        }
        System.out.println(ans);
    }

    private static int DFS(int r, int c) {
        if (dp[r][c] != 0)
            return dp[r][c];

        dp[r][c] = 1;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

            if(map[r][c] < map[nr][nc]) {
                dp[r][c] = Math.max(dp[r][c], DFS(nr, nc) + 1);
            }
        }
        return dp[r][c];
    }
}

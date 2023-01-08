package Q15948_기념품_수집;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static char map[][];

    static class Pos {
        int r;
        int c;
        String str;

        public Pos(int r, int c, String str) {
            this.r = r;
            this.c = c;
            this.str = str;
        }
    }

    static int R, C;
    static final int dr[] = {-1, 0, 1, 0};
    static final int dc[] = {0, 1, 0, -1};
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            R = Integer.parseInt(stk.nextToken());
            C = Integer.parseInt(stk.nextToken());

            map = new char[R][C];
            for (int i = 0; i < R; i++) {
                char temp[] = br.readLine().toCharArray();
                for (int j = 0; j < C; j++) {
                    map[i][j] = temp[j];
                }
            }
            ans = 1;
            dfs(0, 0, map[0][0] + "");
            System.out.printf("#%d %d\n", t, ans);
        }
    }

    private static void dfs(int r, int c, String str) {
        ans = Math.max(ans, str.length());

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;

            if (str.indexOf(map[nr][nc]) == -1) dfs(nr, nc, str + map[nr][nc]);
        }
    }
}

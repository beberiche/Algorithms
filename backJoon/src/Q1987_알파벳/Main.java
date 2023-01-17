package Q1987_알파벳;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp[j] - 'A';
            }
        }
        DFS(0, 0, 1 << map[0][0], 1);
        System.out.println(ans);
    }

    public static void DFS(int r, int c, int bit, int dist) {
        if (dist > ans) ans = dist;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C || (bit & 1 << map[nr][nc]) > 0) continue;
            DFS(nr, nc, bit | 1 << map[nr][nc], dist + 1);
        }
    }
}

package Q1868_파핑파핑_지뢰찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static char map[][];
    static int N, ans;
    static int[] dr = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dc = {-1, 1, 0, 0, -1, 1, -1, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    private static void input() throws Exception {
        ans = 0;
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '.' && checkBomb(i, j)) {
                    bfs(i, j);
                    ans++;
                }
            }
        }
    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        map[r][c] = '0';
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int d = 0; d < 8; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (map[nr][nc] == '0' || map[nr][nc] == '1') continue;
                if (!checkBomb(nr, nc)) {
                    map[nr][nc] = '1';
                } else {
                    map[nr][nc] = '0';
                    q.add(new int[]{nr, nc});
                }
            }
        }

    }

    private static boolean checkBomb(int r, int c) {
        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if (map[nr][nc] == '*') return false;
        }
        return true;
    }

    private static void output(int t) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '.') ans++;
            }
        }
        System.out.println("#" + t + " " + ans);
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            input();
            solve();
            output(t);
        }
    }
}

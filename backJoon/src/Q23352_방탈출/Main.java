package Q23352_방탈출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, arr[][], dr[] = {-1, 0, 1, 0}, dc[] = {0, -1, 0, 1}, len, ans;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
    }

    private static int[] bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[N][M];

        q.add(new int[]{i, j, 0});
        visited[i][j] = true;

        int start = arr[i][j];
        int end = 0;
        int dist = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            end = arr[curr[0]][curr[1]];
            dist = curr[2];
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || arr[nr][nc] == 0 || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, curr[2] + 1});
            }
        }

        return new int[]{dist, start + end};
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0) {
                    int[] ret = bfs(i, j);
                    if (len < ret[0]) {
                        len = ret[0];
                        ans = ret[1];
                    } else if (len == ret[0]) {
                        ans = Math.max(ret[1], ans);
                    }
                }
            }
        }
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

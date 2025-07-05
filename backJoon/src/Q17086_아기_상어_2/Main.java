package Q17086_아기_상어_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dc = {-1, 0, 1, 1, -1, 0, 1, -1};
    private static int N, M;
    private static int[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        // 최단 경로 중 가장 먼 거리 찾기
        a = new int[N][M];

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] == 0) {
                    ans = Math.max(bfs(a, i, j), ans);
                }
            }
        }
        System.out.println(ans);
    }

    private static int bfs(int[][] a, int i, int j) {
        boolean[][] visited = new boolean[a.length][a[0].length];
        visited[i][j] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j, 0});

        int ret = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];

            if (a[r][c] == 1) {
                ret = d;
                q.clear();
                break;
            }

            for (int k = 0; k < 8; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, d + 1});
            }
        }

        return ret;
    }
}

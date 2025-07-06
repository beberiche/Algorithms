package Q17086_아기_상어_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    private static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dc = {-1, 0, 1, 1, -1, 0, 1, -1};
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        // 최단 경로 중 가장 먼 거리 찾기
        int[][] a = new int[N][M];
        int[][] dist = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
                dist[i][j] = a[i][j] == 1 ? 0 : -1; // 초기화
                if (a[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int ans = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int k = 0; k < 8; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }

                if (dist[nr][nc] == -1) { // 방문하지 않은 곳
                    dist[nr][nc] = dist[r][c] + 1;
                    ans = Math.max(ans, dist[nr][nc]);
                    q.add(new int[]{nr, nc});
                }
            }
        }
        System.out.println(ans);
    }
}

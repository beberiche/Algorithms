package Q1926_그림;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static boolean[][] visited;
    private static int N, M, a[][], dr[] = {-1, 0, 1, 0}, dc[] = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        a = new int[N][M];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int ans = 0;
        int cnt = 0;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && a[i][j] == 1) {
                    ans = Math.max(ans, bfs(i, j));
                    cnt++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n").append(ans);
        System.out.print(sb.toString());
    }

    private static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{r, c});
        visited[r][c] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            cnt++;

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || a[nr][nc] == 0) {
                    continue;
                }

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
        return cnt;
    }
}

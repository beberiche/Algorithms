package Q1303_전쟁_전투;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static boolean[][] visited;
    private static char[][] a;
    private static int N, M;
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        a = new char[M][];
        for (int i = 0; i < M; i++) {
            a[i] = br.readLine().toCharArray();
        }

        visited = new boolean[M][N];
        int W = 0;
        int B = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int ret = bfs(i, j);
                    if (a[i][j] == 'B') {
                        B += ret;
                    } else {
                        W += ret;
                    }
                }
            }
        }
        System.out.printf("%d %d\n", W, B);
    }

    private static int bfs(int i, int j) {
        char color = a[i][j];
        visited[i][j] = true;
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            cnt++;

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= M || nc >= N || a[nr][nc] != color || visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
        return cnt * cnt;
    }
}

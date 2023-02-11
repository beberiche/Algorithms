package Q14442_벽_부수고_이동하기_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K;
    private static int[][] map;
    private static boolean[][][] visited;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, -1, 0, 1};

    private static void input() throws Exception {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        map = new int[N][M];

        String str;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][M][K + 1];
        q.add(new int[]{0, 0, 0, 1});
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == N - 1 && cur[1] == M - 1) {
                return cur[3];
            }
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                boolean isBlock = map[nr][nc] == 1;
                if (isBlock && cur[2] + 1 <= K && !visited[nr][nc][cur[2] + 1]) {
                    visited[nr][nc][cur[2] + 1] = true;
                    q.add(new int[]{nr, nc, cur[2] + 1, cur[3] + 1});
                } else if (!isBlock && !visited[nr][nc][cur[2]]) {
                    visited[nr][nc][cur[2]] = true;
                    q.add(new int[]{nr, nc, cur[2], cur[3] + 1});
                }
            }
        }
        return -1;
    }

    private static void output() {
        System.out.println(bfs());
    }

    public static void main(String[] args) throws Exception {
        input();
        output();
    }
}

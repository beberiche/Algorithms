package Q1743_음식물_피하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int[][] a = new int[N][M];
        for (int i = 0; i < K; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken())-1;
            int n2 = Integer.parseInt(stk.nextToken())-1;
            a[n1][n2] = 1;
        }

        int[] dr = new int[]{-1, 1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};
        boolean[][] visited = new boolean[N][M];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] > 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    int cnt = 0;
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        cnt++;
                        for (int d = 0; d < 4; d++) {
                            int nr = curr[0] + dr[d];
                            int nc = curr[1] + dc[d];

                            if (nr < 0 || nc < 0 || nr >= N || nc >= M || a[nr][nc] == 0 || visited[nr][nc]) {
                                continue;
                            }

                            visited[nr][nc] = true;
                            q.add(new int[]{nr, nc});
                        }
                    }
                    ans = Math.max(ans, cnt);
                }
            }
        }
        System.out.println(ans);
    }
}

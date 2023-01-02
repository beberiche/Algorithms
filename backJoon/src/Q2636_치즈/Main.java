package Q2636_치즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int cnt, hour, ans = 0;
    static final int[] dr = new int[]{-1, 0, 1, 0};
    static final int[] dc = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cnt++;
            }
        }

        while (true) {
            if (cnt == 0) {
                System.out.println(hour);
                System.out.println(ans);
                break;
            } else ans = cnt;

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{0, 0});
            visited = new boolean[N][M];
            visited[0][0] = true;
            hour++;

            while (!q.isEmpty()) {
                int[] curr = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                    if (visited[nr][nc]) continue;

                    visited[nr][nc] = true;
                    if (map[nr][nc] == 1) {
                        cnt--;
                        map[nr][nc] = 0;
                    } else q.add(new int[]{nr, nc});

                }
            }
        }
    }
}

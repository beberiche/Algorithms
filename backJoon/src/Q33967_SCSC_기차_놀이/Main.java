package Q33967_SCSC_기차_놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[][] a;
    private static boolean[][] visited;
    private static int[] dr = {0, 0, -1, 1};
    private static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int w = N * 2;
        int h = 5;

        a = new int[h][w];

        String train = br.readLine();
        // map 생성
        for (int i = 0; i < N; i++) {
            char c = train.charAt(i);
            int col = i * 2;
            switch (c) {
                case '[':
                    goC(col);
                    break;
                case ']':
                    goCRev(col);
                    break;
                case '5':
                    goS(col);
                    break;
                case '2':
                    goSRev(col);
                    break;
            }
        }

        visited = new boolean[h][w];

        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (a[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(int r, int c) {
        visited[r][c] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= a[0].length) continue;
                if (a[nr][nc] == 1 || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }

    private static void goC(int col) {
        for (int i = 0; i < 5; i++) {
            if (i == 0 || i == 4) {
                a[i][col + 1] = 1;
            }
            a[i][col] = 1;
        }
    }

    private static void goCRev(int col) {
        for (int i = 0; i < 5; i++) {
            if (i == 0 || i == 4) {
                a[i][col] = 1;
            }
            a[i][col + 1] = 1;
        }
    }

    private static void goS(int col) {
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                a[i][col] = 1;
                a[i][col + 1] = 1;
            } else if (i == 1) {
                a[i][col] = 1;
            } else {
                a[i][col + 1] = 1;
            }
        }
    }

    private static void goSRev(int col) {
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                a[i][col] = 1;
                a[i][col + 1] = 1;
            } else if (i == 1) {
                a[i][col + 1] = 1;
            } else {
                a[i][col] = 1;
            }
        }
    }
}

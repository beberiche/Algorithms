package Q1660_말이_되고픈_원숭이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    int K, W, H, a[][], ans = -1;
    int dr[] = {-1, 0, 1, 0};
    int dc[] = {0, -1, 0, 1};

    int drr[] = {-2, -2, -1, -1, 1, 1, 2, 2};
    int dcc[] = {1, -1, 2, -2, 2, -2, -1, 1};

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }

    private void output() {
        System.out.println(ans);
    }


    private void solve() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0});

        boolean visited[][][] = new boolean[H][W][K + 1];
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == H - 1 && curr[1] == W - 1) {
                ans = curr[2];
                q.clear();
                break;
            }

            if (curr[3] < K) {
                for (int d = 0; d < drr.length; d++) {
                    int nr = curr[0] + drr[d];
                    int nc = curr[1] + dcc[d];
                    int cnt = curr[3] + 1;

                    if (nr < 0 || nc < 0 || nr >= H || nc >= W || visited[nr][nc][cnt] || a[nr][nc] == 1)
                        continue;

                    visited[nr][nc][cnt] = true;
                    q.add(new int[]{nr, nc, curr[2] + 1, cnt});
                }
            }
            for (int d = 0; d < dr.length; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= H || nc >= W || visited[nr][nc][curr[3]] || a[nr][nc] == 1)
                    continue;

                visited[nr][nc][curr[3]] = true;
                q.add(new int[]{nr, nc, curr[2] + 1, curr[3]});
            }
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        W = Integer.parseInt(stk.nextToken());
        H = Integer.parseInt(stk.nextToken());

        a = new int[H][W];

        for (int i = 0; i < H; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
    }
}

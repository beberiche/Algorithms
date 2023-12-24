package Q14923_미로_탈출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    int N, M, s[], e[], a[][], ans = -1;
    int dr[] = {-1, 0, 1, 0};
    int dc[] = {0, -1, 0, 1};
    boolean visited[][][];

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
        q.add(new int[]{s[0], s[1], 0, 0});
        visited = new boolean[N + 1][M + 1][2];
        visited[s[0]][s[1]][0] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == e[0] && curr[1] == e[1]) {
                ans = curr[2];
                q.clear();
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 1 || nc < 1 || nr > N || nc > M || visited[nr][nc][curr[3]])
                    continue;

                if (a[nr][nc] == 0) {
                    visited[nr][nc][curr[3]] = true;
                    q.add(new int[]{nr, nc, curr[2] + 1, curr[3]});
                } else {
                    if (curr[3] == 0) {
                        visited[nr][nc][1] = true;
                        q.add(new int[]{nr, nc, curr[2] + 1, 1});
                    }
                }
            }
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        s = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
        stk = new StringTokenizer(br.readLine());
        e = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};

        a = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
    }
}

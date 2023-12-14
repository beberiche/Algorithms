package Q16973_직사각형_탈출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    int N, M, a[][], size[], start[], goal[];
    int dr[] = {-1, 0, 1, 0};
    int dc[] = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
    }

    private void solve() {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{start[0], start[1], 0});

        boolean[][] visited = new boolean[N + 1][M + 1];
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == goal[0] && curr[1] == goal[1]) {
                System.out.println(curr[2]);
                q.clear();
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr <= 0 || nc <= 0 || nr > N || nc > M || visited[nr][nc]) {
                    continue;
                }

                int ar = curr[0] + dr[d] + size[0] - 1;
                int ac = curr[1] + dc[d] + size[1] - 1;

                if (ar <= 0 || ac <= 0 || ar > N || ac > M) continue;

                int cnt = a[ar][ac] - a[nr - 1][ac] - a[ar][nc - 1] + a[nr - 1][nc - 1];

                if (cnt > 0) continue;


                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, curr[2] + 1});
            }
        }
        System.out.println(-1);
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = stoi(stk.nextToken());
        M = stoi(stk.nextToken());

        a = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + Integer.parseInt(stk.nextToken());
            }
        }

        stk = new StringTokenizer(br.readLine());
        size = new int[]{stoi(stk.nextToken()), stoi(stk.nextToken())};
        start = new int[]{stoi(stk.nextToken()), stoi(stk.nextToken())};
        goal = new int[]{stoi(stk.nextToken()), stoi(stk.nextToken())};
    }

    private int stoi(String str) {
        return Integer.parseInt(str);
    }
}

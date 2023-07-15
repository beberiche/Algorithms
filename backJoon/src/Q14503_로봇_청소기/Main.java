package Q14503_로봇_청소기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, -1, 0, 1};
    static int N, M, r, c, d, a[][], ans = 1;
    static boolean off;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        a = new int[N][M];
        stk = new StringTokenizer(br.readLine());
        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
    }

    private static void solve(int r, int c, int d, int step) {
        if (off) return;
        for (int i = 0; i < 4; i++) {
            int nd = (d + i + 1) % 4;
            int nr = r + dr[nd];
            int nc = c + dc[nd];
            if (a[nr][nc] == 1 || a[nr][nc] >= 100) continue;
            a[nr][nc] = 100 + step + 1;
            solve(nr, nc, nd, step + 1);
            if (off) return;
        }

        int bd = (d + 2) % 4;
        int nr = r + dr[bd];
        int nc = c + dc[bd];
        if (a[nr][nc] == 1) {
            ans = step;
            off = true;
            return;
        }
        solve(nr, nc, d, step);
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        a[r][c] = 101;
        d = d == 1 ? 3 : d == 3 ? 1 : d;
        solve(r, c, d, 1);
        output();
    }
}

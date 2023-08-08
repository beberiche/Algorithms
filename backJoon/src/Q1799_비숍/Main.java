package Q1799_비숍;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// color
// - 1 : black
// - 0 : white
public class Main {
    static int N, map[][], colors[][], visited[][], ans;
    static int[] dr = {-1, -1};
    static int[] dc = {-1, 1};

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        colors = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) colors[i][j] = 1;
            }
        }
    }

    private static int dfs(int idx, int color) {
        int cnt = 0;
        for (int i = idx; i < N * N; i++) {
            int r = i / N;
            int c = i % N;

            if (colors[r][c] != color || map[r][c] == 0) continue;

            boolean check = true;
            for (int d = 0; d < 2; d++) {
                int nr = r;
                int nc = c;
                while (true) {
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) break;
                    if (visited[nr][nc] > 0) {
                        check = false;
                        break;
                    }
                    nr += dr[d];
                    nc += dc[d];
                }
            }

            if (check) {
                visited[r][c] = 1;
                cnt = Math.max(dfs(i + 1, color)+1, cnt);
                visited[r][c] = 0;
            }
        }
        return cnt;
    }

    private static void solve() {
        visited = new int[N][N];
        ans += dfs(0, 1);
        ans += dfs(0, 0);
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

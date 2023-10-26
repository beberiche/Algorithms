package Q14466_소가_길을_건너간_이유_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, R, map[][], bridges[][], cows[][], ans;
    ;
    static boolean visited[][];
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, -1, 0, 1};
    static Queue<int[]> q = new LinkedList<>();

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());

        bridges = new int[R][4];

        for (int i = 0; i < R; i++) {
            stk = new StringTokenizer(br.readLine());
            bridges[i][0] = Integer.parseInt(stk.nextToken()) - 1;
            bridges[i][1] = Integer.parseInt(stk.nextToken()) - 1;
            bridges[i][2] = Integer.parseInt(stk.nextToken()) - 1;
            bridges[i][3] = Integer.parseInt(stk.nextToken()) - 1;
        }

        map = new int[N][N];
        cows = new int[K + 1][3];
        int idx = 1;
        for (int i = 0; i < K; i++) {
            stk = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(stk.nextToken()) - 1;
            int c = Integer.parseInt(stk.nextToken()) - 1;
            cows[idx] = new int[]{r, c, idx++};
        }
    }

    private static boolean bridgeCheck(int r1, int c1, int r2, int c2) {
        for (int i = 0; i < R; i++) {
            if (r1 == bridges[i][0] && c1 == bridges[i][1] && r2 == bridges[i][2] && c2 == bridges[i][3]) {
                return true;
            }
            if (r2 == bridges[i][0] && c2 == bridges[i][1] && r1 == bridges[i][2] && c1 == bridges[i][3]) {
                return true;
            }
        }
        return false;
    }

    private static void bfs(int r, int c, int num) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited = new boolean[N][N];
        visited[r][c] = true;
        map[r][c] = num;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue;

                if (bridgeCheck(curr[0], curr[1], nr, nc)) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
                map[nr][nc] = num;
            }
        }
    }

    private static void solve() {
        for (int i = 1; i <= K; i++) {
            if (map[cows[i][0]][cows[i][1]] == 0) bfs(cows[i][0], cows[i][1], cows[i][2]);
        }
    }

    private static void output() {
        for (int i = 1; i <= K - 1; i++) {
            for (int j = i + 1; j <= K; j++) {
                if (map[cows[i][0]][cows[i][1]] != map[cows[j][0]][cows[j][1]]) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

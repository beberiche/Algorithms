package Q1584_게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BFS
// 위협 영역, 갈 수는 있으나 -1씩 감소 (0,0), (500,500) 제외
// 죽음 영역, 아예 못감 (0,0) 제외
// 그밖의 영역, 그냥 이동
public class Main {
    static class Node {
        boolean death;
        boolean threat;

    }

    static Node map[][];
    static boolean visited[][];
    static int R, C, N, M, ans;
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, -1, 0, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void go(int cnt, boolean isDeath) throws Exception {
        while (--cnt >= 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            if (x1 > x2) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
            }

            if (y1 > y2) {
                int tmp = y1;
                y1 = y2;
                y2 = tmp;
            }

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if (!isDeath) map[x][y].threat = true;
                    else map[x][y].death = true;
                }
            }
        }
    }

    private static void input() throws Exception {
        R = 501;
        C = 501;
        map = new Node[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = new Node();
            }
        }

        N = Integer.parseInt(br.readLine());
        go(N, false);
        M = Integer.parseInt(br.readLine());
        go(M, true);
    }

    private static void solve() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[2] - n2[2]);
        visited = new boolean[R][C];
        // r,c,hp
        pq.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        ans = -1;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] == R - 1 && curr[1] == C - 1) {
                ans = curr[2];
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc] || map[nr][nc].death) continue;

                visited[nr][nc] = true;
                pq.add(new int[]{nr, nc, map[nr][nc].threat ? curr[2] + 1 : curr[2]});
            }
        }
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

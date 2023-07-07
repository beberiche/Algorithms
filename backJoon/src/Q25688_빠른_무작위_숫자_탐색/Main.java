package Q25688_빠른_무작위_숫자_탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
// 갔던 길 다시 갈 수 있음 -> 3차원 방문처리
// 비트마스킹을 통해, 111111에 가장 먼저 도달하는 길이 값을 리턴
public class Main {
    static int a[][], N = 5, start[], visited[][][], ans = -1;
    static int dr[] = new int[]{-1, 0, 1, 0};
    static int dc[] = new int[]{0, -1, 0, 1};

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = new int[N][N];
        StringTokenizer stk;
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        stk = new StringTokenizer(br.readLine(), " ");
        start = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};

    }

    private static void solve() {
        // r,c,dist,bitmask
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0, 1});
        int goal = (1 << 7) - 1;
        visited = new int[N][N][goal + 1];
        visited[start[0]][start[1]][1] = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[3] == goal) {
                ans = curr[2];
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (a[nr][nc] < 0) continue;
                if (visited[nr][nc][curr[3]] > 0) continue;
                if (a[nr][nc] > 0 && (curr[3] & (1 << a[nr][nc])) == 0) {
                    visited[nr][nc][curr[3] | (1 << a[nr][nc])] = 1;
                    q.add(new int[]{nr, nc, curr[2] + 1, curr[3] | (1 << a[nr][nc])});
                } else {
                    visited[nr][nc][curr[3]] = 1;
                    q.add(new int[]{nr, nc, curr[2] + 1, curr[3]});
                }
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

package Q2146_다리_만들기;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 대륙 만들기, 단 대륙별로 번호는 다르게
// 대륙 외곽, 바다와 인접한 지역 넣어놓기
// 그 지역들을 기반으로, 가장 빨리 다른 지역으로 접근하는 곳 찾기.
public class Main {
    static int N, arr[][], ans = 987654321;
    //    static List<List<int[]>> list;
    static int dr[] = new int[]{-1, 0, 1, 0};
    static int dc[] = new int[]{0, -1, 0, 1};
    static int visited[][];
    static Queue<int[]> q, q2 = new LinkedList<>();

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
    }

    private static void bfs1(int idx, int r, int c) {
        q = new LinkedList<>();

        q.add(new int[]{r, c});

        arr[r][c] = idx;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            boolean check = false;
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || arr[nr][nc] == idx) continue;

                if (arr[nr][nc] == 0 && !check) {
                    check = true;
                    q2.add(new int[]{curr[0], curr[1], idx, 10000});
                    arr[curr[0]][curr[1]] = 10000;
                    visited[curr[0]][curr[1]] = idx;
                }
                if (arr[nr][nc] == 1) {
                    arr[nr][nc] = idx;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    private static void bfs2() {

        while (!q2.isEmpty()) {
            int[] curr = q2.poll();

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || arr[nr][nc] == curr[2]) continue;

                if (arr[nr][nc] == 0 && visited[nr][nc] == 0) {
                    visited[nr][nc] = curr[2];
                    q2.add(new int[]{nr, nc, curr[2], curr[3] + 1});
                    arr[nr][nc] = curr[3] + 1;
                } else if (arr[nr][nc] >= 10000 && arr[curr[0]][curr[1]] >= 10000 && visited[nr][nc] > 0 && visited[curr[0]][curr[1]]>0 &&visited[nr][nc] != visited[curr[0]][curr[1]]) {
                    ans = Math.min(ans, arr[curr[0]][curr[1]] + arr[nr][nc] - 20000);
                }
            }
        }
    }

    private static void solve() {
        visited = new int[N][N];
        int idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) bfs1(++idx, i, j);
            }
        }

        bfs2();
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

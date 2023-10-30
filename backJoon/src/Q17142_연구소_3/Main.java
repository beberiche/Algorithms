package Q17142_연구소_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 콤비네이션을 통한, 활성 바이러스 생성.
// BFS 진행, 모든 공간(0,2의 공간 갯수 - M)에 전염될 수 있어야 함.
// 진행 중 현재 최소값과 동일해지면 break.
public class Main {
    static int N, M, room, arr[][], arr2[][], ans;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static List<int[]> virus, active;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new int[N][N];
        virus = new ArrayList<>();
        int num;
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                num = Integer.parseInt(stk.nextToken());
                arr[i][j] = num;
                if (arr[i][j] != 1) {
                    if (arr[i][j] == 2) virus.add(new int[]{i, j});
                    else room++;
                }
            }
        }
        if (room == 0) {
            System.out.println(0);
            System.exit(0);
        }
        active = new ArrayList<>();
        ans = 300;
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
//        arr2 = new int[N][N];
        // arr 0 : 빈칸, 1 : 벽, 2: 바이러스

        for (int[] v : active) {
            q.add(new int[]{v[0], v[1], 0});
            visited[v[0]][v[1]] = true;
        }

        int cnt = room;
        int ret = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || arr[nr][nc] == 1) continue;

                visited[nr][nc] = true;
                if (arr[nr][nc] == 0) {
                    ret = Math.max(curr[2] + 1, ret);
                    cnt--;
                }
                q.add(new int[]{nr, nc, curr[2] + 1});
            }
        }

        if (cnt == 0) ans = Math.min(ans, ret);
    }

    private static void go(int idx) {
        if (active.size() >= M) {
            bfs();
            return;
        }

        for (int i = idx; i < virus.size(); i++) {
            active.add(virus.get(i));
            go(i + 1);
            active.remove(active.size() - 1);
        }
    }

    private static void output() {
        System.out.println(ans == 300 ? -1 : ans);
    }

    private static void solve() {
        go(0);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

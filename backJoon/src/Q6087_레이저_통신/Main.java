package Q6087_레이저_통신;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, visited[][][], pos[], ans;
    static char arr[][];
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, -1, 0, 1};
    static PriorityQueue<int[]> pq = new PriorityQueue<>((int[] n1, int[] n2) -> n1[3] - n2[3]);

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());

        arr = new char[N][M];
        boolean check = false;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'C' && !check) {
                    pos = new int[]{i, j};
                    check = true;
                }
            }
        }
    }


    private static void solve() {
        visited = new int[N][M][4];
        visited[pos[0]][pos[1]][0]++;
        visited[pos[0]][pos[1]][1]++;
        visited[pos[0]][pos[1]][2]++;
        visited[pos[0]][pos[1]][3]++;
        for (int d = 0; d < 4; d++) {
            int nr = pos[0] + dr[d];
            int nc = pos[1] + dc[d];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if (arr[nr][nc] == '*' || visited[nr][nc][d] > 0) continue;
            if (arr[nr][nc] == 'C') {
                ans = 0;
                return;
            }

            pq.add(new int[]{nr, nc, d, 0});
        }

        while (!pq.isEmpty()) {
            // r,c,d,미러 갯수
            int[] curr = pq.poll();
            visited[curr[0]][curr[1]][curr[2]]++;

            if (arr[curr[0]][curr[1]] == 'C') {
                ans = curr[3];
                break;
            }

            int nr = curr[0] + dr[curr[2]];
            int nc = curr[1] + dc[curr[2]];
            if (nr >= 0 && nc >= 0 && nr < N && nc < M && visited[nr][nc][curr[2]] == 0 && arr[nr][nc] != '*') {
                pq.add(new int[]{nr, nc, curr[2], curr[3]});
            }

            nr = curr[0] + dr[(curr[2] + 3) % 4];
            nc = curr[1] + dc[(curr[2] + 3) % 4];
            if (nr >= 0 && nc >= 0 && nr < N && nc < M && visited[nr][nc][(curr[2] + 3) % 4] == 0 && arr[nr][nc] != '*') {
                pq.add(new int[]{nr, nc, (curr[2] + 3) % 4, curr[3] + 1});
            }

            nr = curr[0] + dr[(curr[2] + 1) % 4];
            nc = curr[1] + dc[(curr[2] + 1) % 4];
            if (nr >= 0 && nc >= 0 && nr < N && nc < M && visited[nr][nc][(curr[2] + 1) % 4] == 0 && arr[nr][nc] != '*') {
                pq.add(new int[]{nr, nc, (curr[2] + 1) % 4, curr[3] + 1});
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

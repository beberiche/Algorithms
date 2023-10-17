package Q16197_두_동전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 두 동전의 포지션을 하나의 Node에 담기
// 겹치는 경우, 1개만 나갈 수 없으니 continue;
// 방문처리는 4차원으로
// 하나의 동전이 밖으로 나간 경우에 종료
public class Main {
    static int N, M, ans = -1;
    static int node[][];
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, -1, 0, 1};
    static char map[][];
    static boolean visited[][][][];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        map = new char[N][M];

        node = new int[2][2];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'o') {
                    node[idx][0] = i;
                    node[idx++][1] = j;
                }
            }
        }
    }


    private static void solve() {
        Queue<int[]> q = new LinkedList<>();

        visited = new boolean[N][M][N][M];
        q.add(new int[]{node[0][0], node[0][1], node[1][0], node[1][1], 0});
        visited[node[0][0]][node[0][1]][node[1][0]][node[1][1]] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[4] >= 10) break;

            for (int d = 0; d < 4; d++) {
                int nr1 = curr[0] + dr[d];
                int nc1 = curr[1] + dc[d];
                int nr2 = curr[2] + dr[d];
                int nc2 = curr[3] + dc[d];

                int cnt = 0;
                if (nr1 < 0 || nc1 < 0 || nr1 >= N || nc1 >= M) cnt++;
                if (nr2 < 0 || nc2 < 0 || nr2 >= N || nc2 >= M) cnt++;

                if (cnt == 1) {
                    ans = curr[4] + 1;
                    q.clear();
                    return;
                }

                if (cnt == 2 || (map[nr1][nc1] == '#' && map[nr2][nc2] == '#')) continue;

                if (map[nr1][nc1] != '#' && map[nr2][nc2] != '#') {
                    if(visited[nr1][nc1][nr2][nc2]) continue;
                    visited[nr1][nc1][nr2][nc2] = true;
                    q.add(new int[]{nr1, nc1, nr2, nc2, curr[4] + 1});
                } else if (map[nr1][nc1] == '#') {
                    if(visited[curr[0]][curr[1]][nr2][nc2]) continue;
                    visited[curr[0]][curr[1]][nr2][nc2] = true;
                    q.add(new int[]{curr[0], curr[1], nr2, nc2, curr[4] + 1});
                } else if (map[nr2][nc2] == '#') {
                    if(visited[nr1][nc1][curr[2]][curr[3]]) continue;
                    visited[nr1][nc1][curr[2]][curr[3]] = true;
                    q.add(new int[]{nr1, nc1, curr[2], curr[3], curr[4] + 1});
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

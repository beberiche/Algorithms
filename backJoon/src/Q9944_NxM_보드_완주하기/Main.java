package Q9944_NxM_보드_완주하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int dr[] = {-1, 0, 1, 0}, dc[] = {0, -1, 0, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static int R, C, cnt, currAns;
    static final int RESULT_MAX = 987654321;
    static char map[][];
    static boolean visited[][];

    private static void input() throws IOException {
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        cnt = 0;
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.') cnt++;
            }
        }
        currAns = RESULT_MAX;
    }

    private static void DFS(int r, int c, int dist, int result) {
        if (currAns < result) return;
        if (dist == 0) {
            currAns = result;
            return;
        }
        for (int d = 0; d < 4; d++) {
            int currDist = 0;
            int nr = r + dr[d];
            int nc = c + dc[d];
            while (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.' && !visited[nr][nc]) {
                visited[nr][nc] = true;
                currDist++;
                nr += dr[d];
                nc += dc[d];
            }
            if(currDist == 0) continue;
            nr -= dr[d];
            nc -= dc[d];
            DFS(nr, nc, dist - currDist, result + 1);
            while(--currDist >= 0) {
                visited[nr][nc] = false;
                nr -= dr[d];
                nc -= dc[d];
            }
        }
    }

    // 해당 . 을 시작으로 전체를 모두 탐색하는 DFS를 실행
    private static void solve() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == '.') {
                    int dist = cnt;
                    visited[i][j] = true;
                    DFS(i, j, dist-1, 0);
                    visited[i][j] = false;
                }
            }
        }
    }

    private static void output(int T) {
        if(cnt == 1) {
            System.out.printf("Case %d: %d\n", T, 0);
            return;
        }
        System.out.printf("Case %d: %d\n", T, currAns == RESULT_MAX ? -1 : currAns);
    }

    public static void main(String[] args) throws IOException {
        int T = 1;
        while (true) {
            try {
                stk = new StringTokenizer(br.readLine());
                input();
                solve();
                output(T++);
            } catch (Exception e) {
                return;
            }
        }
    }
}

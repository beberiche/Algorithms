package Q21772_가희의_고구마_먹방;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int[] pos;
    static char[][] map;
    static final int[] DR = new int[]{-1, 0, 1, 0};
    static final int[] DC = new int[]{0, -1, 0, 1};

    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp[j];
                if (map[i][j] == 'G') pos = new int[]{i, j};
            }
        }

        DFS(pos[0], pos[1], 0, 0);
        System.out.println(ans);
    }

    private static void DFS(int r, int c, int dist, int eat) {
        if (dist >= T) {
            ans = Math.max(eat, ans);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + DR[d];
            int nc = c + DC[d];

            if (!check(nr, nc)) continue;
            if (map[nr][nc] == '#') continue;
            if (map[nr][nc] == 'S') {
                map[nr][nc] = '.';
                DFS(nr, nc, dist + 1, eat + 1);
                map[nr][nc] = 'S';
            } else {
                DFS(nr, nc, dist + 1, eat);
            }
        }
    }


    private static boolean check(int r, int c) {
        if (r < 0 || r >= R || c < 0 || c >= C) return false;
        return true;
    }
}

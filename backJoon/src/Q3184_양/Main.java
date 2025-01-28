package Q3184_양;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int R, C, V, O, dr[], dc[];
    private static char a[][];
    private static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        a = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                a[i][j] = str.charAt(j);
            }
        }

        dr = new int[]{-1, 0, 1, 0};
        dc = new int[]{0, -1, 0, 1};
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && a[i][j] != '#') {
                    int[] ret = go(i, j);
                    V += ret[0];
                    O += ret[1];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(O).append(" ").append(V);

        System.out.print(sb);
    }

    private static int[] go(int i, int j) {
        int v = 0;
        int o = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (a[curr[0]][curr[1]] == 'v') {
                v++;
            } else if (a[curr[0]][curr[1]] == 'o') {
                o++;
            }

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C || a[nr][nc] == '#' || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }

        if (v < o) {
            v = 0;
        } else {
            o = 0;
        }

        return new int[]{v, o};
    }
}

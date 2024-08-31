package Q6146_신아를_만나서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(stk.nextToken());
        int Y = Integer.parseInt(stk.nextToken());
        int N = Integer.parseInt(stk.nextToken());

        // -500 ~ 500 => 0 ~ 1000

        int[][] a = new int[1001][1001];

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken()) + 500;
            int n2 = Integer.parseInt(stk.nextToken()) + 500;

            a[n1][n2] = 1;
        }

        boolean[][] visited = new boolean[1001][1001];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{500, 500, 0});
        visited[500][500] = true;
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] - 500 == X && curr[1] - 500 == Y) {
                System.out.println(curr[2]);
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr > 1000 || nc > 1000 || visited[nr][nc] || a[nr][nc] == 1) {
                    continue;
                }

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, curr[2] + 1});
            }
        }
    }
}

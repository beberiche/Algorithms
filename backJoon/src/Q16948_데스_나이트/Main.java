package Q16948_데스_나이트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] a = new int[N][N]; // 체스판

        int[] dr = {-2, -2, 0, 0, 2, 2};
        int[] dc = {-1, 1, -2, 2, -1, 1};

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] start = {Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
        int[] end = {Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};

        Queue<int[]> q = new LinkedList<>();
        int ans = -1;
        q.add(new int[]{start[0], start[1], 0});
        boolean[][] visited = new boolean[N][N];
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == end[0] && curr[1] == end[1]) {
                ans = curr[2];
                q.clear();
                break;
            }

            for (int d = 0; d < dr.length; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, curr[2] + 1});
            }
        }

        System.out.println(ans);
    }
}

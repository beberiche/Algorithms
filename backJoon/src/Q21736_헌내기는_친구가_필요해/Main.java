package Q21736_헌내기는_친구가_필요해;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, visited[][], dr[] = new int[]{-1, 0, 1, 0}, dc[] = new int[]{0, -1, 0, 1};
    static char a[][];
    static Queue<int[]> q;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        a = new char[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            char ch[] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                a[i][j] = ch[j];
                if (a[i][j] == 'X') {
                    visited[i][j]++;
                } else if (a[i][j] == 'I') {
                    q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j]++;
                }
            }
        }
    }

    private static void solve() {
        int ans = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (a[curr[0]][curr[1]] == 'P') ans++;
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] > 0) continue;
                visited[nr][nc]++;
                q.add(new int[]{nr, nc});
            }
        }
        System.out.println((ans == 0 ? "TT" : ans));
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }
}

package Q16954_움직이는_미로_탈출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 8;
        char arr[][] = new char[N][N];

        q.add(new int[]{-1, N - 1, 0, 0});

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (arr[i][j] == '#') q.add(new int[]{0, i, j, 0});
            }

        }

        int dr[] = {-1, 0, 1, 0, -1, -1, 1, 1, 0};
        int dc[] = {0, -1, 0, 1, -1, 1, -1, 1, 0};


        boolean visited[][] = new boolean[N][N];
        visited[N - 1][0] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            // 벽
            if (curr[0] == 0) {
                int nr = curr[1] + 1;
                arr[curr[1]][curr[2]] = '.';
                if (nr < N) {
                    arr[nr][curr[2]] = '#';
                    q.add(new int[]{0, nr, curr[2], curr[3] + 1});
                }
            } else {
                visited[curr[1]][curr[2]] = false;
                if (arr[curr[1]][curr[2]] == '#') continue;

                if (curr[1] == 0 && curr[2] == N - 1) {
                    q.clear();
                    ans = 1;
                    break;
                }

                for (int d = 0; d < dr.length; d++) {
                    int nr = curr[1] + dr[d];
                    int nc = curr[2] + dc[d];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || arr[nr][nc] == '#')
                        continue;

                    visited[nr][nc] = true;
                    q.add(new int[]{-1, nr, nc, curr[3] + 1});
                }
            }

        }
        System.out.println(ans);
    }
}

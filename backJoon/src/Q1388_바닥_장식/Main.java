package Q1388_바닥_장식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static char[][] a;
    private static boolean[][] visited;
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        a = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                go(i, j, a[i][j]);
                cnt++;
            }
        }
        System.out.print(cnt);
    }

    private static void go(int r, int c, char ch) {
        boolean isOdd = ch == '-'; // '-' 인 경우, 벡터를 홀수 인덱스만 사용. , 반대는 짝수 인덱스만 사용.
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int d = 0; d < 4; d++) {
                if (isOdd && d % 2 == 0) continue; // 홀수 인덱스만 사용
                if (!isOdd && d % 2 == 1) continue; // 짝수 인덱스만 사용

                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if (nr < 0 || nr >= a.length || nc < 0 || nc >= a[0].length) continue;
                if (visited[nr][nc] || a[nr][nc] != ch) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}

package Q16929_Two_Dots;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited, isCheck;
    static final int[] DR = {-1, 0, 1, 0};
    static final int[] DC = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            char[] charArr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = charArr[j];
            }
        }

        // 현재 싸이클의 시작점을 알리는 boolean[][]
        isCheck = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited = new boolean[N][M];
                isCheck[i][j] = true;
                DFS(i, j, map[i][j], 1);
                isCheck[i][j] = false;
            }
        }
        System.out.println("No");
    }

    private static void DFS(int r, int c, char comp, int cnt) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + DR[d];
            int nc = c + DC[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if (map[nr][nc] != comp) continue;
            // 사이클 조건
            // 최소 4개의 노드로 이루어짐
            // 처음과 끝이 모두 같은 좌표여야 함
            if (visited[nr][nc] && isCheck[nr][nc] && cnt >= 4) {
                System.out.println("Yes");
                System.exit(0);
            }
            if (visited[nr][nc]) continue;

            DFS(nr, nc, comp, cnt + 1);
        }
    }
}

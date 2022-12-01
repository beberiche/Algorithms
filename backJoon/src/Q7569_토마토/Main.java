package Q7569_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][][] map;
    static boolean[][][] visited;
    static Queue<int[]> q;
    static final int[] DI = new int[]{0, 0, 0, 0, -1, 1};
    static final int[] DJ = new int[]{0, 0, -1, 1, 0, 0};
    static final int[] DK = new int[]{-1, 1, 0, 0, 0, 0};
    static int H, M, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();

        map = new int[H][M][N];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    map[i][j][k] = sc.nextInt();
                }
            }
        }

        visited = new boolean[H][M][N];
        q = new LinkedList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                for (int k = 0; k < map[0][0].length; k++) {
                    if (map[i][j][k] == 1) {
                        visited[i][j][k] = true;
                        q.add(new int[]{i, j, k});
                    }
                }
            }
        }

        BFS();
        System.out.println(check());
    }

    public static void BFS() {
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currI = curr[0];
            int currJ = curr[1];
            int currK = curr[2];
            for (int d = 0; d < 6; d++) {
                int ni = currI + DI[d];
                int nj = currJ + DJ[d];
                int nk = currK + DK[d];

                if (ni < 0 || nj < 0 || nk < 0 || ni >= H || nj >= M || nk >= N) continue;

                if (visited[ni][nj][nk]) continue;

                if (map[ni][nj][nk] != 0) continue;

                visited[ni][nj][nk] = true;
                map[ni][nj][nk] = map[currI][currJ][currK] + 1;
                q.add(new int[]{ni, nj, nk});
            }
        }
    }

    public static int check() {
        int day = 1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[i][j][k] == 0) {
                        return -1;
                    } else {
                        day = Math.max(day, map[i][j][k]);
                    }
                }
            }
        }
        return day-1;
    }
}

package Q17141_연구소_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, V, ans = Integer.MAX_VALUE;
    static int[][] map;
    static List<int[]> vList = new ArrayList<>();
    static boolean[][] visitedM;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dr = new int[]{-1, 0, 1, 0}, dc = new int[]{0, 1, 0, -1};
    static int[][] sel;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        V = Integer.parseInt(stk.nextToken());


        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if (map[i][j] == 2) vList.add(new int[]{i, j});
            }
        }

        sel = new int[V][2];
        comb(0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void comb(int idx, int d) {
        if (d >= V) {
            int currDist = BFS();
            if(currDist < ans && isInfected()) ans = currDist;
            return;
        }

        for (int i = idx; i < vList.size(); i++) {
            sel[d] = vList.get(i);
            comb(i + 1, d + 1);
        }
    }

    private static int BFS() {
        visitedM = new boolean[N][N];

        for (int[] pos : sel) {
            q.add(new int[]{pos[0], pos[1], 0});
            visitedM[pos[0]][pos[1]] = true;
        }

        int dist = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            dist = curr[2];
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visitedM[nr][nc] || map[nr][nc] == 1) continue;

                visitedM[nr][nc] = true;
                q.add(new int[]{nr, nc, curr[2] + 1});
            }
        }

        return dist;
    }

    private static boolean isInfected() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedM[i][j] && map[i][j] != 1) return false;
            }
        }
        return true;
    }
}

package Q9376_탈옥;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int H, W, ans;
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, -1, 0, 1};
    static char arr[][];
    static PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[2] - n2[2]);
    static List<int[]> list;

    private static void input() throws Exception {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        H = Integer.parseInt(stk.nextToken());
        W = Integer.parseInt(stk.nextToken());
        arr = new char[H + 2][W + 2];
        pq.clear();
        ans = 987654321;
        list = new ArrayList<>();
        for (int i = 1; i <= H; i++) {
            String str = br.readLine();
            for (int j = 1; j <= W; j++) {
                arr[i][j] = str.charAt(j - 1);
                if (arr[i][j] == '$') {
                    list.add(new int[]{i, j});
                    arr[i][j] = '.';
                }
            }
        }
    }

    private static int[][] go(int r, int c) {
        pq.clear();
        pq.add(new int[]{r, c, 0});
        int[][] map = new int[H + 2][W + 2];
        int[][] visited = new int[H + 2][W + 2];
        for (int i = 0; i < H + 2; i++) {
            for (int j = 0; j < W + 2; j++) {
                map[i][j] = -1;
                visited[i][j] = -1;
            }
        }
        visited[r][c]++;

        while (!pq.isEmpty()) {
            // r,c,죄수,문연 개수
            int[] curr = pq.poll();

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= H + 2 || nc >= W + 2) continue;
                if (arr[nr][nc] == '*' || visited[nr][nc] > -1) continue;

                if (arr[nr][nc] == '#') {
                    pq.add(new int[]{nr, nc, curr[2] + 1});
                    visited[nr][nc]++;
                    map[nr][nc] = curr[2] + 1;
                } else {
                    pq.add(new int[]{nr, nc, curr[2]});
                    visited[nr][nc]++;
                    map[nr][nc] = curr[2];
                }
            }
        }

        return map;
    }

    private static void calc(int[][] map1, int[][] map2, int[][] map3) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] == '*' || map1[i][j] == -1 || map2[i][j] == -1 || map3[i][j] == -1) continue;
                int sum = map1[i][j] + map2[i][j] + map3[i][j];
                if (arr[i][j] == '#') sum -= 2;
                ans = Math.min(sum, ans);
            }
        }
    }

    private static void solve() {
        int[][] map1 = go(list.get(0)[0], list.get(0)[1]);
        int[][] map2 = go(list.get(1)[0], list.get(1)[1]);
        int[][] map3 = go(0, 0);
        calc(map1, map2, map3);
        sb.append(ans).append("\n");
    }


    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        while (--T >= 0) {
            input();
            solve();
        }
        output();
    }
}

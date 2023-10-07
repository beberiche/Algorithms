package Q5427_불;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static int W, H, start[], fire[][], player[][];
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, -1, 0, 1};
    static char arr[][];
    static Queue<int[]> q;
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        stk = new StringTokenizer(br.readLine());
        W = Integer.parseInt(stk.nextToken());
        H = Integer.parseInt(stk.nextToken());
        arr = new char[H][W];
        fire = new int[H][W];
        player = new int[H][W];
        q = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == '*') {
                    // r,c,cnt,불
                    q.add(new int[]{i, j, 1, 0});
                    fire[i][j] = 1;
                } else if (arr[i][j] == '@') {
                    // r,c,cnt,상근
                    start = new int[]{i, j, 1, 1};
                    player[i][j] = 1;
                }
            }
        }
    }

    private static void solve() {
        q.add(start);

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[3] == 1 && (curr[0] == 0 || curr[0] == H - 1 || curr[1] == 0 || curr[1] == W - 1)) {
                sb.append(curr[2]).append("\n");
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= H || nc >= W || arr[nr][nc] == '#') continue;

                if (curr[3] == 0 && fire[nr][nc] == 0) {
                    fire[nr][nc] = curr[2] + 1;
                    q.add(new int[]{nr, nc, curr[2] + 1, curr[3]});
                } else if (curr[3] == 1 && fire[nr][nc] == 0 && player[nr][nc] == 0) {
                    player[nr][nc] = curr[2] + 1;
                    q.add(new int[]{nr, nc, curr[2] + 1, curr[3]});
                }
            }
        }

        sb.append("IMPOSSIBLE").append("\n");
    }


    private static void output() throws Exception{
        System.out.print(sb.toString());
        br.close();
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

package Q7562_나이트의_이동;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, arr[][], start[], end[];
    static int[] dr = new int[]{-2, 2, 2, -2, 1, -1, 1, -1};
    static int[] dc = new int[]{-1, -1, 1, 1, 2, 2, -2, -2};
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        start = new int[2];
        end = new int[2];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(stk.nextToken());
        start[1] = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        end[0] = Integer.parseInt(stk.nextToken());
        end[1] = Integer.parseInt(stk.nextToken());
    }

    private static int solve() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0});
        int[][] visited = new int[N][N];
        visited[start[0]][start[1]]++;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == end[0] && curr[1] == end[1]) {
                return curr[2];
            }

            for (int d = 0; d < 8; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] > 0) continue;
                visited[nr][nc]++;
                q.add(new int[]{nr, nc, curr[2] + 1});
            }
        }
        return 0;
    }

    private static void output() {
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            input();
            sb.append(solve()).append("\n");
        }
        output();
    }
}

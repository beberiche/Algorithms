package Q18405_경쟁적_전염;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, arr[][], S, X, Y;
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, -1, 0, 1};
    static List<int[]> list;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        list = new ArrayList<>();
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
                if (arr[i][j] > 0) {
                    list.add(new int[]{arr[i][j], i, j, 0});
                }
            }
        }

        Collections.sort(list, (n1, n2) -> n1[0] - n2[0]);
        stk = new StringTokenizer(br.readLine());
        S = Integer.parseInt(stk.nextToken());
        X = Integer.parseInt(stk.nextToken());
        Y = Integer.parseInt(stk.nextToken());
    }

    private static void solve() {
        Queue<int[]> q = new LinkedList<>();
        q.addAll(list);

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[3] == S || (curr[1] == X - 1 && curr[2] == Y - 1)) {
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = curr[1] + dr[d];
                int nc = curr[2] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || arr[nr][nc] > 0) continue;

                arr[nr][nc] = curr[0];
                q.add(new int[]{curr[0], nr, nc, curr[3] + 1});
            }
        }
    }

    private static void output() {
        System.out.println(arr[X - 1][Y - 1]);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

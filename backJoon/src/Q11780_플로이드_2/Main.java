package Q11780_플로이드_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, map[][], INF = 100004;
    static List<Integer> list[][];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        list = new ArrayList[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                list[i][j] = new ArrayList<>();
                if (i != j) map[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int ed = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());
            map[st][ed] = Math.min(map[st][ed], dist);
        }
    }

    private static void solve() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                        go(i, k, j);
                    }
                }
            }
        }
    }

    private static void go(int i, int k, int j) {
        list[i][j].clear();
        list[i][j].addAll(list[i][k]);
        list[i][j].add(k);
        list[i][j].addAll(list[k][j]);
    }


    private static void output() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] >= INF) sb.append(0);
                else sb.append(map[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j || map[i][j] >= INF) sb.append(0);
                else {
                    sb.append(list[i][j].size() + 2).append(" ");
                    sb.append(i).append(" ");
                    for (int n : list[i][j]) {
                        sb.append(n).append(" ");
                    }
                    sb.append(j);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

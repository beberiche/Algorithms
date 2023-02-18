package Q1719_택배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static int N, M, adj_arr[][], p[][];
    static StringBuilder sb = new StringBuilder();
    static final int MAX = (int) 4e8+4; // Integer.MAX_VALUE 는 더 크다.

    private static void input() throws IOException {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        adj_arr = new int[N + 1][N + 1];
        p = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) adj_arr[i][j] = 0;
                else adj_arr[i][j] = MAX;
                p[i][j] = j;
            }
        }


        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int ed = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());
            adj_arr[st][ed] = adj_arr[ed][st] = adj_arr[st][ed] != 0 ? Math.min(adj_arr[st][ed], dist) : dist;
        }
    }

    private static void floyd_warshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (adj_arr[i][j] > adj_arr[i][k] + adj_arr[k][j]) {
                        adj_arr[i][j] = adj_arr[i][k] + adj_arr[k][j];
                        p[i][j] = p[i][k];
                    }
                }
            }
        }
    }


    private static void output() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) sb.append("- ");
                else sb.append(p[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        floyd_warshall();
        output();
    }
}

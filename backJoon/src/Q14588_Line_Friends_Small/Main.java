package Q14588_Line_Friends_Small;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] a = new int[N + 1][];
        int[][] dist = new int[N + 1][N + 1];
        int INF = 987654321;
        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            a[i] = new int[]{n1, n2};
            Arrays.fill(dist[i], INF);
        }


        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                boolean check = false;
                if (a[i][0] <= a[j][1] && a[j][0] <= a[i][1]) check = true;
                else if (a[j][0] <= a[i][1] && a[i][0] <= a[j][1]) check = true;

                if (check) {
                    dist[i][j] = 1;
                    dist[j][i] = 1;
                }
            }
        }


        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (--Q >= 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            sb.append(dist[n1][n2] == INF ? -1 : dist[n1][n2]).append("\n");
        }
        System.out.print(sb.toString());
    }
}

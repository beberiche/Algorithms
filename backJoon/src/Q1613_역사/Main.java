package Q1613_역사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    int N, arr[][];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer stk;
    StringBuilder sb = new StringBuilder();
    int INF = (int) 1e9;

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }

    private void output() {
        System.out.print(sb.toString());
    }

    private void solve() throws Exception {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int S = Integer.parseInt(br.readLine());

        for (int i = 0; i < S; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());


            sb.append((arr[n1][n2] != INF ? -1 : arr[n2][n1] != INF ? 1 : 0)).append("\n");
        }
    }

    private void input() throws Exception {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(arr[i], INF);
        }

        for (int i = 1; i <= K; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            arr[n1][n2] = 1;
        }
    }
}

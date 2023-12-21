package Q17069_파이프_옮기기_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int N, arr[][];
    long dp[][][];

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }

    private void output() {
        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }

    private void solve() {
        // [][][0] -> r
        // [][][1] -> c
        // [][][2] -> 대각
        dp = new long[N + 1][N + 1][3];
        dp[1][1][1] = 1;
        dp[1][2][1] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                long x = dp[i][j][0];
                long y = dp[i][j][1];
                long z = dp[i][j][2];

                if (i + 1 <= N && arr[i + 1][j] == 0) {
                    dp[i + 1][j][0] += x + z;
                }

                if (j + 1 <= N && arr[i][j + 1] == 0) {
                    dp[i][j + 1][1] += y + z;
                }

                if (i + 1 <= N && j + 1 <= N && arr[i + 1][j] == 0 && arr[i][j + 1] == 0 && arr[i + 1][j + 1] == 0) {
                    dp[i + 1][j + 1][2] += x + y + z;
                }
            }
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(stk.nextToken());
                arr[i][j] = num;
            }
        }
    }
}

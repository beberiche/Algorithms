package Q1890_점프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int N;
    int arr[][];
    long dp[][];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stk;

    private void input() throws Exception {
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
    }

    private void solve() {
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) continue;
                int nr = i + arr[i][j];
                int nc = j + arr[i][j];

                if (nr < N) dp[nr][j] += dp[i][j];
                if (nc < N) dp[i][nc] += dp[i][j];
            }
        }
    }

    private void output() {
        System.out.println(dp[N-1][N-1]);
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }

}

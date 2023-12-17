package Q1890_점프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
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
                dp[i][j] = -1;
            }
        }
        dp[N - 1][N - 1] = 1;
    }

    private long solve(int r, int c) {
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        if (arr[r][c] == 0) {
            return 0;
        }

        int nr = r + arr[r][c];
        int nc = c + arr[r][c];

        dp[r][c] = 0;
        if (nr < N) dp[r][c] += solve(nr, c);
        if (nc < N) dp[r][c] += solve(r, nc);


        return dp[r][c];
    }

    private void output() {
        System.out.println(dp[0][0]);
    }

    public static void main(String[] args) throws Exception {
        Main2 m = new Main2();
        m.input();
        m.solve(0, 0);
        m.output();
    }
}

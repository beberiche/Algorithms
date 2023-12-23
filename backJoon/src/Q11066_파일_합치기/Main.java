package Q11066_파일_합치기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    int N, arr[], sum[], dp[][];
    final int INF = (int) 1e9;
    StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws Exception {
        Main m = new Main();
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            m.input();
            m.solve();
        }
        m.output();
    }

    private void output() {
        System.out.print(sb.toString());
    }

    private void solve() {
        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ret = go(1, N);
        sb.append(ret).append("\n");
    }

    private int go(int s, int e) {
        if (s == e) return 0;

        if (dp[s][e] != -1) return dp[s][e];

        dp[s][e] = INF;


        for (int i = s; i < e; i++) {
            int left = go(s, i);
            int right = go(i + 1, e);
            dp[s][e] = Math.min(dp[s][e], left + right);
        }

        int diff = sum[e] - sum[s - 1];
        dp[s][e] += diff;
        return dp[s][e];
    }

    private void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        sum = new int[N + 1];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }
    }
}

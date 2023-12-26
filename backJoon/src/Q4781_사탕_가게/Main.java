package Q4781_사탕_가게;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N, dp[];
    double M;
    StringBuilder sb = new StringBuilder();
    StringTokenizer stk;

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        while (true) {
            boolean isEnd = m.input();
            if (isEnd) break;
            m.solve();
        }
        m.output();
    }

    private void output() {
        System.out.print(sb.toString());
    }

    private void solve() throws Exception {
        int MM = (int) (M * 100 + 0.5);
        dp = new int[MM + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(stk.nextToken());
            int cost = (int) (Double.parseDouble(stk.nextToken()) * 100 + 0.5);

            for (int j = cost; j <= MM; j++) {
                dp[j] = Math.max(dp[j], dp[j - cost] + val);
            }
        }
        sb.append(dp[MM]).append("\n");
    }

    private boolean input() throws Exception {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Double.parseDouble(stk.nextToken());

        return N == 0 && M == 0.00;
    }
}

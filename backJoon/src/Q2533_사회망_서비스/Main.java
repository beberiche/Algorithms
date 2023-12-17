package Q2533_사회망_서비스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    int N, dp[][];
    boolean visited[];
    List<Integer> list[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }

    private void output() {
    }

    private void solve() {
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private void dfs(int node) {
        visited[node] = true;
        // 0 얼리어답터
        // 1 얼리어답터 아님
        dp[node][0] = 1;
        for (int n : list[node]) {
            if (!visited[n]) {
                dfs(n);
                dp[node][0] += Math.min(dp[n][0], dp[n][1]);
                dp[node][1] += dp[n][0];
            }
        }
    }

    private void input() throws Exception {
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N - 1; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }
    }
}

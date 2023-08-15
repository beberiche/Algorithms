package Q1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static int N, K, cnt[], cost[], W, dp[];
    static List<Integer> list[];
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        cost = new int[N + 1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(stk.nextToken());
        }

        cnt = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= K; i++) {
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int ed = Integer.parseInt(stk.nextToken());
            list[st].add(ed);
            cnt[ed]++;
        }
        W = Integer.parseInt(br.readLine());
    }

    private static void go(int idx) {

    }

    private static void solve() {
        dp = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (cnt[i] == 0) {
                q.add(i);
                dp[i] = cost[i];
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (cnt[W] == 0) break;
            for (Integer n : list[curr]) {
                dp[n] = Math.max(dp[curr] + cost[n], dp[n]);
                cnt[n]--;
                if (cnt[n] == 0) q.add(n);
            }
        }

        sb.append(dp[W]).append("\n");
    }

    private static void output() {
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            input();
            solve();
        }
        output();
    }
}

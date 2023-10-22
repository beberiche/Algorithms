package Q24483_알고리즘_수업_깊이_우선_탐색_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, R, idx;
    static long ans;
    static List<Integer> list[];
    static boolean visited[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }
    }

    private static void dfs(int n, int d) {
        ans += (long) d *  ++idx;
        visited[n] = true;

        for (int next : list[n]) {
            if (!visited[next]) dfs(next, d + 1);
        }
    }

    private static void solve() {
        visited = new boolean[N + 1];
        dfs(R, 0);
    }

    private static void output() {
        System.out.print(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

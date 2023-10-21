package Q24481_알고리즘_수업_깊이_우선_탐색_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, R, arr[];
    static TreeSet<Integer> list[];
    static boolean visited[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());

        list = new TreeSet[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new TreeSet<>();
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }
    }

    private static void dfs(int n, int d) {
        arr[n] = d;
        visited[n] = true;

        for (int next : list[n]) {
            if (!visited[next]) dfs(next, d + 1);
        }
    }

    private static void solve() {
        visited = new boolean[N + 1];
        arr = new int[N + 1];
        Arrays.fill(arr, -1);
        dfs(R, 0);
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

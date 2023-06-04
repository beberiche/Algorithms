package Q11724_연결_요소의_개수;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M,ans,visited[];
    static List<Integer> list[];
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        int a, b;
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
    }

    private static void dfs(int idx) {
        visited[idx]++;
        for (int n : list[idx]) {
            if (visited[n] > 0) continue;
            dfs(n);
        }
    }

    private static void solve() {
        visited = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                dfs(i);
                ans++;
            }
        }
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

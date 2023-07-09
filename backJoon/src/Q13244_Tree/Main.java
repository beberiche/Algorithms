package Q13244_Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer stk;
    static List<Integer> list[];
    static int T, N, M, st, ed, visited[], cnt;

    private static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            st = Integer.parseInt(stk.nextToken());
            ed = Integer.parseInt(stk.nextToken());
            list[st].add(ed);
            list[ed].add(st);
        }
    }

    private static void dfs(int idx) {
        visited[idx] = 1;
        for (int n : list[idx]) if (visited[n] == 0) dfs(n);
    }

    private static void solve() {
        visited = new int[N + 1];
        cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                dfs(i);
                cnt++;
            }
            if (cnt > 1) break;
        }
    }

    private static void output() {
        System.out.println((cnt == 1 && M == N - 1) ? "tree" : "graph");
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            input();
            solve();
            output();
        }
    }
}

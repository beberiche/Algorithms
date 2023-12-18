package Q12784_인하니카_공화국;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stk;

    int N, M, ans;
    List<int[]> tree[];
    boolean visited[];

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        int t = Integer.parseInt(br.readLine());
        while (--t >= 0) {
            m.input();
            m.solve();
            m.output();
        }
    }

    private void output() {
        System.out.println(ans);
    }

    private void solve() {
        visited = new boolean[N + 1];
        ans = dfs(1, 0);
    }

    private int dfs(int node, int dist) {
        visited[node] = true;

        int ret = 0;
        for (int[] next : tree[node]) {
            if (visited[next[0]]) continue;
            ret += dfs(next[0], next[1]);
        }


        if (node == 1) return ret;
        else if (ret == 0) return dist;
        return Math.min(ret, dist);
    }

    private void input() throws Exception {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());

            tree[n1].add(new int[]{n2, dist});
            tree[n2].add(new int[]{n1, dist});
        }
    }
}

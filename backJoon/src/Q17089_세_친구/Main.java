package Q17089_세_친구;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int N, M, arr[], ans, INF = 987654321;
    static List<Integer> list[];
    static boolean visited[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        arr = new int[N + 1];
        int n1, n2;
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(stk.nextToken());
            n2 = Integer.parseInt(stk.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
            arr[n1]++;
            arr[n2]++;
        }

    }

    private static void dfs(int node, int idx, int cnt) {
        if (cnt >= 3) return;

        for (int n : list[node]) {
            if (cnt == 2 && n == idx) {
                int ret = 0;
                for (int i = 1; i <= N; i++) {
                    if (visited[i]) ret += arr[i] - 2;
                }
                ans = Math.min(ret, ans);
                return;
            }

            if (visited[n]) continue;
            visited[n] = true;
            dfs(n, idx, cnt + 1);
            visited[n] = false;
        }
    }

    private static void solve() {
        visited = new boolean[N + 1];
        ans = INF;
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i, 0);
            visited[i] = false;
        }
    }

    private static void output() {
        System.out.println(ans == INF ? -1 : ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
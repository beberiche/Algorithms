package Q12896_스크루지_민호;

// N-1의 그래프, 싸이클이 없는 그래프
// 최적의 위치, 트리의 지름의 중앙에 배치하는 것이 가장 최적화된 위치
// 즉 트리의 반지름을 구하는 문제이다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> list[];
    static int N, ret[];
    static boolean visited[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer stk;
        for (int i = 0; i < N - 1; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }
    }

    private static void dfs(int node, int dist) {
        visited[node] = true;
        if (dist > ret[1]) {
            ret[0] = node;
            ret[1] = dist;
        }

        for (int n : list[node]) {
            if (visited[n]) continue;
            dfs(n, dist + 1);
        }
    }

    private static void solve() {
        visited = new boolean[N + 1];
        ret = new int[2];
        dfs(1, 0);
        Arrays.fill(visited, false);
        dfs(ret[0], 0);
    }

    private static void output() {
        int ans = ret[1] / 2;
        System.out.println(ret[1] % 2 == 1 ? ans + 1 : ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

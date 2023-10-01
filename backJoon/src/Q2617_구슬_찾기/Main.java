package Q2617_구슬_찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 점점 가벼워지는 그래프와 무거워지는 그래프 생성
public class Main {
    static int N, M,ans;
    static List<Integer> list1[], list2[];
    static boolean visited[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        list1 = new ArrayList[N + 1];
        list2 = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            list1[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            list1[n1].add(n2);
            list2[n2].add(n1);
        }
    }

    private static int dfs(List<Integer> list[], int node) {
        visited[node] = true;

        int cnt = 0;
        for (int n : list[node]) {
            if (!visited[n]) {
                cnt++;
                cnt += dfs(list, n);
            }
        }

        return cnt;
    }

    private static void visitedInit() {
        for (int i = 1; i <= N; i++) {
            visited[i] = false;
        }
    }

    private static void solve() {
        int mid = N / 2;
        for (int i = 1; i <= N; i++) {
            visitedInit();
            int ret1 = dfs(list1, i);
            int ret2 = dfs(list2, i);

            if (ret1 > mid || ret2 > mid) {
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

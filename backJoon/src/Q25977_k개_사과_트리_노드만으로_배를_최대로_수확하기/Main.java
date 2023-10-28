package Q25977_k개_사과_트리_노드만으로_배를_최대로_수확하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, K, map[], subset, visited, pear, ans;
    static List<Integer> list[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }

        map = new int[N];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(stk.nextToken());
        }
    }

    private static boolean check1() {

        int apple = 0;
        pear = 0;
        for (int i = 0; i < N; i++) {
            if ((subset & (1 << i)) > 0) {
                if (map[i] == 1) apple++;
                else if (map[i] == 2) pear++;
            }

            if (apple > K) return false;
        }

        return apple <= K;
    }

    private static void dfs(int node) {
        for (int n : list[node]) {
            if ((subset & (1 << n)) == 0 || (visited & (1 << n)) > 0) continue;
            visited |= (1 << n);
            dfs(n);
        }
    }

    private static boolean check2() {
        visited = 1;
        dfs(0);
        return subset == visited;
    }

    private static void solve() {
        int len = 1 << N;
        for (int i = 1; i < len; i++) {
            if ((i & 1) == 0) continue;

            subset = i;

            if (check1() && check2()) {
                ans = Math.max(pear, ans);
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

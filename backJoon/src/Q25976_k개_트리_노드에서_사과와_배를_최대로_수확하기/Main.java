package Q25976_k개_트리_노드에서_사과와_배를_최대로_수확하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, K, arr[], subnet, visited, apple, pear;
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

        arr = new int[N];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

    }

    private static int[] dfs(int node) {
        int a = arr[node] == 1 ? 1 : 0;
        int p = arr[node] == 2 ? 1 : 0;

        for (int n : list[node]) {
            if ((subnet & (1 << n)) > 0 && (visited & (1 << n)) == 0) {
                visited |= (1 << n);
                int[] ret = dfs(n);
                a += ret[0];
                p += ret[1];
            }
        }

        return new int[]{a, p};
    }

    private static boolean check() {
        int node = 0;
        for (int i = 0; i < N; i++) {
            if ((subnet & (1 << i)) > 0) node++;

            if (node > K) return false;
        }

        return node <= K;
    }

    private static void solve() {
        int len = 1 << N;
        for (int i = 0; i < len; i++) {
            if ((i & 1) == 0) continue;

            subnet = i;

            visited = 1;

            if (!check()) continue;


            int[] ret = dfs(0);

            int mul1 = apple * pear;
            int mul2 = ret[0] * ret[1];
            if (subnet != visited || mul1 > mul2) continue;

            if (mul1 < mul2 || (mul1 == mul2 && ret[0] > apple) || (mul1 == mul2 && ret[0] == apple && ret[1] > pear)) {
                apple = ret[0];
                pear = ret[1];
            }
        }
    }

    private static void output() {
        System.out.println(apple + " " + pear);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

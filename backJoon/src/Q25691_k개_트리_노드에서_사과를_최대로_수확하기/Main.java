package Q25691_k개_트리_노드에서_사과를_최대로_수확하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, K, visited, subset, ans, apple[], appleCnt;
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

        int n1, n2;
        for (int i = 0; i < N - 1; i++) {
            stk = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(stk.nextToken());
            n2 = Integer.parseInt(stk.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }

        apple = new int[N];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            apple[i] = Integer.parseInt(stk.nextToken());
        }
    }


    private static boolean check1() {
        appleCnt = 0;
        int nodeCnt = 0;
        for (int j = 0; j < N; j++) {
            if ((subset & (1 << j)) == 0) continue;

            appleCnt += apple[j];
            nodeCnt++;
            if (nodeCnt > K) return false;
        }
        return nodeCnt == K;
    }

    private static boolean check2() {
        visited = 1;
        dfs(0);
        return visited == subset;
    }

    private static void solve() {
        int len = 1 << N;
        boolean check1, check2;
        for (int i = 1; i < len; i++) {
            if ((i & 1) == 0) continue;

            subset = i;

            if (check1() && check2()) {
                ans = Math.max(appleCnt, ans);
            }
        }
    }

    private static void dfs(int curr) {
        for (int n : list[curr]) {
            if ((visited & (1 << n)) > 0 || (subset & (1 << n)) == 0) continue;
            visited |= (1 << n);
            dfs(n);
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

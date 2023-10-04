package Q4803_트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, p[];
    static boolean visited[], cycle[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static StringBuilder sb = new StringBuilder();

    private static final String NO = "No trees.";
    private static final String Tree = "There is one tree.";

    private static void caseAnswer(int t, int num) {
        StringBuilder ret = new StringBuilder("Case " + t + ": ");
        if (num == 0) {
            ret.append(NO);
        } else if (num == 1) {
            ret.append(Tree);
        } else {
            ret.append("A forest of ").append(num + " ").append("trees.");
        }

        ret.append("\n");
        sb.append(ret);
    }

    private static int find(int num) {
        if (p[num] == num) return num;
        return p[num] = find(p[num]);
    }

    private static void union(int x, int y) {
        if (x < y) p[y] = x;
        else p[x] = y;
    }

    private static void solve() throws Exception {
        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());

            int n1 = find(Integer.parseInt(stk.nextToken()));
            int n2 = find(Integer.parseInt(stk.nextToken()));

            if (n1 == n2) cycle[n1] = true;
            else if (cycle[n1] || cycle[n2]) {
                cycle[n1] = true;
                cycle[n2] = true;
            }
            union(n1, n2);
        }
    }

    public static void main(String[] args) throws Exception {
        int T = 0;
        while (true) {
            T++;
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            M = Integer.parseInt(stk.nextToken());

            if (N == 0 && M == 0) break;

            cycle = new boolean[N + 1];

            solve();

            visited = new boolean[N + 1];
            visited[find(1)] = true;
            int cnt = cycle[find(1)] ? 0 : 1;

            for (int i = 1; i <= N; i++) {
                int num = find(i);
                if (!visited[num] && !cycle[num]) {
                    visited[num] = true;
                    cnt++;
                }
            }

            caseAnswer(T, cnt);
        }
        System.out.print(sb.toString());
    }
}

package Q14950_정복자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    int N, M, T, edges[][], p[], ans;

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        T = Integer.parseInt(stk.nextToken());

        edges = new int[M][3];

        p = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

//        edges[0] = new int[]{0, 1, 0};
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            edges[i] = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
        }

        Arrays.sort(edges, (n1, n2) -> n1[2] - n2[2]);
    }

    private int find(int num) {
        if (p[num] == num) return num;
        return p[num] = find(p[num]);
    }

    private void solve() {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            int n1 = find(edges[i][0]);
            int n2 = find(edges[i][1]);

            if (n1 != n2) {
                p[n1 < n2 ? n2 : n1] = n1 < n2 ? n1 : n2;
                ans += edges[i][2] + T * cnt++;
            }
            if (cnt == N) break;
        }
    }

    private void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        Main2 m = new Main2();
        m.input();
        m.solve();
        m.output();
    }
}

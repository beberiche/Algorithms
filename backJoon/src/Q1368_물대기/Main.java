package Q1368_물대기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, p[], ans;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[2] - n2[2]);

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new int[N + 1];
        int w = 0;
        for (int i = 1; i <= N; i++) {
            p[i] = i;
            w = Integer.parseInt(br.readLine());
            pq.add(new int[]{0, i, w});
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                w = Integer.parseInt(stk.nextToken());
                if (i != j) {
                    pq.add(new int[]{i, j, w});
                }
            }
        }
    }

    private static int find(int num) {
        if (p[num] == num) return num;
        return p[num] = find(p[num]);
    }

    private static void union(int n1, int n2) {
        if (n1 < n2) p[n2] = n1;
        else p[n1] = n2;
    }

    private static void solve() {
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int n1 = find(curr[0]);
            int n2 = find(curr[1]);

            if (n1 != n2) {
                union(n1, n2);
                ans += curr[2];
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

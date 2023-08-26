package Q14595_동방_프로젝트_Large;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, p[], cnt;

    static PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> {
        if (n1[0] == n2[0]) return n1[1] - n2[1];
        return n1[0] - n2[0];
    });

    private static int find(int n) {
        if (p[n] == n) return n;
        return p[n] = find(p[n]);
    }

    private static void go(int st, int ed) {
        int x = find(st);
        for (int i = st + 1; i <= ed; i++) {
            int y = find(i);
            if (x != y) {
                p[y] = x;
                cnt++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        p = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }


        for (int i = 0; i < M; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            pq.add(new int[]{n1, n2});
        }

        if (pq.isEmpty()) {
            System.out.println(N);
            System.exit(0);
        }
        int[] curr = pq.poll();
        int st = curr[0];
        int ed = curr[1];

        while (!pq.isEmpty()) {
            curr = pq.poll();

            if (ed < curr[0]) {
                go(st, ed);
                st = curr[0];
                ed = curr[1];
            } else if (ed < curr[1]) {
                ed = curr[1];
            }
        }
        go(st, ed);

        System.out.println(N - cnt);

    }
}

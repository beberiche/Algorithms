package Q1766_문제집;

import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> pq;
    static int N, M, d[];
    static List<Integer> v[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        v = new ArrayList[N + 1];
        d = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            v[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int ed = Integer.parseInt(stk.nextToken());
            v[st].add(ed);
            d[ed]++;
        }
    }

    private static void solve() {
        pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (d[i] == 0) pq.add(i);
        }

        StringBuffer sb = new StringBuffer();
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            sb.append(curr).append(" ");
            for (int n : v[curr]) {
                if (--d[n] <= 0) pq.add(n);
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }
}

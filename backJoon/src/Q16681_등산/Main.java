package Q16681_등산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, D, E, height[];
    static long ans, dist1[], dist2[], INF = Long.MAX_VALUE;
    static List<int[]> list[];
    static PriorityQueue<long[]> pq = new PriorityQueue<>((n1, n2) -> (int) (n1[1] - n2[1]));

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        D = Integer.parseInt(stk.nextToken());
        E = Integer.parseInt(stk.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        height = new int[N + 1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            height[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int ed = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());

            list[st].add(new int[]{ed, dist});
            list[ed].add(new int[]{st, dist});
        }
    }


    private static void dijkstra(int start, long[] dist) {
        pq.add(new long[]{start, 0});
        Arrays.fill(dist, INF);
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            if (curr[1] > dist[(int) curr[0]]) continue;
            for (int[] next : list[(int) curr[0]]) {
                if (height[(int) curr[0]] < height[next[0]] && dist[next[0]] > curr[1] + next[1]) {
                    dist[next[0]] = curr[1] + next[1];
                    pq.add(new long[]{next[0], dist[next[0]]});
                }
            }
        }
    }

    private static void go() {
        ans = -INF;
        for (int i = 2; i < N; i++) {
            if (dist1[i] == INF || dist2[i] == INF) continue;
            long ret = (height[i] * E) - (dist1[i] + dist2[i]) * D;
            ans = Math.max(ret, ans);
        }
    }


    private static void solve() {
        dist1 = new long[N + 1];
        dist2 = new long[N + 1];
        dijkstra(1, dist1);
        dijkstra(N, dist2);
        go();
    }

    private static void output() {
        System.out.println(ans == -INF ? "Impossible" : ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

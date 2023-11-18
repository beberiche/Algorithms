package Q2307_도로검문;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 최단경로가 지나는 간선들 구하기
// 지나온 간선들을 하나씩 막으면서, 최단 경로 구하기 -> 인접 배열로 진행해보자.
// E * log(V) * 4999 => 74985000 (아슬아슬 가능?)
public class Main {
    static int N, M, arr[][], ans, p[];
    static List<int[]> list;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(arr[i], (int) 1e9);
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());

            arr[n1][n2] = dist;
            arr[n2][n1] = dist;
        }
        p = new int[N + 1];
    }


    private static int[] dijstra(boolean get_edges) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        pq.add(new int[]{1, 0});

        if (get_edges) p[1] = 1;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            for (int n = 1; n <= N; n++) {
                if (arr[curr[0]][n] == (int) 1e9 || dist[n] <= dist[curr[0]] + arr[curr[0]][n]) continue;

                dist[n] = dist[curr[0]] + arr[curr[0]][n];
                if (get_edges) {
                    p[n] = curr[0];
                }
                pq.add(new int[]{n, dist[n]});
            }
        }

        return dist;
    }

    private static void go(int num, int[] dist) {
        if (p[num] == num) return;

        int d = arr[p[num]][num];
        arr[p[num]][num] = (int) 1e9;
        arr[num][p[num]] = (int) 1e9;

        int ret[] = dijstra(false);

        if (ret[N] == Integer.MAX_VALUE) {
            ans = -1;
            return;
        }
        ans = Math.max(ret[N] - dist[N], ans);

        arr[p[num]][num] = d;
        arr[num][p[num]] = d;
        go(p[num], dist);
    }

    private static void solve() {
        int dist[] = dijstra(true);

        list = new ArrayList<>();
        go(N, dist);
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

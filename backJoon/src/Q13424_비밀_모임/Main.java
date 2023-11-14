package Q13424_비밀_모임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K, frineds[], INF = 987654321, num, dist_sum;
    static List<int[]> list[];
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int n1, n2, dist;
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(stk.nextToken());
            n2 = Integer.parseInt(stk.nextToken());
            dist = Integer.parseInt(stk.nextToken());

            list[n1].add(new int[]{n2, dist});
            list[n2].add(new int[]{n1, dist});
        }

        K = Integer.parseInt(br.readLine());
        frineds = new int[K];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            frineds[i] = Integer.parseInt(stk.nextToken());
        }
    }

    private static int[] dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            for (int[] next : list[curr[0]]) {
                if (dist[next[0]] > dist[curr[0]] + next[1]) {
                    dist[next[0]] = dist[curr[0]] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }

        return dist;
    }

    private static void solve() {
        dist_sum = INF;
        for (int i = 1; i <= N; i++) {
            int[] ret = dijkstra(i);
            int curr_min_dist = 0;
            for (int j = 0; j < K; j++) {
                curr_min_dist += ret[frineds[j]];
            }
            if(dist_sum > curr_min_dist) {
                num = i;
                dist_sum = curr_min_dist;
            }
        }
    }

    private static void output() {
        sb.append(num).append("\n");
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            input();
            solve();
            output();
        }
        System.out.print(sb.toString());
    }
}

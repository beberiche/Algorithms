package Q2211_네트워크_복구;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, p[], INF = 12345;

    static List<int[]> list[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());

            list[n1].add(new int[]{n2, dist});
            list[n2].add(new int[]{n1, dist});
        }
    }

    private static void solve() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        pq.add(new int[]{1, 0});

        p = new int[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            for (int[] next : list[curr[0]]) {
                if (dist[next[0]] > dist[curr[0]] + next[1]) {
                    dist[next[0]] = dist[curr[0]] + next[1];
                    p[next[0]] = curr[0];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
    }



    private static void output() {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (p[i] > 0) {
                cnt++;
                sb.append(p[i]).append(" ").append(i).append("\n");
            }
        }

        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

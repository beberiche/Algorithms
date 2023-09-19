package Q10282_해킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<int[]> list[];
    static int N, D, C, dist[];
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        D = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < D; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());

            list[n2].add(new int[]{n1, dist});
        }
    }

    private static void solve() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        pq.add(new int[] {C, 0});

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[C] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            for (int[] next : list[curr[0]]) {
                if (curr[1] + next[1] < dist[next[0]]) {
                    dist[next[0]] = curr[1] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
    }

    private static void output() {
        int cnt = 0;
        int time = 0;

        for (int t : dist) {
            if (t < Integer.MAX_VALUE) {
                cnt++;
                time = Math.max(t, time);
            }
        }

        sb.append(cnt).append(" ").append(time).append("\n");
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

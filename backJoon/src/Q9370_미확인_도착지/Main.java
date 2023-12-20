package Q9370_미확인_도착지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, m, t, s, g, h, goals[];
    int INF = (int) 1e9;
    List<int[]> list[];
    List<Integer> ret;
    StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        Main m = new Main();
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            m.input();
            m.solve();
        }
        m.output();
    }

    private void output() {
        System.out.print(sb.toString());
    }

    private void solve() {
        int[] sDist = dijstra(s);
        int[] gDist = dijstra(g);
        int[] hDist = dijstra(h);

        ret = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int goal = goals[i];
            int dist1 = sDist[goal];
            int dist2 = Math.min(sDist[g] + gDist[h] + hDist[goal], sDist[h] + hDist[g] + gDist[goal]);

            if (dist1 == dist2) ret.add(goal);
        }

        Collections.sort(ret);
        for (int node : ret) {
            sb.append(node).append(" ");
        }
        sb.append("\n");
    }

    private int[] dijstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        int[] dist = new int[n + 1];

        Arrays.fill(dist, INF);

        pq.add(new int[]{start, 0});
        dist[start] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            for (int[] next : list[curr[0]]) {
                if (dist[next[0]] > next[1] + curr[1]) {
                    dist[next[0]] = next[1] + curr[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }

        return dist;
    }

    private void input() throws Exception {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        s = Integer.parseInt(stk.nextToken());
        g = Integer.parseInt(stk.nextToken());
        h = Integer.parseInt(stk.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int d = Integer.parseInt(stk.nextToken());

            list[a].add(new int[]{b, d});
            list[b].add(new int[]{a, d});
        }

        goals = new int[t];
        for (int i = 0; i < t; i++) {
            goals[i] = Integer.parseInt(br.readLine());
        }
    }

}

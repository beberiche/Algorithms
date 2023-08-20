package Q13905_세부;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, st, ed, visited[], dist[];
    static List<int[]> list[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        st = Integer.parseInt(stk.nextToken());
        ed = Integer.parseInt(stk.nextToken());
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
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n2[1] - n1[1]);
        pq.add(new int[]{st, 0});

        visited = new int[N + 1];
        dist = new int[N + 1];
        dist[st] = 987654321;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (visited[curr[0]] > 0) continue;
            visited[curr[0]]++;
            for (int[] next : list[curr[0]]) {
                dist[next[0]] = Math.max(dist[next[0]], Math.min(dist[curr[0]], next[1]));
                pq.add(new int[]{next[0], dist[next[0]]});
            }
        }
    }

    private static void output() {
        System.out.println(dist[ed]);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

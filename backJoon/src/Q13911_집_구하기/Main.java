package Q13911_집_구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, X, Y, INF = (int) 1e9 + 4, ans = Integer.MAX_VALUE;
    static List<int[]> list[];
    static boolean isNotHome[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        list = new ArrayList[N + 3];
        for (int i = 1; i <= N + 2; i++) {
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

        int cnt;
        stk = new StringTokenizer(br.readLine());
        cnt = Integer.parseInt(stk.nextToken());
        X = Integer.parseInt(stk.nextToken());

        isNotHome = new boolean[N + 1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(stk.nextToken());
            isNotHome[num] = true;
            list[N + 1].add(new int[]{num, 0});
        }

        stk = new StringTokenizer(br.readLine());
        cnt = Integer.parseInt(stk.nextToken());
        Y = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(stk.nextToken());
            isNotHome[num] = true;
            list[N + 2].add(new int[]{num, 0});
        }
    }

    private static int[] dijstra(int start, int lim) {
        int[] dist = new int[N + 3];
        Arrays.fill(dist, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        pq.addAll(list[start]);
        dist[start] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            for (int[] next : list[curr[0]]) {
                if (curr[1] + next[1] <= lim && dist[next[0]] > curr[1] + next[1]) {
                    dist[next[0]] = curr[1] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }

        return dist;
    }


    private static void solve() {
        int[] dist_M = dijstra(N + 1, X);
        int[] dist_S = dijstra(N + 2, Y);

        for (int i = 1; i <= N; i++) {
            if (!isNotHome[i] && dist_M[i] <= X && dist_S[i] <= Y && ans > dist_M[i] + dist_S[i]) {
                ans = dist_M[i] + dist_S[i];
            }
        }
    }

    private static void output() {
        System.out.println(ans >= INF ? -1 : ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

package Q24846_Army_of_Clones;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, X, map[], ans;
    static List<Integer> list[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }

        map = new int[N + 1];

        X = Integer.parseInt(br.readLine());

        stk = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(stk.nextToken());
        }
    }

    private static void solve() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n2[1] - n1[1]);

        pq.add(new int[]{1, X > map[1] ? X : X / 2});
        boolean visited[] = new boolean[N + 1];
        visited[1] = true;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if (curr[0] == N) {
                ans = curr[1];
                break;
            }

            for (int next : list[curr[0]]) {
                if (!visited[next]) {
                    visited[next] = true;
                    pq.add(new int[]{next, curr[1] > map[next] ? curr[1] : curr[1] / 2});
                }
            }
        }
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

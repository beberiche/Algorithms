package Q14950_정복자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int N, M, T, dist[];
    List<int[]> list[];

    long ans;
    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        T = Integer.parseInt(stk.nextToken());

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


    private void solve() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        pq.addAll(list[1]);

        boolean visited[] = new boolean[N + 1];
        visited[1] = true;
        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (!visited[curr[0]]) {
                visited[curr[0]] = true;
                ans += curr[1] + T * cnt++;
                pq.addAll(list[curr[0]]);
            }
        }
    }


    private void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }
}

package Q2056_작업;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int N, degree[], cost[], ans;
    List<Integer> list[];
    PriorityQueue<int[]> q = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);


    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        degree = new int[N + 1];
        cost = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());

            cost[i] = Integer.parseInt(stk.nextToken());
            int cnt = Integer.parseInt(stk.nextToken());
            if (cnt == 0) q.add(new int[]{i,cost[i]});
            degree[i] = cnt;
            for (int j = 0; j < cnt; j++) {
                int num = Integer.parseInt(stk.nextToken());
                list[num].add(i);
            }
        }
    }

    private void solve() {
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            ans = curr[1];
            for (int next : list[curr[0]]) {
                degree[next]--;
                if (degree[next] == 0) {
                    q.add(new int[]{next, curr[1] + cost[next]});
                }
            }
        }

    }

    private void output() {
        System.out.println(ans);
    }
}

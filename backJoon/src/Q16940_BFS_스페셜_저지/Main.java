package Q16940_BFS_스페셜_저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, order[], idx = 1;
    static List<Integer> list[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer stk;
        for (int i = 0; i < N - 1; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }

        order = new int[N + 1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            order[Integer.parseInt(stk.nextToken())] = i;
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i], (n1, n2) -> order[n1] - order[n2]);
        }
    }

    private static void solve() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean visited[] = new boolean[N + 1];
        visited[1] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (order[curr] != idx++) {
                System.out.println(0);
                System.exit(0);
            }
            for (int n : list[curr]) {
                if (visited[n]) continue;
                visited[n] = true;
                q.add(n);
            }
        }
    }

    private static void output() {
        System.out.println(1);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

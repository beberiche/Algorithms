package Q16947_서울_지하철_2호선;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main3 {
    static int N, dist[], cycleStart;
    static boolean visited[], isCycle[];
    static List<Integer> list[];
    static Queue<int[]> q = new LinkedList<>();
    static boolean check = false;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }
    }

    private static boolean cycle(int curr, int prev) {
        visited[curr] = true;
        for (int next : list[curr]) {
            if (visited[next] && next != prev) {
                isCycle[curr] = true;
                q.add(new int[]{curr, 0});
                cycleStart = next;
                return true;
            } else if (!visited[next]) {
                if (cycle(next, curr)) {
                    if (curr == cycleStart) {
                        isCycle[curr] = true;
                        q.add(new int[]{curr, 0});
                        return false;
                    } else {
                        isCycle[curr] = true;
                        q.add(new int[]{curr, 0});
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void bfs() {
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int next : list[curr[0]]) {
                if (!isCycle[next] && !visited[next]) {
                    visited[next] = true;
                    dist[next] = curr[1] + 1;
                    q.add(new int[]{next, dist[next]});
                }
            }
        }
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(dist[i]).append(" ");
        }
        System.out.print(sb.toString());
    }

    private static void solve() {
        visited = new boolean[N + 1];
        isCycle = new boolean[N + 1];
        cycle(1, 0);
        bfs();
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

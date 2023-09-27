package Q1707_이분_그래프;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static int V, E, visited[], st;
    static List<Integer> list[];
    static StringBuilder sb = new StringBuilder();
    static boolean check;

    private static void input() throws Exception {
        stk = new StringTokenizer(br.readLine());
        V = Integer.parseInt(stk.nextToken());
        E = Integer.parseInt(stk.nextToken());

        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }

        check = true;
    }

    private static boolean bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int n : list[curr]) {
                if (visited[n] == 0) {
                    visited[n] = visited[curr] == 1 ? -1 : 1;
                    q.add(n);
                } else if (visited[curr] == visited[n]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void solve() {
        visited = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0 && !bfs(i)) {
                sb.append("NO").append("\n");
                return;
            }
        }
        sb.append("YES").append("\n");
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            input();
            solve();
        }
        output();
    }
}

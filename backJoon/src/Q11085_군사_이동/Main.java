package Q11085_군사_이동;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {
        int st;
        int ed;
        int dist;

        Edge(int st, int ed, int dist) {
            this.st = st;
            this.ed = ed;
            this.dist = dist;
        }


        @Override
        public int compareTo(Edge o) {
            return o.dist - this.dist;
        }
    }

    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int P, W, C, V, p[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        P = Integer.parseInt(stk.nextToken());
        W = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        C = Integer.parseInt(stk.nextToken());
        V = Integer.parseInt(stk.nextToken());

        p = new int[P];
        for (int i = 0; i < P; i++) {
            p[i] = i;
        }

        for (int i = 0; i < W; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());
            pq.add(new Edge(n1, n2, dist));
        }
    }

    private static void solve() {
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            union(curr.st, curr.ed);
            if (find(C) == find(V)) {
                System.out.println(curr.dist);
                return;
            }
        }
    }

    private static int find(int n) {
        if (p[n] == n) return n;
        return p[n] = find(p[n]);
    }

    private static void union(int st, int ed) {
        int x = find(st);
        int y = find(ed);

        if (x < y) {
            p[x] = y;
        } else {
            p[y] = x;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }
}

package Q4006_고속도로_건설_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static int N,M;
    static class Edge {
        int st,ed,cost;
        Edge(int st, int ed, int cost) {
            this.st = st;
            this.ed = ed;
            this.cost = cost;
        }
    }
    static int[] p;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans;
    static PriorityQueue<Edge> pq;


    private static void input() throws Exception{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        p = new int[N+1];
        for(int i=1; i<=N; i++) {
            p[i] = i;
        }

        pq = new PriorityQueue<>((e1,e2)->e1.cost-e2.cost);
        ans = 0;
        for(int i=0; i<M; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int ed = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());
            pq.add(new Edge(st,ed,cost));
        }
    }

    private static void solve() {
        kruskal();
    }

    private static void kruskal() {
        for(int i=1; i<M; i++) {
            Edge curr = pq.poll();
            int e1 = find(curr.st);
            int e2 = find(curr.ed);

            if(e1 == e2) continue;
            union(e1,e2);
            ans += curr.cost;
        }
    }

    private static int find(int n) {
        if(n == p[n]) return n;
        return p[n] = find(p[n]);
    }

    private static void union(int e1, int e2) {
        e1 = find(e1);
        e2 = find(e2);
        if(e1<e2) p[e2] = e1;
        else p[e1] = e2;
    }

    private static void output(int t) {
        System.out.printf("#%d %d\n", t, ans);
    }
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            input();
            solve();
            output(t);
        }
    }
}

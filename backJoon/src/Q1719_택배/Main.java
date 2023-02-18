package Q1719_택배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static int N,M,dist[][],p[][];
    static List<Edge> adjList[];
    static StringBuilder ans = new StringBuilder();

    static class Edge {
        int to, dist;
        Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
    private static void input() throws IOException {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        adjList = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }
        dist = new int[N+1][N+1];
        p = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                p[i][j] = j;
            }
        }
        for(int i=0; i<M; i++) {
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int ed = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());
            adjList[st].add(new Edge(ed,dist));
            adjList[ed].add(new Edge(st,dist));
        }
    }

    private static void solve() {
        for(int i=1; i<=N; i++) {
            dijstra(i);
        }
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) ans.append("- ");
                else ans.append(find(i, j)).append(" ");
            }
            ans.append("\n");
        }
    }

    private static void dijstra(int idx) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2)->e1.dist-e2.dist);
        pq.add(new Edge(idx, 0));
        dist[idx][idx] = 0;
        while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            if(curr.dist > dist[idx][curr.to]) continue;
            for(Edge next : adjList[curr.to]) {
                if(dist[idx][next.to] > dist[idx][curr.to]+next.dist) {
                    dist[idx][next.to] = dist[idx][curr.to]+next.dist;
                    p[idx][next.to] = curr.to;
                    pq.add(new Edge(next.to, dist[idx][next.to]));
                }
            }
        }
    }

    private static void output() {
        System.out.println(ans);
    }

    private static int find(int i, int j) {
        if(i==p[i][j]) return j;
        return find(i, p[i][j]);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }
}

package Q11779_최소비용_구하기_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dist,p;
    static List<Edge> adjList[];
    static int cnt=0;
    static StringBuffer ans = new StringBuffer();

    static int st, ed;

    static class Edge {
        int to, dist;

        Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N + 1];
        p = new int[N+1];
        dist = new int[N + 1];
        Arrays.fill(dist, (int) 1e8 + 1);
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer stk;
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());

            adjList[n1].add(new Edge(n2, dist));
        }

        stk = new StringTokenizer(br.readLine());
        st = Integer.parseInt(stk.nextToken());
        ed = Integer.parseInt(stk.nextToken());
    }

    private static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.dist - e2.dist);
        pq.add(new Edge(st, 0));
        dist[st] = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if(dist[curr.to] < curr.dist) continue;
            for (Edge next : adjList[curr.to]) {
                if (dist[next.to] > dist[curr.to] + next.dist) {
                    dist[next.to] = dist[curr.to] + next.dist;
                    p[next.to] = curr.to;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }
    }

    private static void find(int idx) {
        cnt++;
        if(st==idx) {
            ans.append(idx + " ");
            return;
        } else find(p[idx]);
        ans.append(idx + " ");
    }

    private static void output() {
        System.out.println(dist[ed]);
        System.out.println(cnt);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        dijkstra();
        find(ed);
        output();
    }
}


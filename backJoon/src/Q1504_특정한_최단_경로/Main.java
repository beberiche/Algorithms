package Q1504_특정한_최단_경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        // 진행하는 경로
        int next;
        // 비용
        int cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    static List<Node>[] map;
    static final int INF = (int) 1e9;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        map = new ArrayList[N + 1];

        for(int i=1; i<=N; i++) map[i] = new ArrayList<>();

        while(--E>=0) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[prev].add(new Node(next, cost));
            map[next].add(new Node(prev, cost));
        }

        st = new StringTokenizer(br.readLine());
        int nodeA = Integer.parseInt(st.nextToken());
        int nodeB = Integer.parseInt(st.nextToken());

        // 반드시 두 정점 a,b 를 지나는 최단 경로
        // (시작점 -> a) + (a -> b) + (b -> 끝점) 혹은 (시작점 -> b) + (b -> a) + (a -> 끝점)
        int case1 = dijkstra(1, nodeA) + dijkstra(nodeA, nodeB) + dijkstra(nodeB, N);
        int case2 = dijkstra(1, nodeB) + dijkstra(nodeB, nodeA) + dijkstra(nodeA, N);

        if (case1 < 0 || case2 < 0 || case1 >= INF || case2>= INF) System.out.println(-1);
        else System.out.println(Math.min(case1, case2));
    }

    private static int dijkstra(int st, int ed) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);

        dist[st] = 0;
        pq.add(new Node(st, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (visited[curr.next]) continue;
            visited[curr.next] = true;

            for (Node nNode : map[curr.next]) {
                if (dist[nNode.next] > nNode.cost + curr.cost) {
                    dist[nNode.next] = nNode.cost + curr.cost;
                    pq.add(new Node(nNode.next, dist[nNode.next]));
                }
            }
        }

        return dist[ed];
    }
}



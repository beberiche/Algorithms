package Q1504_특정한_최단_경로;

import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int v, weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }


        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static final int INF = 987654321;
    static int V, E;
    static List<Node>[] adjList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();

        adjList = new ArrayList[V];
        for(int i=0; i<V; i++) {
            adjList[i] = new ArrayList<>();
        }

//        dist = new int[V];

        for(int i=0; i<E; i++) {
            int st = sc.nextInt()-1;
            int ed = sc.nextInt()-1;
            int w = sc.nextInt();
            adjList[st].add(new Node(ed, w));
            adjList[ed].add(new Node(st, w));
        }


        int node1 = sc.nextInt()-1;
        int node2 = sc.nextInt()-1;
        int ans1 = dijkstra(0, node1) + dijkstra(node1, node2) + dijkstra(node2, V-1);
        int ans2 = dijkstra(0, node2) + dijkstra(node2, node1) + dijkstra(node1, V-1);

        if(ans1 >= INF || ans2 >= INF || ans1 < 0 || ans2 < 0) System.out.println(-1);
        else System.out.println(Math.min(ans1, ans2));
    }

    private static int dijkstra(int st, int ed) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, INF);

        dist[st] = 0;
        pq.add(new Node(st, 0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            if(visited[curr.v]) continue;
            visited[curr.v] = true;

            for(Node n : adjList[curr.v]) {
                if(dist[n.v] > n.weight + curr.weight) {
                    dist[n.v] = n.weight + curr.weight;
                    pq.add(new Node(n.v, dist[n.v]));
                }
            }
        }

        return dist[ed];
    }
}



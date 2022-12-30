package Q10423_전기가_부족해;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int curr;
        int next;
        int dist;

        public Node(int curr, int next, int dist) {
            this.curr = curr;
            this.next = next;
            this.dist = dist;
        }
    }

    static List<Node> adjList[];
    static boolean[] visited;

    static PriorityQueue<Node> pq;
    static int N, M, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 노드 개수
        N = Integer.parseInt(st.nextToken());
        // 간선 개수
        M = Integer.parseInt(st.nextToken());
        // 발전소 개수
        K = Integer.parseInt(st.nextToken());
        int[] plant = new int[K];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            plant[i] = Integer.parseInt(st.nextToken());
        }

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            adjList[prev].add(new Node(prev, next, dist));
            adjList[next].add(new Node(next, prev, dist));
        }

        visited = new boolean[N + 1];
        pq = new PriorityQueue<>((n1, n2) -> n1.dist - n2.dist);
        for (int idx : plant) {
            visited[idx] = true;
            for (Node nNode : adjList[idx]) {
                pq.add(nNode);
            }
        }

        int d = K;
        int dist = 0;
        while (!pq.isEmpty()) {
            if (d >= N) {
                System.out.println(dist);
                break;
            }

            Node curr = pq.poll();
            if (visited[curr.next]) continue;
            for (Node nNode : adjList[curr.next]) {
                if (visited[nNode.curr]) continue;
                visited[nNode.curr] = true;
                pq.add(nNode);
                for (Node nNode2 : adjList[nNode.curr]) pq.add(nNode2);
                dist += curr.dist;
                d++;
            }
        }
    }

}

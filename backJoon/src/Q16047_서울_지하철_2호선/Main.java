package Q16047_서울_지하철_2호선;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int next;

        public Node(int next) {
            this.next = next;
        }
    }

    static List<Node> adjList[];
    static boolean[] visited, isCycle;
    static int p[];
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int curr = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            adjList[curr].add(new Node(next));
            adjList[next].add(new Node(curr));
        }


        p = new int[N + 1];
        isCycle = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            visited = new boolean[N + 1];
            findCycle(i, i,1);
        }

        for(int i=1; i<=N; i++) {
            if(!isCycle[i]) {
                p[i] = BFS(i);
            }
        }

    }

    private static void findCycle(int idx, int start ,int cnt) {
        visited[idx] = true;
        for (Node nNode : adjList[idx]) {
            if(nNode.next == start && cnt >= 3) isCycle[nNode.next] = true;
            if(!visited[nNode.next]) findCycle(nNode.next, start,cnt+1);
        }
    }
}

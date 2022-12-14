package Q15591_MooTube;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,Q;


    static class Node {
        int next;
        int weight;

        public Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }
    static List<Node> adjList[];

    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            adjList[i] = new ArrayList();
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());

            adjList[a].add(new Node(b,usado));
            adjList[b].add(new Node(a,usado));
        }


        StringBuilder sb = new StringBuilder();
        while(--Q>=0) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            visited = new boolean[N+1];
            sb.append(BFS(V,K)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int BFS(int st, int K) {
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        visited[st] = true;
        int cnt = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(Node nNode : adjList[curr]) {
                if(visited[nNode.next]) continue;
                if(nNode.weight<K) continue;
                visited[nNode.next]=true;
                q.add(nNode.next);
                cnt++;
            }
        }

        return cnt;
    }
}

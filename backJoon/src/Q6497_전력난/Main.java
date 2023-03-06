package Q6497_전력난;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static int m, n;
    static List<int[]> adjList[];
    private static int prim(int total) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1,n2)->n1[1]-n2[1]);
        boolean[] visited = new boolean[m];
        visited[0] = true;
        pq.addAll(adjList[0]);
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            if(visited[curr[0]]) continue;
            visited[curr[0]] = true;
            total -= curr[1];
            pq.addAll(adjList[curr[0]]);
        }
        return total;
    }

    private static void input() throws Exception {
        while (true) {
            stk = new StringTokenizer(br.readLine());
            m = Integer.parseInt(stk.nextToken());
            n = Integer.parseInt(stk.nextToken());
            int result = 0;
            if (m == 0 && n == 0) return;
            adjList = new ArrayList[m];
            for(int i=0; i<m; i++) {
                adjList[i] = new ArrayList<>();
            }
            for(int i=0; i<n; i++) {
                stk = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(stk.nextToken());
                int e = Integer.parseInt(stk.nextToken());
                int dist = Integer.parseInt(stk.nextToken());
                adjList[s].add(new int[] {e,dist});
                adjList[e].add(new int[] {s,dist});
                result += dist;
            }
            System.out.println(prim(result));
        }
    }

    public static void main(String[] args) throws Exception {
        input();
    }
}

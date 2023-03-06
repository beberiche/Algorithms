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
    static int m, n, edges[][], p[], result;
    static List<int[]> adjList[];
    static PriorityQueue<int[]> pq;

    private static int prim(int total) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        boolean[] visited = new boolean[m];
        visited[0] = true;
        pq.addAll(adjList[0]);
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (visited[curr[0]]) continue;
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
    private static int getFind(int n) {
        if(n == p[n]) return n;
        else return p[n] = getFind(p[n]);
    }
    private static boolean setUnion(int x, int y) {
        int fx = getFind(x);
        int fy = getFind(y);
        if(fx == fy) return false;
        p[fx] = fy;
        return true;
    }

    private static void kruskal() {
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            if(setUnion(curr[0], curr[1])) result -= curr[2];
        }
    }

    private static void input2() throws Exception {
        while (true) {
            stk = new StringTokenizer(br.readLine());
            m = Integer.parseInt(stk.nextToken());
            n = Integer.parseInt(stk.nextToken());
            if (m == 0 && n == 0) return;
            p = new int[m];
            for (int i = 0; i < m; i++) p[i] = i;
            result = 0;
            pq = new PriorityQueue<>((n1, n2) -> n1[2] - n2[2]);
            for (int i = 0; i < n; i++) {
                stk = new StringTokenizer(br.readLine());
                int[] curr =new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
                pq.add(curr);
                result += curr[2];
            }
            kruskal();
            System.out.println(result);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        input2();
    }
}

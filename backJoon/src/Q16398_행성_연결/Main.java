package Q16398_행성_연결;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static class Edge implements Comparable<Edge>{
        int st, ed, dist;

        Edge(int st, int ed, int dist) {
            this.st = st;
            this.ed = ed;
            this.dist = dist;
        }


        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }
    static List<Edge> list[];
    static boolean visited[];
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    private static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        for(int i=0; i<N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int dist = Integer.parseInt(st.nextToken());
                if(i==j) continue;
                list[i].add(new Edge(i,j,dist));
            }
        }
        visited = new boolean[N];
        pq.addAll(list[0]);
        visited[0] = true;
    }
    private static long prim() {
        int cnt = 1;
        long ans = 0;
        while(cnt < N) {
            Edge curr = pq.poll();
            if(visited[curr.ed]) continue;

            ans += curr.dist;
            pq.addAll(list[curr.ed]);
            visited[curr.ed] = true;
            cnt++;
        }
        return ans;
    }

    private static void output() {
        System.out.println(prim());
    }
    public static void main(String[] args) throws Exception{
        input();
        output();
    }
}

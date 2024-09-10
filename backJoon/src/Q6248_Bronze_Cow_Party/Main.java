package Q6248_Bronze_Cow_Party;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int X = Integer.parseInt(stk.nextToken());

        List<int[]>[] list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());

            list[n1].add(new int[]{n2, dist});
            list[n2].add(new int[]{n1, dist});
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);

        pq.add(new int[]{X, 0});
        int[] dist = new int[N+1];
        Arrays.fill(dist, (int) 1e9);
        dist[X] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            for(int[] next : list[curr[0]]) {
                if(dist[next[0]] > curr[1] + next[1]) {
                    dist[next[0]] = curr[1] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }

        int ret = 0;
        for(int i=1; i<=N; i++) {
            ret = Math.max(ret, dist[i]);
        }
        System.out.println(ret*2);
    }
}

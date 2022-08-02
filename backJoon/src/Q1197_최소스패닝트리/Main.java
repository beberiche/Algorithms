package Q1197_최소스패닝트리;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        List[] list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<int[]>();
        }

        for (int i = 0; i < E; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int cost = sc.nextInt();

            list[st].add(new int[]{ed, cost});
            list[ed].add(new int[]{st, cost});
        }

        boolean[] visited = new boolean[V+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1,n2)-> n1[1]-n2[1]);
        pq.addAll(list[1]);
        visited[1] = true;

        int ans = 0;
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            if(visited[curr[0]])
                continue;

            ans+=curr[1];
            pq.addAll(list[curr[0]]);
            visited[curr[0]] = true;
        }
        System.out.println(ans);
    }
}

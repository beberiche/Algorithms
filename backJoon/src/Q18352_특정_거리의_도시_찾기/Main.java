package Q18352_특정_거리의_도시_찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Integer> list[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int X = Integer.parseInt(stk.nextToken());


        list = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            list[n1].add(n2);
        }


        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{X,0});
        boolean[] visited = new boolean[N+1];
        visited[X]= true;

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2)->n1-n2);
        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[1] == K) {
                pq.add(curr[0]);
                continue;
            }

            for(int next: list[curr[0]]) {
                if(visited[next]) continue;

                visited[next] = true;
                q.add(new int[]{next,curr[1]+1});
            }
        }

        if(pq.isEmpty()){
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        System.out.print(sb.toString());
    }
}

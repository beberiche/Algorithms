package Q6188_Clear_Cold_Water;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());

        int[][] tree = new int[N + 1][2];


        for (int i = 1; i <= C; i++) {
            stk = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(stk.nextToken());
            int c1 = Integer.parseInt(stk.nextToken());
            int c2 = Integer.parseInt(stk.nextToken());

            tree[node] = new int[]{c1, c2};
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[] dist = new int[N + 1];
        dist[1] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int i = 0; i < 2; i++) {
                if (tree[curr][i] != 0 && dist[tree[curr][i]] == 0) {
                    dist[tree[curr][i]] = dist[curr] + 1;
                    q.add(tree[curr][i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(dist[i]).append("\n");
        }
        System.out.print(sb.toString());
    }
}

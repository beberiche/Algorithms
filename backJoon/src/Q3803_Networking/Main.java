package Q3803_Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        while (true) {
            stk = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(stk.nextToken());
            if (P == 0) break;

            int R = Integer.parseInt(stk.nextToken());

            List<int[]>[] a = new ArrayList[P + 1];
            for (int i = 1; i <= P; i++) {
                a[i] = new ArrayList<>();
            }
            for (int i = 0; i < R; i++) {
                stk = new StringTokenizer(br.readLine());
                int st = Integer.parseInt(stk.nextToken());
                int ed = Integer.parseInt(stk.nextToken());
                int cost = Integer.parseInt(stk.nextToken());

                a[st].add(new int[]{ed, cost});
                a[ed].add(new int[]{st, cost});
            }

            sb.append(go(a)).append("\n");
            br.readLine();
        }
        System.out.print(sb);
    }

    private static int go(List<int[]>[] a) {
        boolean[] visited = new boolean[a.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        pq.add(new int[]{1, 0});

        int ans = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if (visited[curr[0]]) continue;
            visited[curr[0]] = true;
            ans += curr[1];

            for (int[] next : a[curr[0]]) {
                if (!visited[next[0]]) {
                    pq.add(new int[]{next[0], next[1]});
                }
            }
        }
        return ans;
    }
}

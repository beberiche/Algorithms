package Q13334_철로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq1 = new PriorityQueue<>((n1, n2) -> n1[1] == n2[1] ? n1[0] - n2[0] : n1[1] - n2[1]);
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            pq1.add(n1 <= n2 ? new int[]{n1, n2} : new int[]{n2, n1});
        }

        int d = Integer.parseInt(br.readLine());
        int ans = 0;
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        while (!pq1.isEmpty()) {
            int[] curr = pq1.poll();
            if (curr[1] - curr[0] > d) continue;
            else pq2.add(curr[0]);
            while (!pq2.isEmpty()) {
                int st = pq2.peek();
                if (st < curr[1] - d) pq2.poll();
                else break;
            }
            ans = Math.max(ans, pq2.size());
        }
        System.out.println(ans);
        br.close();
    }
}

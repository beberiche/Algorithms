package Q10806_수_만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(stk.nextToken());
            K = Integer.parseInt(br.readLine());
            PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
            pq.add(new int[]{K, 0});
            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                if (curr[0] == 0) {
                    sb.append(curr[1]).append("\n");
                    break;
                }
                pq.add(new int[]{0, curr[0] + curr[1]});
                for (int i = 0; i < N; i++) pq.add(new int[]{curr[0] / arr[i], curr[1] + curr[0] % arr[i]});
            }
        }
        System.out.print(sb);
    }
}

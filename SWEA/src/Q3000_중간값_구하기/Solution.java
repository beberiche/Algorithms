package Q3000_중간값_구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static PriorityQueue<Integer> spq, bpq;
    static final int MOD = 20171109;
    static int H;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            H = Integer.parseInt(stk.nextToken());
            // H 기준 작은 수가 들어오는 spq;
            spq = new PriorityQueue<>((n1,n2)->n2-n1);
            // H 기준 큰 수가 들어오는 bqp;
            bpq = new PriorityQueue<>();
            int sum = 0;
            for (int i = 0; i < N; i++) {
                stk = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(stk.nextToken());
                int n2 = Integer.parseInt(stk.nextToken());
                if (n1 > H) bpq.add(n1);
                else spq.add(n1);
                if (n2 > H) bpq.add(n2);
                else spq.add(n2);
                while (spq.size() > bpq.size()) {
                    bpq.add(H);
                    H = spq.poll();
                }
                while (spq.size() < bpq.size()) {
                    spq.add(H);
                    H = bpq.poll();
                }
                sum = (sum + H) % MOD;
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }

}

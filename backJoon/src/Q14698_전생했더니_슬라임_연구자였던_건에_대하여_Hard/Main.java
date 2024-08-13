package Q14698_전생했더니_슬라임_연구자였던_건에_대하여_Hard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int MOD = 1_000_000_007;
        StringBuilder sb = new StringBuilder();
        while (--T >= 0) {
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>((n1, n2) -> Long.compare(n1, n2));
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pq.add(Long.parseLong(stk.nextToken()));
            }
            long ret = 1;

            while (pq.size() > 1) {
                long n1 = pq.poll();
                long n2 = pq.poll();

                long num = n1 * n2;
                ret = (num % MOD) * (ret % MOD);
                pq.add(num);
            }
            sb.append(ret).append("\n");
        }
        System.out.print(sb.toString());
    }
}

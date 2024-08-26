package Q11256_사탕;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (--T >= 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(stk.nextToken());
            int N = Integer.parseInt(stk.nextToken());


            PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2)->n2-n1);
            for (int i = 0; i < N; i++) {
                stk = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(stk.nextToken());
                int c = Integer.parseInt(stk.nextToken());
                pq.add(r * c);
            }

            int cnt = 0;
            while (J > 0 && !pq.isEmpty()) {
                J -= pq.poll();
                cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb.toString());
    }
}

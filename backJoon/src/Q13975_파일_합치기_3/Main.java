package Q13975_파일_합치기_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static StringTokenizer stk;
    static PriorityQueue<Long> pq;
    static long ret;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (--T >= 0) {
            N = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                pq.add(Long.parseLong(stk.nextToken()));
            }

            ret = 0;
            for (int i = 0; i < N - 1; i++) {
                long n1 = 0;
                long n2 = 0;
                if (!pq.isEmpty()) n1 = pq.poll();
                if (!pq.isEmpty()) n2 = pq.poll();

                ret += n1 + n2;
                pq.add(n1+n2);
            }

            sb.append(ret).append("\n");
        }
        System.out.print(sb.toString());
    }
}

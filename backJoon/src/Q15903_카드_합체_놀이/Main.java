package Q15903_카드_합체_놀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>((n1, n2) -> Long.compare(n1, n2));
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(stk.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            long sum = pq.poll() + pq.poll();
            pq.add(sum);
            pq.add(sum);
        }

        pq.stream().reduce((n1, n2) -> n1 + n2).ifPresent(System.out::println);
    }
}

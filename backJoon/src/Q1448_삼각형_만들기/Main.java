package Q1448_삼각형_만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int n1 = pq.poll();
        int n2 = pq.poll();
        int n3 = pq.poll();

        if (n1 < n2 + n3) {
            System.out.println(n1 + n2 + n3);
        } else {
            while (!pq.isEmpty()) {
                n1 = n2;
                n2 = n3;
                n3 = pq.poll();

                if (n1 < n2 + n3) {
                    System.out.println(n1+n2+n3);
                    System.exit(0);
                }
            }

            System.out.println(-1);
        }
    }
}

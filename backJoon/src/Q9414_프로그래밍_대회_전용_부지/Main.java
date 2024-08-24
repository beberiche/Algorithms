package Q9414_프로그래밍_대회_전용_부지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String EXP = "Too expensive";
        int m = 5 * (int) 1e6;
        while (--T >= 0) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
            while (true) {
                int num = Integer.parseInt(br.readLine());
                if (num == 0) break;
                pq.add(num);
            }

            int p = 1;
            long ret = 0;
            while (!pq.isEmpty()) {
                int curr = pq.poll();

                ret += 2L * (long) Math.pow(curr, p++);
                if (ret > m) {
                    break;
                }
            }

            sb.append(ret > m ? EXP : ret).append("\n");
        }
        System.out.print(sb.toString());
    }
}

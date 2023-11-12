package Q15703_주사위_쌓기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(stk.nextToken()));
        }

        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= curr) {
                    list.set(i, list.get(i) + 1);
                    flag = true;
                    break;
                }
            }

            if (!flag) list.add(1);
        }

        System.out.println(list.size());
    }
}

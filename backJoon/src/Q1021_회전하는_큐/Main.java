package Q1021_회전하는_큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        LinkedList<Integer> dq = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        stk = new StringTokenizer(br.readLine());
        int sum = 0;
        while (--M >= 0) {
            int num = Integer.parseInt(stk.nextToken());

            int idx = dq.indexOf(num);
            int mid = dq.size() / 2;


            if (idx <= mid) {
                for (int i = 0; i < idx; i++) {
                    dq.addLast(dq.pollFirst());
                }
                sum += idx;
            } else {
                for (int i = dq.size(); i > idx; i--) {
                    dq.addFirst(dq.pollLast());
                }
                sum += dq.size() - idx;
            }
            dq.pollFirst();
        }

        System.out.println(sum);
    }
}

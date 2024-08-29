package Q21967_세워라_반석_위에;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }

        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        int l = 0;
        int max = 0;

        for (int r = 0; r < N; r++) {
            while (!minDeque.isEmpty() && minDeque.peekLast() > a[r]) minDeque.pollLast();
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < a[r]) maxDeque.pollLast();

            minDeque.addLast(a[r]);
            maxDeque.addLast(a[r]);

            while (maxDeque.peekFirst() - minDeque.peekFirst() > 2) {
                if (minDeque.peekFirst() == a[l]) minDeque.pollFirst();
                if (maxDeque.peekFirst() == a[l]) maxDeque.pollFirst();
                l++;
            }

            max = Math.max(max, r - l + 1);
        }

        System.out.println(max);
    }
}

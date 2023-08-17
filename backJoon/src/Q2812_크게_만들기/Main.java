package Q2812_크게_만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static String str;
    static Deque<Character> dq = new ArrayDeque<>();

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        str = br.readLine();
    }

    private static void solve() {
        dq.addLast(str.charAt(0));
        for (int i = 1; i < N; i++) {
            while (!dq.isEmpty()) {
                if (dq.peekLast() < str.charAt(i) && K > 0) {
                    K--;
                    dq.pollLast();
                } else break;
            }
            dq.addLast(str.charAt(i));
        }

        while (K > 0) {
            K--;
            dq.pollLast();
        }
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

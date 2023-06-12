package Q2170_선_긋기;

import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        if (a[0] == b[0]) return a[1] - b[1];
        return a[0] - b[0];
    });
    static int N, ans;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            pq.add(new int[]{a, b});
        }
    }

    private static void solve() {
        int l = pq.peek()[0];
        int r = pq.peek()[1];
        pq.poll();
        while (!pq.isEmpty()) {
            int[] n = pq.poll();
            if (n[0] >  r) {
                ans += (r - l);
                l = n[0];
                r = n[1];
            } else if(n[1]>r) r = n[1];

        }
        ans += (r - l);
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

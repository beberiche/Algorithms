package Q1516_게임_개발;

import java.io.*;
import java.util.*;

public class Main {
    static int N, a[], d[], ans[];
    static List<Integer> list[];
    static Queue<Integer> q;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N + 1];
        d = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(stk.nextToken());
            while (true) {
                int num = Integer.parseInt(stk.nextToken());
                if (num < 0) break;
                list[num].add(i);
                d[i]++;
            }
        }
    }

    private static void solve() {
        q = new LinkedList<>();
        ans = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (d[i] <= 0) {
                q.add(i);
                ans[i] = a[i];
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int n : list[curr]) {
                ans[n] = Math.max(ans[n], ans[curr] + a[n]);
                if (--d[n] == 0) q.add(n);
            }
        }
    }

    private static void output() {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

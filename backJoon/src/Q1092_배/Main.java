package Q1092_배;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static List<Integer> a, b;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        a = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            a.add(Integer.parseInt(stk.nextToken()));
        }
        Collections.sort(a, (a, b) -> b - a);
        M = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        b = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            b.add(Integer.parseInt(stk.nextToken()));
        }
        Collections.sort(b, (a, b) -> b - a);
    }

    private static void solve() {
        if (b.get(0) > a.get(0)) {
            ans = -1;
            return;
        }

        while (!b.isEmpty()) {
            int idx = 0;
            for (int i = 0; i < a.size(); i++) {
                if (idx == b.size()) break;
                else if (a.get(i) >= b.get(idx)) {
                    b.remove(idx);
                } else {
                    idx++;
                    i--;
                }
            }
            ans++;
        }
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

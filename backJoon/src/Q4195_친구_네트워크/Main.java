package Q4195_친구_네트워크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, p[], cnt[];
    static Map<String, Integer> m;

    private static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        m = new HashMap<>();
        p = new int[2 * N + 1];

        cnt = new int[2 * N + 1];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
            cnt[i] = 1;
        }
    }

    private static int find(int num) {
        if (num == p[num]) return num;
        return p[num] = find(p[num]);
    }


    private static void solve() throws Exception {
        int idx = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String f1 = stk.nextToken();
            String f2 = stk.nextToken();
            int n1, n2;
            if (!m.containsKey(f1)) m.put(f1, idx++);
            if (!m.containsKey(f2)) m.put(f2, idx++);
            n1 = m.get(f1);
            n2 = m.get(f2);

            int px = find(n1);
            int py = find(n2);
            if (px < py) {
                p[py] = px;
                cnt[px] += cnt[py];
                sb.append(cnt[px]);
            } else if (px > py) {
                p[px] = py;
                cnt[py] += cnt[px];
                sb.append(cnt[py]);
            } else {
                sb.append(cnt[px]);
            }

            sb.append("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            input();
            solve();
        }
        System.out.print(sb.toString());
    }
}

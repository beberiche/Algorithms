package Q2539_모자이크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int r, c, k, m, L, R, ans;
    static List<int[]> list;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            list.add(new int[]{n1, n2});
        }
        Collections.sort(list, (n1, n2) -> n1[1] - n2[1]);
    }

    private static int go(int num) {
        int cnt = 0;
        int prev = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] > num) return k + 4;
            if (prev == 0 || prev + num <= list.get(i)[1]) {
                prev = list.get(i)[1];
                cnt++;
                if (cnt > k) return k + 4;
            }
        }

        return cnt;
    }

    private static void solve() {
        L = 1;
        R = Math.min(r, c);

        while (L < R) {
            int mid = (L + R) / 2;
            if (go(mid) <= k) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
    }

    private static void output() {
        System.out.println(R);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

package Q16564_히오스_프로게이머;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, arr[];
    static long l = 1, r = 1_000_000_000, ans;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            l = Math.min(l, arr[i]);
        }
    }

    private static long go(long num) {
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] < num) {
                cnt += num - arr[i];
                if (cnt > K) return cnt;
            }
        }
        return cnt;
    }

    private static void solve() {
        r += K;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (go(mid) <= K) {
                l = mid + 1;
                ans = Math.max(mid, ans);
            } else {
                r = mid - 1;
            }
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

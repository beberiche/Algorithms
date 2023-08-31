package Q3079_입국심사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static long arr[], l, r, min=Long.MAX_VALUE, M_MAX=1_000_000_000L;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min= Math.min(min, arr[i]);
        }
    }

    private static long go(long mid) {
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt += mid / arr[i];
        }
        return cnt;
    }

    private static void solve() {
        l = 1;
        r = M_MAX*min;
        while (l < r) {
            long mid = (l + r) / 2;
            if (go(mid) >= M) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
    }

    private static void output() {
        System.out.println(r);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

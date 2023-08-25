package Q13702_이상한_술집;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[];
    static long l=1, r, ans;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            r = Math.max(arr[i], r);
        }

        Arrays.sort(arr);
    }

    private static int go(long mid) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt += arr[i] / mid;
        }
        return cnt;
    }

    private static void solve() {
        while (l <= r) {
            long mid = (l + r) / 2;
            if (go(mid) < M) {
                r = mid-1;
            } else {
                l = mid+1;
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

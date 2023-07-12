package Q2512_예산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 매개변수 탐색, 매개변수 총합이 M이하라면 L++
// 초과라면 R--
public class Main {
    static int N, arr[], M, MAX;
    static long ans;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            MAX = Math.max(arr[i], MAX);
        }
        M = Integer.parseInt(br.readLine());
    }

    private static boolean go(long mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (arr[i] > mid) ? mid : arr[i];
        }

        return sum <= M;
    }

    private static void solve() {
        long L = 1;
        long R = MAX;
        while (L <= R) {
            long mid = (L + R) / 2;
            if (go(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
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

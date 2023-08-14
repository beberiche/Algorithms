package Q2003_수들의_합_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[], ans;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        arr = new int[N + 1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] += arr[i - 1] + Integer.parseInt(stk.nextToken());
        }
    }

    private static void solve() {
        int l = 0;
        int r = 1;
        while (r <= N) {
            int num = arr[r] - arr[l];
            if (l == r || num < M) {
                r++;
            } else {
                if (num == M) ans++;
                l++;
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

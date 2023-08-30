package Q13397_구간_나누기_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[], l, r;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new int[N];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            r = Math.max(r, arr[i]);
        }
        r++;
    }

    private static int go(int mid) {
        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MIN_VALUE;

        int cnt = 1;
        for (int i = 0; i < N; i++) {
            n1 = Math.min(arr[i], n1);
            n2 = Math.max(arr[i], n2);

            if (n2 - n1 > mid) {
                cnt++;
                n1 = Integer.MAX_VALUE;
                n2 = Integer.MIN_VALUE;
                i--;
            }
        }

        return cnt;
    }

    private static void solve() {
        while (l < r) {
            int mid = (l + r) / 2;
            if (go(mid) <= M) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
    }

    private static void output() {
        System.out.print(r);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

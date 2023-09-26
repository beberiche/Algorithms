package Q2613_숫자구슬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[], L = 0, R;

    //    static Node curr;
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new int[N];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            L = Math.max(L, arr[i]);
            R += arr[i];
        }
    }

    private static boolean go(int mid) {
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (sum > mid) {
                sum = arr[i];
                cnt++;
            }
        }

        return cnt <= M;
    }

    private static void calc(int mid) {
        sb.append(mid).append("\n");

        int sum = 0, cnt = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (sum > mid) {
                sum = arr[i];
                M--;
                sb.append(cnt).append(" ");
                cnt = 1;
            } else {
                cnt++;
            }

            if (M == N - i) break;
        }

        while (M-- != 0) {
            sb.append(cnt).append(" ");
            cnt = 1;
        }
    }

    private static void solve() {
        while (L < R) {
            int mid = (L + R) / 2;
            if (go(mid)) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }

        calc(R);
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

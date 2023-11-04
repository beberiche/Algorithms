package Q17179_케이크_자르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, L, arr[], curr, ret;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());

        arr = new int[M + 2];
        for (int i = 1; i <= M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        arr[M + 1] = L;
    }

    private static boolean go(int mid) {
        int cnt = 0;
        int num = arr[0];
        int diff = 0;
        for (int i = 1; i < arr.length; i++) {
            if (diff + arr[i] - num >= mid) {
                cnt++;
                diff = 0;
                if (cnt > curr) {
                    return false;
                }
            } else {
                diff += arr[i] - num;
            }

            num = arr[i];
        }

        return cnt <= curr;
    }

    private static void solve() throws Exception {
        while (--N >= 0) {
            curr = Integer.parseInt(br.readLine());
            int l = 1;
            int r = L;
            ret = 0;
            while (l < r) {
                int mid = (l + r) / 2;
                if (go(mid)) {
                    r = mid - 1;
                } else {
                    ret = mid;
                    l = mid + 1;
                }
            }
            sb.append(ret).append("\n");
        }
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

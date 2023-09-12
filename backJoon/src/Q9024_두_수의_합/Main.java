package Q9024_두_수의_합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// K를 투포인터 -> 존재하면 반환
// K+n, K-n 투포인터, (K+n), (K-n)가 존재하는 경우 더해서 반환
public class Main {
    static int N, K, arr[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    private static int twoPointer(long num) {
        int l = 0;
        int r = N - 1;
        int ret = 0;

        while (l < r) {
            long mid = arr[l] + arr[r];
            if (mid == num) {
                ret++;
                l++;
                r--;
            } else if (mid < num) l++;
            else r--;
        }

        return ret;
    }

    private static void input() throws Exception {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        arr = new int[N];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);
    }

    private static void solve() throws Exception {
        int ret = twoPointer(K);
        if (ret > 0) {
            sb.append(ret).append("\n");
            return;
        } else {
            int n = 1;
            while (true) {
                int retA = twoPointer(K + n);
                int retB = twoPointer(K - n);
                if (retA + retB > 0) {
                    sb.append(retA+retB).append("\n");
                    return;
                }
                n++;
            }
        }
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            input();
            solve();
        }
        output();
    }
}

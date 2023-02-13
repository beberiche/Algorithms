package Q13736_사탕_분배;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int a, b, k;
    static long[] arr;
    static long ans;

    private static void input() throws Exception {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        a = Integer.parseInt(stk.nextToken());
        b = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        arr = new long[31];
        arr[0] = 2;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (arr[i - 1] * arr[i - 1]) % (a + b);
        }
    }

    private static void solve() {
        int sum = a + b;
        long res = 1;
        for (int i = 0; i < arr.length; i++) {
            if ((k & 1 << i) != 0) {
                res = (res * arr[i]) % (sum);
            }
        }
        ans = Math.min((a*res)%sum, (b*res)%sum);
    }

    private static void output(int t) {
        System.out.println("#"+t+" "+ans);
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            input();
            solve();
            output(t);
        }
    }
}

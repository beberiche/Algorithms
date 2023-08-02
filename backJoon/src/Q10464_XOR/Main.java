package Q10464_XOR;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int S, F, ans;
    static BufferedReader br;

    private static void input() throws Exception {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        S = Integer.parseInt(stk.nextToken());
        F = Integer.parseInt(stk.nextToken());
    }

    private static int go(int num) {
        int n = num % 4;
        return n == 0 ? num : n == 1 ? n : n == 2 ? num + 1 : 0;
    }

    private static void solve() {
        ans = go(S - 1) ^ go(F);
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            input();
            solve();
            output();
        }
    }
}

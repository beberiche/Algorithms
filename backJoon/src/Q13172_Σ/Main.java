package Q13172_Σ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;

    static long M, N, S, MOD = 1_000_000_007;

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static void input() throws Exception {
        N = Long.parseLong(stk.nextToken());
        S = Long.parseLong(stk.nextToken());
        long g = gcd(S, N);
        N /= g;
        S /= g;
    }

    private static long solve(long num, long p) {
        if (p == 1L) return num;
        if (p % 2 == 1L) return num * solve(num, p - 1) % MOD;
        long ret = solve(num, p / 2);
        return ret * ret % MOD;
    }

    public static void main(String[] args) throws Exception {
        M = Long.parseLong(br.readLine());
        long ans = 0;
        while (--M >= 0) {
            stk = new StringTokenizer(br.readLine());
            input();
            ans += S * solve(N, MOD - 2) % MOD;
            ans %= MOD;
        }
        System.out.print(ans);
        Set<String> s = new HashSet<>();
        s.add("12");
        System.out.println(s.contains(new String("12")));
    }


}

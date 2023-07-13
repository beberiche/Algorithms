package Q17670_부자의_꿈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;
    static int N, M, Q, R[], C[], sum;
    static Set<Integer> s;
    private static void input() throws Exception {

        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        Q = Integer.parseInt(stk.nextToken());

        R = new int[N + 1];
        C = new int[M + 1];

        for (int i = 1; i <= N; ++i) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; ++j) {
                int a = Integer.parseInt(stk.nextToken());
                R[i] = Math.max(R[i], a);
                C[j] = Math.max(C[j], a);
            }
        }
    }

    private static void init() throws Exception {
        s = new HashSet<>();
        sum = 0;
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= M; ++j) {
                if (R[i] == C[j]) {
                    s.add(R[i]);
                    break;
                }
            }
        }
    }

    private static void solve() throws Exception {
        for (int q = 1; q <= Q; q++) {
            stk = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            int val = Integer.parseInt(stk.nextToken());

            if (R[r] == C[c]) {
                s.remove(R[r]);
                R[r] = Math.max(R[r], val);
                C[c] = Math.max(C[c], val);
                s.add(R[r]);
            } else {
                if (R[r] < val) s.remove(R[r]);
                if (C[c] < val) s.remove(C[c]);
                R[r] = Math.max(R[r], val);
                C[c] = Math.max(C[c], val);
                if (R[r] == C[c]) s.add(R[r]);
            }
            sum += s.size();
        }
    }

    private static void output(int t) {
        sb.append('#').append(t).append(' ').append(sum).append('\n');
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            input();
            init();
            solve();
            output(t);
        }
        System.out.print(sb);
    }
}

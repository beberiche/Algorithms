package Q20529_가장_가까운_세_사람의_심리적_거리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, ans = 0;
    static String s[], a[] = {"ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP", "ESTP", "ESFP", "ENFP", "ENTP", "ESTJ", "ESFJ", "ENFJ", "ENTJ"};
    static HashMap<String, Integer> m = new HashMap<>();
    static StringBuilder sb = new StringBuilder();


    private static int go(int idx1, int idx2) {
        int d = 0;
        for (int i = 0; i < 4; i++) {
            if (a[idx1].charAt(i) != a[idx2].charAt(i)) d++;
        }
        m.put(a[idx1] + a[idx2], d);
        m.put(a[idx2] + a[idx1], d);
        return d;
    }

    private static void init() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                int ret1 = m.containsKey(a[i] + a[j]) ? m.get(a[i] + a[j]) : go(i, j);
                for (int k = 0; k < 16; k++) {
                    if (m.containsKey(a[i] + a[j] + a[k])) continue;
                    int ret2 = m.containsKey(a[j] + a[k]) ? m.get(a[j] + a[k]) : go(j, k);
                    int ret3 = m.containsKey(a[i] + a[k]) ? m.get(a[i] + a[k]) : go(i, k);
                    m.put(a[i] + a[j] + a[k], ret1 + ret2 + ret3);
                    m.put(a[i] + a[k] + a[j], ret1 + ret2 + ret3);
                    m.put(a[j] + a[i] + a[k], ret1 + ret2 + ret3);
                    m.put(a[j] + a[k] + a[i], ret1 + ret2 + ret3);
                    m.put(a[k] + a[i] + a[j], ret1 + ret2 + ret3);
                    m.put(a[k] + a[j] + a[i], ret1 + ret2 + ret3);
                }
            }
        }
    }

    private static void solve() throws Exception {
        N = Integer.parseInt(br.readLine());
        ans = 987654321;
        if (N > 32) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            return;
        }
        s = new String[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            s[i] = stk.nextToken();
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    ans = Math.min(ans, m.get(s[i] + s[j] + s[k]));
                }
            }
        }
    }

    private static void output() {
        sb.append(ans == 987654321 ? 0 : ans).append("\n");
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        init();
        while (--T >= 0) {
            solve();
            output();
        }
        System.out.println(sb.toString());
    }
}

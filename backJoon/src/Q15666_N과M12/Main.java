package Q15666_N과M12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static HashSet<String> s = new HashSet<>();
    static int N, M, arr[];
    static StringBuffer sb = new StringBuffer();

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        arr = new int[N];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
    }


    private static void go(String str, int d, int idx) {
        if (d >= M) {
            if (!s.contains(str)) {
                s.add(str);
                sb.append(str);
                sb.append("\n");
            }
            return;
        }

        int prev = -1;
        for (int i = idx; i < N; i++) {
            if (prev != arr[i]) {
                prev = arr[i];
                go(str.length() == 0 ? String.valueOf(arr[i]) : str + " " + String.valueOf(arr[i]), d + 1, i);
            }

        }
    }

    private static void solve() {
        go("", 0, 0);
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

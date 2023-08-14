package Q1484_다이어트;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, cnt;
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    private static void solve() {
        int l = 1;
        int r = 2;

        while (r <= N) {
            if (l == r) {
                r++;
                continue;
            }

            int mid = r * r - l * l;
            if (mid <= N) {
                if (mid == N) {
                    sb.append(r).append("\n");
                    cnt++;
                }
                r++;
            } else {
                if (l + 1 == r) break;
                l++;
            }
        }
    }

    private static void output() {
        System.out.print(cnt == 0 ? -1 : sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

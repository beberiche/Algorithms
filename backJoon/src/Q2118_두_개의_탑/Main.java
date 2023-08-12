package Q2118_두_개의_탑;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, arr[], ans, sum;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] += arr[i - 1] + Integer.parseInt(br.readLine());
        }
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N - i; j++) {
                int n1 = arr[i + j] - arr[j];
                int n2 = arr[N] - n1;
                ans = Math.max(ans, Math.min(n1, n2));
            }
        }
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}


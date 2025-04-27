package Q1590_캠프가는_영식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int T = Integer.parseInt(stk.nextToken());

        int INF = Integer.MAX_VALUE;
        int ans = INF;
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(stk.nextToken());
            int I = Integer.parseInt(stk.nextToken());
            int C = Integer.parseInt(stk.nextToken());

            int[] a = new int[C];
            a[0] = S;
            for (int j = 1; j < C; j++) {
                a[j] = a[j - 1] + I;
            }

            int t = lowerBound(a, T);

            if (t == -1) continue;
            ans = Math.min(ans, t - T);
        }
        System.out.println(ans == INF ? -1 : ans);
    }

    private static int lowerBound(int[] a, int t) {
        int left = 0;
        int right = a.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid] < t) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (right == a.length) return -1;
        return a[left];
    }
}

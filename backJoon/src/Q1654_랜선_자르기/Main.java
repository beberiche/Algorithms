package Q1654_랜선_자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(stk.nextToken());
        int N = Integer.parseInt(stk.nextToken());
        int[] a = new int[K];

        for (int i = 0; i < K; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        long l = 1;
        long r = Integer.MAX_VALUE;
        long ans = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (cal(mid, a) >= N) {
                ans = Math.max(ans, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static long cal(long mid, int[] a) {
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] / mid);
        }
        return sum;
    }
}

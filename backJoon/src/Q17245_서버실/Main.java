package Q17245_서버실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] a = new int[N][N];
        long sum = 0L;
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
                sum += a[i][j];
            }
        }

        long half = sum / 2;
        if (sum % 2 == 1) {
            half++;
        }

        int l = 0;
        int r = 10_000_000;

        while (l < r) {
            int mid = (l + r) >> 1;
            if (cal(mid, a) < half) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.print(r);
    }

    public static long cal(int mid, int[][] a) {
        long ret = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                ret += Math.min(a[i][j], mid);
            }
        }
        return ret;
    }
}

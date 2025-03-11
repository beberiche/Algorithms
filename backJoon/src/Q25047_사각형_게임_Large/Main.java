package Q25047_사각형_게임_Large;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        long ret = getRet(n, a);
        System.out.println(ret);
    }

    private static long getRet(int n, int[][] a) {
        long ret = Long.MIN_VALUE;
        int bit = 1 << n;
        for (int i = 0; i < bit; i++) {
            long score = 0;
            for (int j = 0; j < n; j++) {
                long sum1 = 0;
                long sum2 = 0;
                for (int k = 0; k < n; k++) {
                    int idx = 1 << k;

                    if ((i & idx) == idx) {
                        sum1 += a[k][j]; // 색을 칠한 경우
                    } else {
                        sum2 += a[k][j]; // 색을 안칠한 경우
                    }
                }
                score += Math.min(sum1, sum2);
            }
            ret = Math.max(score, ret);
        }
        return ret;
    }
}

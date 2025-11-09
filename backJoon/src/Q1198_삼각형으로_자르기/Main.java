package Q1198_삼각형으로_자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] a = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            a[i] = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
        }

        double ret = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    ret = Math.max(ret, go(a[i], a[j], a[k]));
                }
            }
        }
        System.out.println(ret);
    }

    private static double go(int[] a1, int[] a2, int[] a3) {
        return (double) Math.abs(a1[0] * a2[1] + a2[0] * a3[1] + a3[0] * a1[1] - a1[1] * a2[0] - a2[1] * a3[0] - a3[1] * a1[0]) / 2;
    }
}

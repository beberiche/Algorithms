package Q1359_복권;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        double t = comb(N, M);

        double w = 0.0;

        for (int i = K; i <= M; i++) {
            double ww = comb(M, i) * comb(N - M, M - i);
            w += ww;
        }

        System.out.print(w / t);
    }

    private static double comb(int n, int r) {
        if (r < 0 || r > n) return 0.0;
        r = Math.min(r, n - r);

        double result = 1.0;
        for (int i = 1; i <= r; i++) {
            result *= (n - r + i);
            result /= i;
        }
        return result;
    }
}

package Q2022_사다리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        double X = Double.parseDouble(stk.nextToken());
        double Y = Double.parseDouble(stk.nextToken());
        double C = Double.parseDouble(stk.nextToken());

        double l = 0;
        double r = Math.min(X, Y);

        double h1, h2;
        while (r - l >= 0.001) {
            double mid = (l + r) / 2;
            h1 = Math.sqrt(Math.pow(X, 2) - Math.pow(mid, 2));
            h2 = Math.sqrt(Math.pow(Y, 2) - Math.pow(mid, 2));

            if ((h1 * h2) / (h1 + h2) >= C) l = mid;
            else r = mid;
        }
        System.out.printf("%.3f", r);
    }
}

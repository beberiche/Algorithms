package Q4454_상근이의_여자친구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static double a, b, c, d, m, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            StringTokenizer stk = new StringTokenizer(str);
            double a = Double.parseDouble(stk.nextToken());
            double b = Double.parseDouble(stk.nextToken());
            double c = Double.parseDouble(stk.nextToken());
            double d = Double.parseDouble(stk.nextToken());
            double m = Double.parseDouble(stk.nextToken());
            double t = Double.parseDouble(stk.nextToken());

            double l = 0.0;
            double r = 1000.0;

            while (r - l > 1e-9) {
                double mid = (l + r) / 2.0;
                double ret = m * (a * mid * mid * mid + b * mid * mid + c * mid + d);
                if (ret <= t) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            double ans = Math.floor(l * 100.0) / 100.0;
            sb.append(String.format("%.2f\n", ans));
        }
        System.out.print(sb);
    }

}

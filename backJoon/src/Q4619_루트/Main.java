package Q4619_루트;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());

            if (b == 0 && n == 0) break;

            int closest = 1;
            for (int i = 1; ; i++) {
                double power = Math.pow(i, n);
                if (power >= b) {
                    double diffLow = b - Math.pow(i - 1, n);
                    double diffHigh = power - b;
                    closest = (diffLow < diffHigh) ? i - 1 : i;
                    break;
                }
            }
            sb.append(closest).append("\n");
        }
        System.out.print(sb);
    }
}

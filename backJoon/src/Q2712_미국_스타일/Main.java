package Q2712_미국_스타일;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            double value = Double.parseDouble(stk.nextToken());
            String unit = stk.nextToken();
            double result = 0;
            if (unit.equals("kg")) {
                result = value * 2.2046;
                sb.append(String.format("%.4f lb\n", result));
            } else if (unit.equals("lb")) {
                result = value * 0.4536;
                sb.append(String.format("%.4f kg\n", result));
            } else if (unit.equals("l")) {
                result = value * 0.2642;
                sb.append(String.format("%.4f g\n", result));
            } else if (unit.equals("g")) {
                result = value * 3.7854;
                sb.append(String.format("%.4f l\n", result));
            }
        }
        System.out.println(sb);
    }
}

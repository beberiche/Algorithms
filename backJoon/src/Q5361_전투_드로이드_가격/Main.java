package Q5361_전투_드로이드_가격;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] prices = new double[5];
        prices[0] = 350.34;
        prices[1] = 230.90;
        prices[2] = 190.55;
        prices[3] = 125.30;
        prices[4] = 180.90;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            double sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += prices[j] * Integer.parseInt(stk.nextToken());
            }
            sb.append("$").append(String.format("%.2f", sum)).append("\n");
        }
        System.out.print(sb);
    }
}

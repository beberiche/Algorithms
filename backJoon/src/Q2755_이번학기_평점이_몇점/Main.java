package Q2755_이번학기_평점이_몇점;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Double> m = new HashMap<>();
        char ch = 'A';
        double score = 4.3;
        for (int i = 0; i < 4; i++) {
            String k1 = ch + "+";
            m.put(k1, score);
            score -= 0.3;

            String k2 = ch + "0";
            m.put(k2, score);
            score -= 0.3;

            String k3 = ch + "-";
            m.put(k3, score);
            ch++;
            score -= 0.4;
        }
        m.put("F", 0.0d);

        long num_sum = 0;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            stk.nextToken();
            int num = Integer.parseInt(stk.nextToken());
            double d = m.get(stk.nextToken());
            num_sum += num;
            sum += (num * d);
        }
        System.out.printf("%.2f", sum / num_sum);
    }
}

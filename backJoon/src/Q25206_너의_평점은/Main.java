package Q25206_너의_평점은;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<String, Double> m = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double ret1 = 0;
        double ret2 = 0;
        m.put("A+", 4.5);
        m.put("A0", 4.0);
        m.put("B+", 3.5);
        m.put("B0", 3.0);
        m.put("C+", 2.5);
        m.put("C0", 2.0);
        m.put("D+", 1.5);
        m.put("D0", 1.0);
        m.put("F", 0.0);
        for (int i = 0; i < 20; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            stk.nextToken();
            double num = Double.parseDouble(stk.nextToken());
            String s = stk.nextToken();
            if (!s.equals("P")) {
                ret1 += num;
                ret2 += m.get(s) * num;
            }
        }
        System.out.printf("%.6f", ret2 / ret1);
    }
}

package Q1225_이상한_곱셈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        String s1 = stk.nextToken();
        String s2 = stk.nextToken();

        long num = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                num += (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
            }
        }

        System.out.println(num);
    }
}

package Q1964_오각형_오각형_오각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int l1 = 1;
        int l2 = 0;
        int l3 = 0;
        int sum = l1 + l2 + l3;
        final int DIV = 45678;
        for (int i = 1; i <= N; i++) {
            sum = sum % DIV + (++l1 % DIV) + (++l2 % DIV) + (++l3 % DIV);
            sum %= DIV;
        }
        System.out.println(sum);
    }
}

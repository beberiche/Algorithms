package Q2052_지수연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigDecimal n1 = new BigDecimal(Math.pow(0.5,N));
        System.out.println(n1.setScale(N,BigDecimal.ROUND_HALF_UP).toPlainString());
    }
}

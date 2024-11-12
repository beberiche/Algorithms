package Q1247_부호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 3;
        StringBuilder sb = new StringBuilder();
        while (--T >= 0) {
            int N = Integer.parseInt(br.readLine());
            BigInteger sum = new BigInteger("0");

            while (--N >= 0) {
                sum = sum.add(new BigInteger(br.readLine()));
            }

            int cal = sum.compareTo(BigInteger.ZERO);
            sb.append(cal == 0 ? 0 : cal == -1 ? "-" : "+").append("\n");
        }

        System.out.print(sb.toString());
    }
}

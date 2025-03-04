package Q2547_사탕_선생_고창영;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            br.readLine();
            int n = Integer.parseInt(br.readLine());

            BigInteger sum = new BigInteger("0");

            for (int j = 0; j < n; j++) {
                sum = sum.add(BigInteger.valueOf(Long.parseLong(br.readLine())));
            }
            sb.append(String.valueOf(sum.remainder(BigInteger.valueOf(n))).equals("0") ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }
}

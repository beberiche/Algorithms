package Q4238_기초_나머지_계산;

import java.io.BufferedReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        while (true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(stk.nextToken());

            if (b == 0) break;
            BigInteger p = new BigInteger(stk.nextToken(), b);
            BigInteger m = new BigInteger(stk.nextToken(), b);

            BigInteger mod = p.mod(m);
            sb.append(go(mod, b)).append("\n");
        }

        System.out.print(sb);
    }

    private static String go(BigInteger mod, int base) {
        if (mod.equals(BigInteger.ZERO)) {
            return "0";
        }

        BigInteger b = BigInteger.valueOf(base);
        StringBuilder sb = new StringBuilder();
        while (mod.compareTo(b) >= 0) {
            sb.append(mod.mod(b));
            mod = mod.divide(b);
        }
        sb.append(mod);
        return sb.reverse().toString();
    }
}

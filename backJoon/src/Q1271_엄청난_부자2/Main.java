package Q1271_엄청난_부자2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        BigDecimal N = new BigDecimal(stk.nextToken());
        BigDecimal M = new BigDecimal(stk.nextToken());

        BigDecimal[] a = N.divideAndRemainder(M);
        System.out.println(a[0]);
        System.out.println(a[1]);
    }
}

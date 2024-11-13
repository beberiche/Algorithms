package Q1252_이진수_덧셈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        String A = stk.nextToken();
        String B = stk.nextToken();

        BigInteger a1 = new BigInteger(A, 2);
        BigInteger b1 = new BigInteger(B, 2);

        BigInteger sum = a1.add(b1);

        System.out.println(sum.toString(2));
    }
}

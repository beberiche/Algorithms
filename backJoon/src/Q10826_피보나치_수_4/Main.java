package Q10826_피보나치_수_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==0) {
            System.out.println(0);
            return;
        }
        BigInteger[] a = new BigInteger[N + 1];
        a[0] = new BigInteger("0");
        a[1] = new BigInteger("1");
        for (int i = 2; i <= N; i++) {
            a[i] = a[i - 1].add(a[i - 2]);
        }
        System.out.println(a[N]);
    }
}

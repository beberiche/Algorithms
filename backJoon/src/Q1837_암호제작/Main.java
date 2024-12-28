package Q1837_암호제작;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        BigInteger pq = new BigInteger(stk.nextToken());
        BigInteger k = new BigInteger(stk.nextToken());
        BigInteger i = new BigInteger("1");

        StringBuilder sb = new StringBuilder();
        while (true){
            if (i.compareTo(k) == 1 || i.compareTo(k) == 0){
                sb.append("GOOD");
                break;
            }

            i = i.add(BigInteger.ONE);

            if (pq.remainder(i).compareTo(BigInteger.ZERO) == 0 && i.compareTo(k) == -1){
                sb.append("BAD").append(" ").append(i);
                break;
            }
        }

        System.out.print(sb);
    }
}

package Q3724_표;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(stk.nextToken());
            int r = Integer.parseInt(stk.nextToken());
            BigInteger[] arr = new BigInteger[c];
            Arrays.fill(arr, BigInteger.ONE);
            while (r-->0) {
                stk = new StringTokenizer(br.readLine());
                for (int i = 0; i < c; i++) {
                    arr[i] = arr[i].multiply(new BigInteger(stk.nextToken()));
                }
            }
            BigInteger max = arr[0];
            int maxIdx = 0;
            for (int i = 1; i < c; i++) {
                if (max.compareTo(arr[i])<=0) {
                    max = arr[i];
                    maxIdx = i;
                }
            }
            sb.append(maxIdx+1).append('\n');
        }
        System.out.print(sb);
    }
}

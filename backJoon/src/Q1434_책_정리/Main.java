package Q1434_책_정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int n1 = 0;
        int n2 = 0;

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            n1 += Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            n2 += Integer.parseInt(stk.nextToken());
        }

        System.out.println(n1-n2);
    }
}

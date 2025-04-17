package Q2965_캥거루_세마리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());

        System.out.println(Math.max((B - A), (C - B)) - 1);
    }
}

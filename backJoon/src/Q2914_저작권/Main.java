package Q2914_저작권;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(stk.nextToken());
        int I = Integer.parseInt(stk.nextToken());
        System.out.println(A * (I - 1) + 1);
    }
}

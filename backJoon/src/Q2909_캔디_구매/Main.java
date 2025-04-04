package Q2909_캔디_구매;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        double num = Math.pow(10, K);
        System.out.println((int) ((int) Math.round(C / num) * num));
    }
}

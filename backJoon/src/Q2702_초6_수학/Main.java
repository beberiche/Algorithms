package Q2702_초6_수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (--T >= 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            if (n1 < n2) {
                int tmp = n1;
                n1 = n2;
                n2 = tmp;
            }
            int ret = gcd(n1, n2);
            sb.append(n1*n2/ret).append(" ").append(ret).append("\n");
        }
        System.out.print(sb);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

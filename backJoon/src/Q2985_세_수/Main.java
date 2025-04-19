package Q2985_세_수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        if (a + b == c) System.out.printf("%d+%d=%d", a, b, c);
        else if (a - b == c) System.out.printf("%d-%d=%d", a, b, c);
        else if (a * b == c) System.out.printf("%d*%d=%d", a, b, c);
        else if (a / b == c) System.out.printf("%d/%d=%d", a, b, c);
        else if (a == b + c) System.out.printf("%d=%d+%d", a, b, c);
        else if (a == b - c) System.out.printf("%d=%d-%d", a, b, c);
        else if (a == b * c) System.out.printf("%d=%d*%d", a, b, c);
        else if (a == b / c) System.out.printf("%d=%d/%d", a, b, c);
    }
}

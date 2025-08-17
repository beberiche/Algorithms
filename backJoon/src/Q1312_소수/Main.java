package Q1312_소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());
        int N = Integer.parseInt(stk.nextToken());

        int result = 0;
        for (int i = 0; i < N; i++) {
            A = A % B;
            A *= 10;
            result = A / B;
        }
        System.out.println(result);
    }
}

package Q2355_시그마;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        long A = Long.parseLong(stk.nextToken());
        long B = Long.parseLong(stk.nextToken());
        long num = A <= B ? (B - A) : (A - B);
        System.out.println((num + 1) * (B + A) / 2);
    }
}

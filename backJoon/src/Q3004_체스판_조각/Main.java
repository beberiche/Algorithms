package Q3004_체스판_조각;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int p = 1;
        int a = 1;
        for (int i = 0; i < N; i++) {
            if (i % 2 != 0) {
                a += 1;
            }
            p += a;
        }
        System.out.print(p);
    }
}
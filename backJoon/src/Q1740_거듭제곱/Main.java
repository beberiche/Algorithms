package Q1740_거듭제곱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long num = 1;
        long ans = 0;

        while (N > 0) {
            if ((N & 1) == 1) {
                ans += num;
            }
            num *= 3;
            N >>= 1;
        }
        System.out.print(ans);
    }
}

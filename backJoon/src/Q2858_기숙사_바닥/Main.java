package Q2858_기숙사_바닥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());

        int L = 0;
        int W = 0;

        for (int i = 1; i <= B; i++) {
            if (B % i == 0) {
                L = B / i;
                W = i;

                if (2 * (L + W) + 4 == R) {
                    System.out.println(L + 2 + " " + (W + 2));
                    break;
                }
            }
        }
    }
}

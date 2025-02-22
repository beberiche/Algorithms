package Q2520_팬케이크_사랑;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static double[] needPancake = {0.5, 0.5, 0.25, 0.0625, 0.5625};
    static int[] needTopping = {1, 30, 25, 10};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());

            double canMake1 = 0;
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int n = Integer.parseInt(stk.nextToken());
                n /= needPancake[j];
                if (j == 0 || n < canMake1) canMake1 = n;
            }

            int canMake2 = 0;
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int n = Integer.parseInt(stk.nextToken());
                canMake2 += (n / needTopping[j]);
            }
            sb.append((int) Math.min(canMake1, canMake2)).append("\n");
        }
        System.out.print(sb);
    }
}
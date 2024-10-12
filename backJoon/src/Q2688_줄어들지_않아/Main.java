package Q2688_줄어들지_않아;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        long[][] dp = new long[65][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = j; k < dp[0].length; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        while (--T >= 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(Arrays.stream(dp[num]).sum()).append("\n");
        }
        System.out.print(sb.toString());
    }
}

package Q2156_포도주_시식;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        if (N == 1) {
            answer = arr[1];
        } else if (N == 2) {
            answer = arr[1] + arr[2];
        } else {
            int[][] dp = new int[N + 1][3];
            dp[3][0] = arr[1] + arr[2];
            dp[3][1] = arr[1] + arr[3];
            dp[3][2] = arr[2] + arr[3];

            for (int i = 4; i <= N; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
                dp[i][1] = dp[i - 1][0] + arr[i];
                dp[i][2] = dp[i - 1][1] + arr[i];
            }
            for (int i = 0; i < 3; i++) {
                answer = Math.max(answer, dp[N][i]);
            }

        }

        System.out.println(answer);

    }
}

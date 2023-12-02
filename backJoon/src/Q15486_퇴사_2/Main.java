package Q15486_퇴사_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
        }

        int dp[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            int t = arr[i][0];
            int val = arr[i][1];
            if (i + t - 1 <= N) {
                dp[i + t - 1] = Math.max(dp[i + t - 1], dp[i - 1] + val);
            }
        }
        System.out.println(dp[N]);
    }
}

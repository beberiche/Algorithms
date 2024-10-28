package Q10211_Maximum_Subarray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (--T >= 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int[] arr = new int[N + 1];
            int[] dp = new int[N + 1];

            arr[1] = Integer.parseInt(stk.nextToken());
            dp[1] = arr[1];
            int ans = dp[1];
            for (int i = 2; i <= N; i++) {
                arr[i] = Integer.parseInt(stk.nextToken());
                dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
                ans = Math.max(ans, dp[i]);
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }
}

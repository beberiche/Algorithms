package Q13398_연속합_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][2];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(stk.nextToken());
        dp[0][0] = num;
        dp[0][1] = num;
        int ret = num;
        for (int i = 1; i < N; i++) {
            num = Integer.parseInt(stk.nextToken());
            dp[i][0] = Math.max(dp[i - 1][0] + num, num);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + num);
            ret = Math.max(Math.max(dp[i][0], dp[i][1]), ret);
        }
        System.out.println(ret);
    }
}

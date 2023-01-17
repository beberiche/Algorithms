package Q3316_동아리실_관리하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int INF = 1000000007;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            int len = str.length();
            int[][] dp = new int[len][16];

            int currAd = 1 << str.charAt(0) - 'A';
            for (int i = 1; i < 16; i++) {
                if ((i & currAd) > 0 && (i & 1) > 0) {
                    dp[0][i] = 1;
                }
            }

            for (int i = 1; i < len; i++) {
                currAd = 1 << str.charAt(i) - 'A';
                for (int j = 1; j < 16; j++) {
                    if (dp[i - 1][j] > 0) {
                        for (int k = 1; k < 16; k++) {
                            if ((j & k) > 0 && (k & currAd) > 0) {
                                dp[i][k] += dp[i - 1][j];
                                dp[i][k] %= INF;
                            }
                        }
                    }
                }
            }
            int ans = 0;
            for (int i = 1; i < 16; i++) {
                ans += dp[len - 1][i];
                ans %= INF;
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
}

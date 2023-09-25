package Q9252_LCS_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// LCS
// DP 정보를 이용한 역추적
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chArr1 = br.readLine().toCharArray();
        char[] chArr2 = br.readLine().toCharArray();

        int[][] dp = new int[chArr1.length + 1][chArr2.length + 1];

        for (int i = 1; i <= chArr1.length; i++) {
            for (int j = 1; j <= chArr2.length; j++) {
                if (chArr1[i - 1] == chArr2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int r = chArr1.length;
        int c = chArr2.length;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (r == 0 || c == 0) break;

            if (dp[r][c] == dp[r - 1][c]) {
                r--;
            } else if (dp[r][c] == dp[r][c - 1]) {
                c--;
            } else {
                sb.append(chArr1[r - 1]);
                r--;
                c--;
            }
        }

        System.out.println(dp[chArr1.length][chArr2.length]);
        System.out.println(sb.reverse().toString());


    }
}

package Q1958_LCS_3;

import java.util.Scanner;

public class Main {
//    private static String go(String str1, String str2) {
//        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
//        String ret = "";
//        for (int i = 1; i <= str1.length(); i++) {
//            for (int j = 1; j <= str2.length(); j++) {
//                int ch1 = str1.charAt(i - 1);
//                int ch2 = str2.charAt(j - 1);
//                if (ch1 == ch2) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
//                }
//            }
//        }
//
//        int x = str1.length();
//        int y = str2.length();
//
//        StringBuilder sb = new StringBuilder();
//        while (dp[x][y] != 0) {
//            if (dp[x - 1][y] == dp[x][y - 1]) {
//                sb.append(str1.charAt(x - 1));
//                x--;
//                y--;
//            } else if (dp[x - 1][y] > dp[x][y - 1]) {
//                x--;
//            } else {
//                y--;
//            }
//        }
//
//        return sb.reverse().toString();
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();


//        int ret1 = go(go(str1, str2), str3).length();
//        int ret2 = go(go(str2, str3), str1).length();
//        int ret3 = go(go(str3, str1), str2).length();

        int[][][] dp = new int[str1.length() + 1][str2.length() + 1][str3.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            char ch1 = str1.charAt(i - 1);
            for (int j = 1; j <= str2.length(); j++) {
                char ch2 = str2.charAt(j - 1);
                for (int k = 1; k <= str3.length(); k++) {
                    char ch3 = str3.charAt(k - 1);

                    if (ch1 == ch2 && ch2 == ch3) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], Math.max(dp[i][j][k - 1], Math.max(dp[i - 1][j - 1][k], Math.max(dp[i - 1][j][k - 1], dp[i][j - 1][k - 1])))));
                    }
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()][str3.length()]);
    }
}

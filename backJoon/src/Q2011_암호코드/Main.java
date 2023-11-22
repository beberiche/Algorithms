package Q2011_암호코드;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int N = str.length();
        int arr[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = str.charAt(i - 1) - '0';
        }
        int dp[] = new int[N + 1];
        int div = (int) 1e6;

        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            if (arr[i] != 0) {
                dp[i] += dp[i - 1];
                dp[i] %= div;
            }

            int num = arr[i] + arr[i - 1] * 10;
            if (10 <= num && num <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= div;
            }
        }

        System.out.println(dp[N]);
    }
}

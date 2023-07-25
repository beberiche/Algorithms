package Q11727_2xn_타일링_2;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 1) {
            System.out.print(1);
            return;
        } else if (N == 2) {
            System.out.print(3);
            return;
        } else {
            int dp[] = new int[N + 1];
            dp[1] = 1;
            dp[2] = 3;

            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
            }
            System.out.print(dp[N]);
        }
    }
}

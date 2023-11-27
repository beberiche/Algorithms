package Q24416_알고리즘_수업_피보나치_수_1;

import java.util.Scanner;

public class Main {
    static int dp[], cnt2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt1 = recur1(N);

        dp = new int[N + 1];
        recur2(N);
        System.out.println(cnt1 + " " + cnt2);
    }

    private static int recur1(int N) {
        if (N <= 2) return 1;
        return recur1(N - 1) + recur1(N - 2);
    }

    private static int recur2(int N) {
        if (N <= 2) return dp[N] = 1;
        else if(dp[N]!=0) return dp[N];

        cnt2++;
        return dp[N] = recur2(N-2) + recur2(N-1);
    }
}

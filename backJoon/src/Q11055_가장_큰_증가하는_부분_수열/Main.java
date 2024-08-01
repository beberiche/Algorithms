package Q11055_가장_큰_증가하는_부분_수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        dp[1] = a[1];
        for (int i = 1; i <= N; i++) {
            dp[i] = a[i];
            for (int j = 1; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[j] + a[i], dp[i]);
                }
            }
        }

        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        System.out.println(max);
    }
}

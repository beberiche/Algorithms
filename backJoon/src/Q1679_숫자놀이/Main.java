package Q1679_숫자놀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        final int max = 1000;
        int[] dp = new int[max];
        Arrays.fill(dp, max); // 숫자게임에서 사용되는 최대 수는 1000, 만들어질 수 있는 최대갯수도 1000이다.
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
            dp[a[i]] = 1;
        }
        int K = Integer.parseInt(br.readLine());
        dp[1] = 1;
        int phase = 2;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < N; j++) {
                if (i - a[j] > 0) {
                    dp[i] = Math.min(dp[i], dp[i - a[j]] + 1);
                }
            }
            phase = i;
            if (dp[i] > K) break;
        }

        String win = phase % 2 == 0 ? "holsoon" : "jjaksoon";
        System.out.printf("%s win at %d", win, phase);
    }
}
